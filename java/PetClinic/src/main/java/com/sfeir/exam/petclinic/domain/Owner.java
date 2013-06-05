package com.sfeir.exam.petclinic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Owner extends AbstractPerson {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<com.sfeir.exam.petclinic.domain.Pet> pets = new java.util.HashSet<com.sfeir.exam.petclinic.domain.Pet>();
    
    public Set<Pet> getPets() {
        return this.pets;
    }
    
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder(getFirstName()).append(" ");
        sb.append(getLastName());
        return sb.toString();
    }
    
}
