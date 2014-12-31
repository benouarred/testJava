package com.sfeir.exam.petclinic.api;

import com.sfeir.exam.petclinic.model.Pet;
import com.sfeir.exam.petclinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by Abdelkader Midani on 30/12/14.
 */
@Controller
@RequestMapping(value = "/rest/api")
public class PetApiController {

    private final ClinicService clinicService;

    @Autowired
    public PetApiController(ClinicService clinicService){
        this.clinicService = clinicService;
    }

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public @ResponseBody Collection<Pet> getPets(){
        return clinicService.getPets();
    }
}
