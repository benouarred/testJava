package com.sfeir.exam.petclinic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Owner;
import com.sfeir.exam.petclinic.domain.Pet;
import com.sfeir.exam.petclinic.reference.PetType;

@Repository
public class PetDao  {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public void persist(Pet pet) {
        this.entityManager.persist(pet);
        this.entityManager.flush();
    }

    @Transactional
    public void remove(Long id) {
        Pet attached = this.entityManager.find(Pet.class, id);
        if (attached != null)
            this.entityManager.remove(attached);
    }

    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public Pet merge(Pet pet) {
        Pet merged = this.entityManager.merge(pet);
        this.entityManager.flush();
        return merged;
    }

    public long countPets() {
        return ((Number) getEntityManager().createQuery("select count(o) from Pet o").getSingleResult()).longValue();
    }

    @SuppressWarnings("unchecked")
    public List<Pet> findAllPets() {
        return getEntityManager().createQuery("select o from Pet o").getResultList();
    }

    public Pet findPet(Long id) {
        if (id == null) return null;
        return entityManager.find(Pet.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Pet> findPetEntries(int firstResult, int maxResults) {
        return getEntityManager().createQuery("select o from Pet o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public Query findPetsByOwner(Owner owner) {
    	if (owner == null) throw new IllegalArgumentException("The owner argument is required");
    	Query q = getEntityManager().createQuery("SELECT Pet FROM Pet AS pet WHERE pet.owner = :owner");
    	q.setParameter("owner", owner);
    	return q;
    }

    public Query findPetsByNameAndWeight(String name, Float weight) {
    	throw new UnsupportedOperationException("To be implemented");
    }
    
    public Query findPetsBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight) {
    	throw new UnsupportedOperationException("To be implemented");
    }

    public Query findPetsByTypeAndNameLike(PetType type, String name) {
    	throw new UnsupportedOperationException("To be implemented");
    }
}
