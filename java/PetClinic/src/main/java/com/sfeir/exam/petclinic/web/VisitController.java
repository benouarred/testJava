package com.sfeir.exam.petclinic.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

import com.sfeir.exam.petclinic.dao.PetDao;
import com.sfeir.exam.petclinic.dao.VetDao;
import com.sfeir.exam.petclinic.dao.VisitDao;
import com.sfeir.exam.petclinic.domain.Pet;
import com.sfeir.exam.petclinic.domain.Vet;
import com.sfeir.exam.petclinic.domain.Visit;

@RequestMapping("/visits")
@Controller
public class VisitController {

	@Autowired
	private VisitDao visitDao;
	
	@Autowired
	private PetDao petDao;
	
	@Autowired
	private VetDao vetDao;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Visit visit, BindingResult result,
			ModelMap modelMap) {
		if (visit == null)
			throw new IllegalArgumentException("A visit is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("visit", visit);
			addDateTimeFormatPatterns(modelMap);
			return "visits/create";
		}
		visitDao.persist(visit);
		return "redirect:/visits/" + visit.getId();
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("visit", new Visit());
		addDateTimeFormatPatterns(modelMap);
		List<String[]> dependencies = new ArrayList<String[]>();
		if (petDao.countPets() == 0) {
			dependencies.add(new String[] { "pet", "pets" });
		}
		modelMap.addAttribute("dependencies", dependencies);
		return "visits/create";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		addDateTimeFormatPatterns(modelMap);
		modelMap.addAttribute("visit", visitDao.findVisit(id));
		return "visits/show";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			ModelMap modelMap) {
		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			modelMap.addAttribute("visits", visitDao.findVisitEntries(
					page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
			float nrOfPages = (float) visitDao.countVisits() / sizeNo;
			modelMap.addAttribute(
					"maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
							: nrOfPages));
		} else {
			modelMap.addAttribute("visits", visitDao.findAllVisits());
		}
		addDateTimeFormatPatterns(modelMap);
		return "visits/list";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Visit visit, BindingResult result,
			ModelMap modelMap) {
		if (visit == null)
			throw new IllegalArgumentException("A visit is required");
		if (result.hasErrors()) {
			modelMap.addAttribute("visit", visit);
			addDateTimeFormatPatterns(modelMap);
			return "visits/update";
		}
		visitDao.merge(visit);
		return "redirect:/visits/" + visit.getId();
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		modelMap.addAttribute("visit", visitDao.findVisit(id));
		addDateTimeFormatPatterns(modelMap);
		return "visits/update";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		if (id == null)
			throw new IllegalArgumentException("An Identifier is required");
		visitDao.remove(id);
		return "redirect:/visits?page="
				+ ((page == null) ? "1" : page.toString()) + "&size="
				+ ((size == null) ? "10" : size.toString());
	}

	@RequestMapping(params = { "find=ByDescriptionAndVisitDate", "form" }, method = RequestMethod.GET)
	public String findVisitsByDescriptionAndVisitDateForm(ModelMap modelMap) {
		addDateTimeFormatPatterns(modelMap);
		return "visits/findVisitsByDescriptionAndVisitDate";
	}

	@RequestMapping(params = "find=ByDescriptionAndVisitDate", method = RequestMethod.GET)
	public String findVisitsByDescriptionAndVisitDate(
			@RequestParam("description") String description,
			@RequestParam("visitDate") @org.springframework.format.annotation.DateTimeFormat(style = "S-") Date visitDate,
			ModelMap modelMap) {
		if (description == null || description.length() == 0)
			throw new IllegalArgumentException("A Description is required.");
		if (visitDate == null)
			throw new IllegalArgumentException("A VisitDate is required.");
		modelMap.addAttribute("visits", visitDao
				.findVisitsByDescriptionAndVisitDate(description, visitDate)
				.getResultList());
		addDateTimeFormatPatterns(modelMap);
		return "visits/list";
	}

	@RequestMapping(params = { "find=ByVisitDateBetween", "form" }, method = RequestMethod.GET)
	public String findVisitsByVisitDateBetweenForm(ModelMap modelMap) {
		addDateTimeFormatPatterns(modelMap);
		return "visits/findVisitsByVisitDateBetween";
	}

	@RequestMapping(params = "find=ByVisitDateBetween", method = RequestMethod.GET)
	public String findVisitsByVisitDateBetween(
			@RequestParam("minVisitDate") @org.springframework.format.annotation.DateTimeFormat(style = "S-") Date minVisitDate,
			@RequestParam("maxVisitDate") @org.springframework.format.annotation.DateTimeFormat(style = "S-") Date maxVisitDate,
			ModelMap modelMap) {
		if (minVisitDate == null)
			throw new IllegalArgumentException("A MinVisitDate is required.");
		if (maxVisitDate == null)
			throw new IllegalArgumentException("A MaxVisitDate is required.");
		modelMap.addAttribute(
				"visits",
				visitDao.findVisitsByVisitDateBetween(minVisitDate,
						maxVisitDate).getResultList());
		addDateTimeFormatPatterns(modelMap);
		return "visits/list";
	}

	@RequestMapping(params = { "find=ByDescriptionLike", "form" }, method = RequestMethod.GET)
	public String findVisitsByDescriptionLikeForm(ModelMap modelMap) {
		return "visits/findVisitsByDescriptionLike";
	}

	@RequestMapping(params = "find=ByDescriptionLike", method = RequestMethod.GET)
	public String findVisitsByDescriptionLike(
			@RequestParam("description") String description, ModelMap modelMap) {
		if (description == null || description.length() == 0)
			throw new IllegalArgumentException("A Description is required.");
		modelMap.addAttribute("visits",
				visitDao.findVisitsByDescriptionLike(description)
						.getResultList());
		return "visits/list";
	}

	@ModelAttribute("pets")
	public Collection<Pet> populatePets() {
		return petDao.findAllPets();
	}

	@ModelAttribute("vets")
	public Collection<Vet> populateVets() {
		return vetDao.findAllVets();
	}

    Converter<Pet, String> getPetConverter() {
        return new Converter<Pet, String>() {
            public String convert(Pet pet) {
                return new StringBuilder().append(pet.getName()).append(" ")
                        .append(pet.getWeight()).toString();
            }
        };
    }

    Converter<String, Pet> getPetStringConverter() {
        return new Converter<String, Pet>() {
            public Pet convert(String petIdStr) {
                return petDao.findPet(Long.parseLong(petIdStr));
            }
        };
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

    Converter<String, Vet> getVetStringConverter() {
        return new Converter<String, Vet>() {
            public Vet convert(String vetIdStr) {
                return vetDao.findVet(Long.parseLong(vetIdStr));
            }
        };
    }

	Converter<Visit, String> getVisitConverter() {
		return new Converter<Visit, String>() {
			public String convert(Visit visit) {
				return new StringBuilder().append(visit.getDescription())
						.append(" ").append(visit.getVisitDate()).toString();
			}
		};
	}

	@InitBinder
	void registerConverters(WebDataBinder binder) {
		if (binder.getConversionService() instanceof GenericConversionService) {
			GenericConversionService conversionService = (GenericConversionService) binder
					.getConversionService();
			conversionService.addConverter(getPetConverter());
            conversionService.addConverter(getPetStringConverter());
			conversionService.addConverter(getVetConverter());
            conversionService.addConverter(getVetStringConverter());
			conversionService.addConverter(getVisitConverter());
		}
	}

	void addDateTimeFormatPatterns(ModelMap modelMap) {
		modelMap.addAttribute(
				"visit_maxvisitdate_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
		modelMap.addAttribute(
				"visit_minvisitdate_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
		modelMap.addAttribute(
				"visit_visitdate_date_format",
				DateTimeFormat.patternForStyle("S-",
						LocaleContextHolder.getLocale()));
	}

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}

	public void setVetDao(VetDao vetDao) {
		this.vetDao = vetDao;
	}
}
