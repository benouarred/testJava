/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sfeir.exam.petclinic.api;

import com.sfeir.exam.petclinic.model.Owner;
import com.sfeir.exam.petclinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Abdelkader Midani on 29/12/14.
 */
@Controller
@RequestMapping(value = "/rest/api")
public class OwnerApiController {

    private final ClinicService clinicService;


    @Autowired
    public OwnerApiController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public @ResponseBody Collection<Owner> getOwners() {
        // get owners
        return this.clinicService.getOwners();
    }

}
