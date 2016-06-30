package com.sfeir.exam.petclinic.web;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sfeir.exam.petclinic.reference.PetType;

@RequestMapping("/pets")
@Controller
public class PetController {

    @Autowired
    private PetDao petDao;

    @Autowired
    private OwnerDao ownerDao;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Pet pet, BindingResult result, ModelMap modelMap) {
        if (pet == null)
            throw new IllegalArgumentException("A pet is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pet", pet);
            return "pets/create";
        }
        petDao.persist(pet);
        return "redirect:/pets/" + pet.getId();
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        modelMap.addAttribute("pet", new Pet());
        return "pets/create";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null || id > 0)
            throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pet", petDao.findPet(id));
        return "pets/show";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("pets", petDao.findPetEntries(
                    page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) petDao.countPets() / sizeNo;
            modelMap.addAttribute(
                    "maxPages",
                    (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
                            : nrOfPages));
        } else {
            modelMap.addAttribute("pets", petDao.findAllPets());
        }
        return "pets/list";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Pet pet, BindingResult result, ModelMap modelMap) {
        if (pet == null)
            throw new IllegalArgumentException("A pet is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pet", pet);
            return "pets/update";
        }
        petDao.merge(pet);
        return "redirect:/pets/" + pet.getId();
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null)
            throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pet", petDao.findPet(id));
        return "pets/update";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id,
                         @RequestParam(value = "page", required = false) Integer page,
                         @RequestParam(value = "size", required = false) Integer size) {
        if (id == null)
            throw new IllegalArgumentException("An Identifier is required");
        petDao.remove(id);
        return "redirect:/pets?page="
                + ((page == null) ? "1" : page.toString()) + "&size="
                + ((size == null) ? "10" : size.toString());
    }

    @RequestMapping(params = {"find=ByNameAndWeight", "form"}, method = RequestMethod.GET)
    public String findPetsByNameAndWeightForm(ModelMap modelMap) {
        return "pets/findPetsByNameAndWeight";
    }

    @RequestMapping(params = "find=ByNameAndWeight", method = RequestMethod.GET)
    public String findPetsByNameAndWeight(@RequestParam("name") String name,
                                          @RequestParam("weight") Float weight, ModelMap modelMap) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("A Name is required.");
        if (weight == null)
            throw new IllegalArgumentException("A Weight is required.");
        modelMap.addAttribute("pets",
                petDao.findPetsByNameAndWeight(name, weight).getResultList());
        return "pets/list";
    }

    @RequestMapping(params = {"find=ByOwner", "form"}, method = RequestMethod.GET)
    public String findPetsByOwnerForm(ModelMap modelMap) {
        modelMap.addAttribute("owners", ownerDao.findAllOwners());
        return "pets/findPetsByOwner";
    }

    @RequestMapping(params = "find=ByOwner", method = RequestMethod.GET)
    public String findPetsByOwner(@RequestParam("owner") Owner owner,
                                  ModelMap modelMap) {
        if (owner == null)
            throw new IllegalArgumentException("A Owner is required.");
        modelMap.addAttribute("pets", petDao.findPetsByOwner(owner)
                .getResultList());
        return "pets/list";
    }

    @RequestMapping(params = {"find=BySendRemindersAndWeightLessThan", "form"}, method = RequestMethod.GET)
    public String findPetsBySendRemindersAndWeightLessThanForm(ModelMap modelMap) {
        return "pets/findPetsBySendRemindersAndWeightLessThan";
    }

    @RequestMapping(params = "find=BySendRemindersAndWeightLessThan", method = RequestMethod.GET)
    public String findPetsBySendRemindersAndWeightLessThan(
            @RequestParam(value = "sendReminders", required = false) boolean sendReminders,
            @RequestParam("weight") Float weight, ModelMap modelMap) {
        if (weight == null)
            throw new IllegalArgumentException("A Weight is required.");
        modelMap.addAttribute(
                "pets",
                petDao.findPetsBySendRemindersAndWeightLessThan(sendReminders,
                        weight).getResultList());
        return "pets/list";
    }

    @RequestMapping(params = {"find=ByTypeAndNameLike", "form"}, method = RequestMethod.GET)
    public String findPetsByTypeAndNameLikeForm(ModelMap modelMap) {
        modelMap.addAttribute("pettypes",
                java.util.Arrays.asList(PetType.class.getEnumConstants()));
        return "pets/findPetsByTypeAndNameLike";
    }

    @RequestMapping(params = "find=ByTypeAndNameLike", method = RequestMethod.GET)
    public String findPetsByTypeAndNameLike(@RequestParam("type") PetType type,
                                            @RequestParam("name") String name, ModelMap modelMap) {
        if (type == null)
            throw new IllegalArgumentException("A Type is required.");
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("A Name is required.");
        modelMap.addAttribute("pets",
                petDao.findPetsByTypeAndNameLike(type, name).getResultList());
        return "pets/list";
    }

    @ModelAttribute("owners")
    public Collection<Owner> populateOwners() {
        return ownerDao.findAllOwners();
    }

    @ModelAttribute("pettypes")
    public Collection<PetType> populatePetTypes() {
        return Arrays.asList(PetType.class.getEnumConstants());
    }

    Converter<Owner, String> getOwnerConverter() {
        return new Converter<Owner, String>() {
            public String convert(Owner owner) {
                return new StringBuilder().append(owner.getFirstName())
                        .append(" ").append(owner.getLastName()).toString();
            }
        };
    }

    Converter<String, Owner> getOwnerStringConverter() {
        return new Converter<String, Owner>() {
            public Owner convert(String ownerIdStr) {
                return ownerDao.findOwner(Long.parseLong(ownerIdStr));
            }
        };
    }

    Converter<Pet, String> getPetConverter() {
        return new Converter<Pet, String>() {
            public String convert(Pet pet) {
                return new StringBuilder().append(pet.getName())
                        .append(" ")
                        .append(pet.getWeight())
                        .toString();
            }
        };
    }

    @InitBinder
    void registerConverters(WebDataBinder binder) {
        if (binder.getConversionService() instanceof GenericConversionService) {
            GenericConversionService conversionService = (GenericConversionService) binder.getConversionService();
            conversionService.addConverter(getOwnerConverter());
            conversionService.addConverter(getOwnerStringConverter());
            conversionService.addConverter(getPetConverter());
        }
    }

    public void setPetDao(PetDao petDao) {
        this.petDao = petDao;
    }

    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
}
