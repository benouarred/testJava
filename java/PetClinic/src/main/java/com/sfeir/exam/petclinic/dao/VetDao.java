package com.sfeir.exam.petclinic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sfeir.exam.petclinic.domain.Vet;

@Repository
public class VetDao extends AbstractPersonDao{

	 	public long countVets() {
	        return ((Number) getEntityManager().createQuery("select count(o) from Vet o").getSingleResult()).longValue();
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Vet> findAllVets() {
	        return getEntityManager().createQuery("select o from Vet o").getResultList();
	    }
	    
	    public Vet findVet(Long id) {
	        if (id == null) return null;
	        return getEntityManager().find(Vet.class, id);
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Vet> findVetEntries(int firstResult, int maxResults) {
	        return getEntityManager().createQuery("select o from Vet o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }
	
}
