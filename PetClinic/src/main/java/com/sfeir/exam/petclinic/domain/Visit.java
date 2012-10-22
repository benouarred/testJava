package com.sfeir.exam.petclinic.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Visit {

    @Size(max = 255)
    private String description;

    @NotNull
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date visitDate;

    @NotNull
    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn
    private Pet pet;

    @ManyToOne(targetEntity = Vet.class)
    @JoinColumn
    private Vet vet;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Version
    @Column(name = "version")
    private Integer version;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getVisitDate() {
        return this.visitDate;
    }
    
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    
    public Pet getPet() {
        return this.pet;
    }
    
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public Vet getVet() {
        return this.vet;
    }
    
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Description: ").append(getDescription()).append(", ");
        sb.append("VisitDate: ").append(getVisitDate()).append(", ");
        sb.append("Pet: ").append(getPet()).append(", ");
        sb.append("Vet: ").append(getVet());
        return sb.toString();
    }
}
