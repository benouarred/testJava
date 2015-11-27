package com.sfeir.exam.petclinic.web;

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

import com.sfeir.exam.petclinic.dao.OwnerDao;
import com.sfeir.exam.petclinic.dao.PetDao;
import com.sfeir.exam.petclinic.domain.Owner;
import com.sfeir.exam.petclinic.domain.Pet;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private PetDao petDao;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Owner owner, BindingResult result,
			ModelMap modelMap) {
		if (owner == null)
			throw new IllegalArgumentException("A owner is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("owner", owner);
			addDateTimeFormatPatterns(modelMap);
			return "owners/create";
		}
		ownerDao.persist(owner);
		return "redirect:/owners/" + owner.getId();
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("owner", new Owner());
		addDateTimeFormatPatterns(modelMap);
		return "owners/create";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		addDateTimeFormatPatterns(modelMap);
		modelMap.addAttribute("owner", ownerDao.findOwner(id));
		return "owners/show";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			ModelMap modelMap) {
		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			modelMap.addAttribute("owners", ownerDao.findOwnerEntries(
					page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
			float nrOfPages = (float) ownerDao.countOwners() / sizeNo;
			modelMap.addAttribute(
					"maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
							: nrOfPages));
		} else {
			modelMap.addAttribute("owners", ownerDao.findAllOwners());
		}
		addDateTimeFormatPatterns(modelMap);
		return "owners/list";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Owner owner, BindingResult result,
			ModelMap modelMap) {
		if (owner == null)
			throw new IllegalArgumentException("A owner is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("owner", owner);
			addDateTimeFormatPatterns(modelMap);
			return "owners/update";
		}
		ownerDao.merge(owner);
		return "redirect:/owners/" + owner.getId();
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		modelMap.addAttribute("owner", ownerDao.findOwner(id));
		addDateTimeFormatPatterns(modelMap);
		return "owners/update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		ownerDao.remove(id);
		return "redirect:/owners?page="
				+ ((page == null) ? "1" : page.toString()) + "&size="
				+ ((size == null) ? "10" : size.toString());
	}

	@ModelAttribute("pets")
	public Collection<Pet> populatePets() {
		return petDao.findAllPets();
	}

	Converter<Owner, String> getOwnerConverter() {
		return new Converter<Owner, String>() {
			public String convert(Owner owner) {
				return new StringBuilder().append(owner.getFirstName())
						.append(" ").append(owner.getLastName()).append(" ")
						.append(owner.getAddress()).toString();
			}
		};
	}

	Converter<Pet, String> getPetConverter() {
		return new Converter<Pet, String>() {
			public String convert(Pet pet) {
				return new StringBuilder().append(pet.getName()).append(" ")
						.append(pet.getWeight()).toString();
			}
		};
	}

	@InitBinder
	void registerConverters(WebDataBinder binder) {
		if (binder.getConversionService() instanceof GenericConversionService) {
			GenericConversionService conversionService = (GenericConversionService) binder
					.getConversionService();
			conversionService.addConverter(getOwnerConverter());
			conversionService.addConverter(getPetConverter());
		}
	}

	void addDateTimeFormatPatterns(ModelMap modelMap) {
		modelMap.addAttribute(
				"owner_birthday_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
	}

	public void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}
}
