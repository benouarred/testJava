package com.sfeir.exam.petclinic.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Vet;

public class VetDataOnDemand {
	
	   private Random rnd = new java.security.SecureRandom();
	    
	    private List<Vet> data;
	    
	    private VetDao dao;
	    
	    public VetDataOnDemand(VetDao dao) {
			super();
			this.dao = dao;
		}

		public Vet getNewTransientVet(int index) {
	        Vet obj = new Vet();
	        obj.setAddress("address_" + index);
	        obj.setBirthDay(new java.util.Date());
	        obj.setCity("city_" + index);
	        obj.setEmail(null);
	        obj.setEmployedSince(new java.util.GregorianCalendar(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), java.util.Calendar.getInstance().get(java.util.Calendar.MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) - 1));
	        obj.setFirstName(null);
	        obj.setHomePage(null);
	        obj.setLastName("lastName_" + index);
	        obj.setSpecialty(null);
	        obj.setTelephone("telephone_" + index);
	        return obj;
	    }
	    
	    public Vet getSpecificVet(int index) {
	        init();
	        if (index < 0) index = 0;
	        if (index > (data.size()-1)) index = data.size() - 1;
	        Vet obj = data.get(index);
	        return dao.findVet(obj.getId());
	    }
	    
	    public Vet getRandomVet() {
	        init();
	        Vet obj = data.get(rnd.nextInt(data.size()));
	        return dao.findVet(obj.getId());
	    }
	    
	    public boolean modifyVet(Vet obj) {
	        return false;
	    }
	    
	    @Transactional(propagation = Propagation.REQUIRES_NEW)
	    public void init() {
	    	
	        if (data != null) {
	            return;
	        }
	        
	        data = dao.findVetEntries(0, 10);
	        
	        if (data == null) 
	        	throw new IllegalStateException("Find entries implementation for 'Vet' illegally returned null");
	        
	        if (data.size() > 0) {
	            return;
	        }
	        
	        data = new ArrayList<Vet>();
	        for (int i = 0; i < 10; i++) {
	            Vet obj = getNewTransientVet(i);
	            dao.persist(obj);
	            data.add(obj);
	        }
	    }
	
}
