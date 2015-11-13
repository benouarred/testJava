package com.sfeir.exam.petclinic.dao;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Pet;
import com.sfeir.exam.petclinic.reference.PetType;

//@RooDataOnDemand(entity = Pet.class)
public class PetDataOnDemand {
	
	private Random rnd = new SecureRandom();
    
    private List<Pet> data;
    
    private PetDao dao;
    
    public PetDataOnDemand(PetDao dao) {
		super();
		this.dao = dao;
	}

	public Pet getNewTransientPet(int index) {
        Pet obj = new Pet();
        obj.setName("name_" + index);
        obj.setOwner(null);
        obj.setSendReminders(true);
        obj.setType(PetType.class.getEnumConstants()[0]);
        obj.setWeight(new Integer(index).floatValue());
        return obj;
    }
    
    public Pet getSpecificPet(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        Pet obj = data.get(index);
        return dao.findPet(obj.getId());
    }
    
    public Pet getRandomPet() {
        init();
        Pet obj = data.get(rnd.nextInt(data.size()));
        return dao.findPet(obj.getId());
    }
    
    public boolean modifyPet(Pet obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init() {
        if (data != null) {
            return;
        }
        
        data = dao.findPetEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Pet' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new ArrayList<Pet>();
        for (int i = 0; i < 10; i++) {
            Pet obj = getNewTransientPet(i);
            dao.persist(obj);
            data.add(obj);
        }
    }	
    
    public String getRandomName() {
    	return getRandomPet().getName();
    }
}
