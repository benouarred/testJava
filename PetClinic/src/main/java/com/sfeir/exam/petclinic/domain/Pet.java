package com.sfeir.exam.petclinic.domain;

import com.sfeir.exam.petclinic.reference.PetType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pet {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Version
    @Column(name = "version")
    private Integer version;
	
    @NotNull
    private boolean sendReminders;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Min(0L)
    private Float weight;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn
    private Owner owner;

    @NotNull
    @Enumerated
    private PetType type;
    
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
    
    public boolean isSendReminders() {
        return this.sendReminders;
    }
    
    public void setSendReminders(boolean sendReminders) {
        this.sendReminders = sendReminders;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Float getWeight() {
        return this.weight;
    }
    
    public void setWeight(Float weight) {
        this.weight = weight;
    }
    
    public Owner getOwner() {
        return this.owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    public PetType getType() {
        return this.type;
    }
    
    public void setType(PetType type) {
        this.type = type;
    }    
    
    public String toString() {
        StringBuilder sb = new StringBuilder(getName()).append(", ")
                .append(getType());
        return sb.toString();
    }
}
