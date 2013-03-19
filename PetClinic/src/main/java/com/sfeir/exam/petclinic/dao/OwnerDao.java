package com.sfeir.exam.petclinic.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sfeir.exam.petclinic.domain.Owner;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDao extends AbstractPersonDao {

    public long countOwners() {
    	Query query = getEntityManager().createQuery("SELECT count(o) FROM Owner o");
    	Number count = (Number) query.getSingleResult();
    	return count.longValue();
    }
    
    @SuppressWarnings("unchecked")
    public List<Owner> findAllOwners() {
    	Query query = getEntityManager().createQuery("from Owner o");
    	return query.getResultList();
    }
    
    public Owner findOwner(Long id) {
        Owner owner = getEntityManager().find(Owner.class, id);
        if(owner == null) {
        	throw new EmptyResultDataAccessException(1);
        }
		return owner;  
       }
    
    @SuppressWarnings("unchecked")
    public List<Owner> findOwnerEntries(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("to be implemented");
    }

}
