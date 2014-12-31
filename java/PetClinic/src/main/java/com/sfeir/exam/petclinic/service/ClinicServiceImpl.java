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
package com.sfeir.exam.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import com.sfeir.exam.petclinic.model.*;
import com.sfeir.exam.petclinic.repository.OwnerRepository;
import com.sfeir.exam.petclinic.repository.PetRepository;
import com.sfeir.exam.petclinic.repository.VetRepository;
import com.sfeir.exam.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private PetRepository petRepository;
    private VetRepository vetRepository;
    private OwnerRepository ownerRepository;
    private VisitRepository visitRepository;

    @Autowired
    public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitRepository visitRepository) {
        this.petRepository = petRepository;
        this.vetRepository = vetRepository;
        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return petRepository.findPetTypes();
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findOwnerById(int id) throws DataAccessException {
        return ownerRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Collection<Owner> getOwners() {
        return ownerRepository.getOwners();
    }

    @Override
    @Transactional
    public void saveOwner(Owner owner) throws DataAccessException {
        ownerRepository.save(owner);
    }


    @Override
    @Transactional
    public void saveVisit(Visit visit) throws DataAccessException {
        visitRepository.save(visit);
    }

    @Override
    @Transactional()
    public Collection<Pet> getPets() throws DataAccessException {
        return petRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findPetById(int id) throws DataAccessException {
        return petRepository.findById(id);
    }

    @Override
    @Transactional
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "vets")
    public Collection<Vet> findVets() throws DataAccessException {
        return vetRepository.findAll();
    }


}
