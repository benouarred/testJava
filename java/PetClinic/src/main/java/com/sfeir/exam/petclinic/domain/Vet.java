package com.sfeir.exam.petclinic.domain;

import com.sfeir.exam.petclinic.reference.Specialty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Calendar;

@Entity
public class Vet extends AbstractPerson {

    @NotNull
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Calendar employedSince;

    @Enumerated
    private Specialty specialty;
    
    public Calendar getEmployedSince() {
        return this.employedSince;
    }
    
    public void setEmployedSince(Calendar employedSince) {
        this.employedSince = employedSince;
    }
    
    public Specialty getSpecialty() {
        return this.specialty;
    }
    
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder(getFirstName()).append(" ");
        sb.append(getLastName());
        return sb.toString();
    }
}
