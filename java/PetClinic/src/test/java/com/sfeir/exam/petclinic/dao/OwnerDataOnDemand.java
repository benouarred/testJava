package com.sfeir.exam.petclinic.dao;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Owner;

public class OwnerDataOnDemand {
	
	    private Random rnd = new SecureRandom();
	    
	    private OwnerDao dao;
	    
	    private List<Owner> data;
	    
	    public OwnerDataOnDemand(OwnerDao dao) {
			super();
			this.dao = dao;
		}

		public Owner getNewTransientOwner(int index) {
	        Owner obj = new Owner();
	        obj.setAddress("address_" + index);
	        obj.setBirthDay(new java.util.Date());
	        obj.setCity("city_" + index);
	        obj.setEmail(null);
	        obj.setFirstName(null);
	        obj.setHomePage(null);
	        obj.setLastName("lastName_" + index);
	        obj.setTelephone("telephone_" + index);
	        return obj;
	    }
	    
	    public Owner getSpecificOwner(int index) {
	        init();
	        if (index < 0) index = 0;
	        if (index > (data.size()-1)) index = data.size() - 1;
	        Owner obj = data.get(index);
	        return dao.findOwner(obj.getId());
	    }
	    
	    public Owner getRandomOwner() {
	        init();
	        Owner obj = data.get(rnd.nextInt(data.size()));
	        return dao.findOwner(obj.getId());
	    }
	    
	    public boolean modifyOwner(Owner obj) {
	        return false;
	    }
	    
	    @Transactional(propagation = Propagation.REQUIRES_NEW)
	    public void init() {
	    	
	        if (data != null) {
	            return;
	        }
	        
	        data = dao.findOwnerEntries(0, 10);
	        if (data == null) 
	        	throw new IllegalStateException("Find entries implementation for 'Owner' illegally returned null");
	        
	        if (data.size() > 0) {
	            return;
	        }
	        
	        data = new ArrayList<Owner>();
	        for (int i = 0; i < 10; i++) {
	            Owner obj = getNewTransientOwner(i);
	            dao.persist(obj);
	            data.add(obj);
	        }
	    }
}
