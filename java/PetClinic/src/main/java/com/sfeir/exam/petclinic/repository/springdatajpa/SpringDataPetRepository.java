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
package com.sfeir.exam.petclinic.repository.springdatajpa;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.sfeir.exam.petclinic.model.Pet;
import com.sfeir.exam.petclinic.model.PetType;
import com.sfeir.exam.petclinic.repository.PetRepository;

import java.util.Collection;
import java.util.List;

/**
 * Spring Data JPA specialization of the {@link PetRepository} interface
 *
 * @author Michael Isvy
 * @since 15.1.2013
 */
public interface SpringDataPetRepository extends PetRepository, Repository<Pet, Integer> {

    @Override
    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    List<PetType> findPetTypes() throws DataAccessException;

    @Override
    @Query("SELECT DISTINCT pet FROM Pet pet")
    Collection<Pet> findAll();
}
