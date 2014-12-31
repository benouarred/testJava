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
package com.sfeir.exam.petclinic.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.sfeir.exam.petclinic.model.Owner;
import com.sfeir.exam.petclinic.model.Pet;
import com.sfeir.exam.petclinic.model.PetType;
import com.sfeir.exam.petclinic.model.Visit;
import com.sfeir.exam.petclinic.repository.OwnerRepository;
import com.sfeir.exam.petclinic.repository.PetRepository;
import com.sfeir.exam.petclinic.repository.VisitRepository;
import com.sfeir.exam.petclinic.util.EntityUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @author Thomas Risberg
 * @author Mark Fisher
 */
@Repository
@Profile("jdbc")
public class JdbcPetRepositoryImpl implements PetRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertPet;

    private OwnerRepository ownerRepository;

    private VisitRepository visitRepository;


    @Autowired
    public JdbcPetRepositoryImpl(DataSource dataSource, OwnerRepository ownerRepository, VisitRepository visitRepository) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        this.insertPet = new SimpleJdbcInsert(dataSource)
                .withTableName("pets")
                .usingGeneratedKeyColumns("id");

        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public List<PetType> findPetTypes() throws DataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        return this.namedParameterJdbcTemplate.query(
                "SELECT id, name FROM types ORDER BY name",
                params,
                ParameterizedBeanPropertyRowMapper.newInstance(PetType.class));
    }

    @Override
    public Pet findById(int id) throws DataAccessException {
        JdbcPet pet;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
            pet = this.namedParameterJdbcTemplate.queryForObject(
                    "SELECT id, name, birth_date, type_id, owner_id FROM pets WHERE id=:id",
                    params,
                    new JdbcPetRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(Pet.class, new Integer(id));
        }
        Owner owner = this.ownerRepository.findById(pet.getOwnerId());
        owner.addPet(pet);
        pet.setType(EntityUtils.getById(findPetTypes(), PetType.class, pet.getTypeId()));

        List<Visit> visits = this.visitRepository.findByPetId(pet.getId());
        for (Visit visit : visits) {
            pet.addVisit(visit);
        }
        return pet;
    }

    @Override
    public List<Pet> findAll() {
        List<JdbcPet> pets;

        try {
            pets = this.namedParameterJdbcTemplate.query(
                    "SELECT * FROM pets",
                    new HashMap<String, Object>(),
                    new JdbcPetRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(Pet.class,ex);
        }

        List<Pet> resultList = new ArrayList<Pet>();
        resultList.addAll(pets);

        return resultList;
    }

    @Override
    public void save(Pet pet) throws DataAccessException {
        if (pet.isNew()) {
            Number newKey = this.insertPet.executeAndReturnKey(
                    createPetParameterSource(pet));
            pet.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE pets SET name=:name, birth_date=:birth_date, type_id=:type_id, " +
                            "owner_id=:owner_id WHERE id=:id",
                    createPetParameterSource(pet));
        }
    }

    /**
     * Creates a {@link org.springframework.jdbc.core.namedparam.MapSqlParameterSource} based on data values from the supplied {@link Pet} instance.
     */
    private MapSqlParameterSource createPetParameterSource(Pet pet) {
        return new MapSqlParameterSource()
                .addValue("id", pet.getId())
                .addValue("name", pet.getName())
                .addValue("birth_date", pet.getBirthDate().toDate())
                .addValue("type_id", pet.getType().getId())
                .addValue("owner_id", pet.getOwner().getId());
    }

}
