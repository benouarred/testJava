package com.sfeir.exam.petclinic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Visit;

public class VisitDataOnDemand {
	   private Random rnd = new java.security.SecureRandom();
	    
	    private List<Visit> data;
	    
	    private VisitDao dao;
	    
	    public VisitDataOnDemand(VisitDao dao, PetDao petDao) {
			super();
			this.dao = dao;
			this.petDataOnDemand = new PetDataOnDemand(petDao);
		}

		@Autowired
	    private PetDataOnDemand petDataOnDemand;
	    
	    public Visit getNewTransientVisit(int index) {
	        Visit obj = new Visit();
	        obj.setDescription("description " + index);
	        obj.setPet(petDataOnDemand.getRandomPet());
	        obj.setVet(null);
	        obj.setVisitDate(new Date(new Date().getTime() - 10000000L));
	        return obj;
	    }
	    
	    public Visit getSpecificVisit(int index) {
	        init();
	        if (index < 0) index = 0;
	        if (index > (data.size()-1)) index = data.size() - 1;
	        Visit obj = data.get(index);
	        return dao.findVisit(obj.getId());
	    }
	    
	    public Visit getRandomVisit() {
	        init();
	        Visit obj = data.get(rnd.nextInt(data.size()));
	        return dao.findVisit(obj.getId());
	    }
	    
	    public boolean modifyVisit(Visit obj) {
	        return false;
	    }
	    
	    @Transactional(propagation = Propagation.REQUIRES_NEW)
	    public void init() {
	        if (data != null) {
	            return;
	        }
	        
	        data = dao.findVisitEntries(0, 10);
	        if (data == null) throw new IllegalStateException("Find entries implementation for 'Visit' illegally returned null");
	        if (data.size() > 0) {
	            return;
	        }
	        
	        data = new ArrayList<Visit>();
	        for (int i = 0; i < 10; i++) {
	            Visit obj = getNewTransientVisit(i);
	            dao.persist(obj);
	            data.add(obj);
	        }
	    }
	    
}
