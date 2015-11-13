package com.sfeir.exam.petclinic.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sfeir.exam.petclinic.domain.Owner;

@Repository
public class OwnerDao extends AbstractPersonDao {

    public long countOwners() {
    	throw new UnsupportedOperationException("to be implemented");
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
    	return getEntityManager().createQuery("select o from Owner o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

}
