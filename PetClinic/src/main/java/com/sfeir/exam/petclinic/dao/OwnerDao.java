package com.sfeir.exam.petclinic.dao;

import java.util.List;

import com.sfeir.exam.petclinic.domain.Owner;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDao extends AbstractPersonDao {

    public long countOwners() {
        throw new UnsupportedOperationException("To be implemented");
    }
    
    @SuppressWarnings("unchecked")
    public List<Owner> findAllOwners() {
        throw new UnsupportedOperationException("To be implemented");
    }
    
    public Owner findOwner(Long id) {
        throw new UnsupportedOperationException("To be implemented");
    }
    
    @SuppressWarnings("unchecked")
    public List<Owner> findOwnerEntries(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("To be implemented");
    }

}
