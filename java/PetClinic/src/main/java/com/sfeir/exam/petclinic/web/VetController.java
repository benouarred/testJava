package com.sfeir.exam.petclinic.web;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sfeir.exam.petclinic.dao.VetDao;
import com.sfeir.exam.petclinic.domain.Vet;
import com.sfeir.exam.petclinic.reference.Specialty;

@RequestMapping("/vets")
@Controller
public class VetController {

	@Autowired
	private VetDao vetDao;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Vet vet, BindingResult result, ModelMap modelMap) {
		if (vet == null)
			throw new IllegalArgumentException("A vet is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("vet", vet);
			addDateTimeFormatPatterns(modelMap);
			return "vets/create";
		}
		vetDao.persist(vet);
		return "redirect:/vets/" + vet.getId();
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("vet", new Vet());
		addDateTimeFormatPatterns(modelMap);
		return "vets/create";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		addDateTimeFormatPatterns(modelMap);
		modelMap.addAttribute("vet", vetDao.findVet(id));
		return "vets/show";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			ModelMap modelMap) {
		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			modelMap.addAttribute("vets", vetDao.findVetEntries(
					page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
			float nrOfPages = (float) vetDao.countVets() / sizeNo;
			modelMap.addAttribute(
					"maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
							: nrOfPages));
		} else {
			modelMap.addAttribute("vets", vetDao.findAllVets());
		}
		addDateTimeFormatPatterns(modelMap);
		return "vets/list";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Vet vet, BindingResult result, ModelMap modelMap) {
		if (vet == null)
			throw new IllegalArgumentException("A vet is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("vet", vet);
			addDateTimeFormatPatterns(modelMap);
			return "vets/update";
		}
		vetDao.merge(vet);
		return "redirect:/vets/" + vet.getId();
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		modelMap.addAttribute("vet", vetDao.findVet(id));
		addDateTimeFormatPatterns(modelMap);
		return "vets/update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		vetDao.remove(id);
		return "redirect:/vets?page="
				+ ((page == null) ? "1" : page.toString()) + "&size="
				+ ((size == null) ? "10" : size.toString());
	}

	@ModelAttribute("specialtys")
	public Collection<Specialty> populateSpecialtys() {
		return Arrays.asList(Specialty.class.getEnumConstants());
	}

	Converter<Vet, String> getVetConverter() {
		return new Converter<Vet, String>() {
			public String convert(Vet vet) {
				return new StringBuilder().append(vet.getFirstName())
						.append(" ").append(vet.getLastName()).append(" ")
						.append(vet.getAddress()).toString();
			}
		};
	}

	@InitBinder
	void registerConverters(WebDataBinder binder) {
		if (binder.getConversionService() instanceof GenericConversionService) {
			GenericConversionService conversionService = (GenericConversionService) binder
					.getConversionService();
			conversionService.addConverter(getVetConverter());
		}
	}

	void addDateTimeFormatPatterns(ModelMap modelMap) {
		modelMap.addAttribute(
				"vet_birthday_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
		modelMap.addAttribute(
				"vet_employedsince_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
	}

	public void setVetDao(VetDao vetDao) {
		this.vetDao = vetDao;
	}

}
