package com.sfeir.exam.petclinic.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.dao.VetDao;
import com.sfeir.exam.petclinic.domain.Vet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class VetIntegrationTest extends TestCase{

    private VetDataOnDemand dod;
	   
   @Autowired
	    private VetDao vetDao;
	    
	    private VetDataOnDemand getDod() {
	    	if(dod == null){
	    		dod = new VetDataOnDemand(vetDao);
	    	} 
	    	return dod; 
	    }

	  
	    @Test
	    @Transactional	    
	    public void testCountVets() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        long count = vetDao.countVets();
	        assertTrue("Counter for 'Vet' incorrectly reported there were no entries", count > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindVet() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        Long id = getDod().getRandomVet().getId();
	        assertNotNull("Data on demand for 'Vet' failed to provide an identifier", id);
	        Vet obj = vetDao.findVet(id);
	        assertNotNull("Find method for 'Vet' illegally returned null for id '" + id + "'", obj);
	        assertEquals("Find method for 'Vet' returned the incorrect identifier", id, obj.getId());
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindAllVets() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        long count = vetDao.countVets();
	        assertTrue("Too expensive to perform a find all test for 'Vet', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
	        List<Vet> result = vetDao.findAllVets();
	        assertNotNull("Find all method for 'Vet' illegally returned null", result);
	        assertTrue("Find all method for 'Vet' failed to return any data", result.size() > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindVetEntries() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        long count = vetDao.countVets();
	        if (count > 20) count = 20;
	        List<Vet> result = vetDao.findVetEntries(0, (int)count);
	        assertNotNull("Find entries method for 'Vet' illegally returned null", result);
	        assertEquals("Find entries method for 'Vet' returned an incorrect number of entries", count, result.size());
	    }
	    
	    @Test
	    @Transactional
	    public void testFlush() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        Long id = getDod().getRandomVet().getId();
	        assertNotNull("Data on demand for 'Vet' failed to provide an identifier", id);
	        Vet obj = vetDao.findVet(id);
	        assertNotNull("Find method for 'Vet' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyVet(obj);
	        Integer currentVersion = obj.getVersion();
	        vetDao.flush();
	        assertTrue("Version for 'Vet' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testMerge() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        Long id = getDod().getRandomVet().getId();
	        assertNotNull("Data on demand for 'Vet' failed to provide an identifier", id);
	        Vet obj = vetDao.findVet(id);
	        assertNotNull("Find method for 'Vet' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyVet(obj);
	        Integer currentVersion = obj.getVersion();
	        vetDao.merge(obj);
	        vetDao.flush();
	        assertTrue("Version for 'Vet' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testPersist() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        Vet obj = getDod().getNewTransientVet(Integer.MAX_VALUE);
	        assertNotNull("Data on demand for 'Vet' failed to provide a new transient entity", obj);
	        assertNull("Expected 'Vet' identifier to be null", obj.getId());
	        vetDao.persist(obj);
	        vetDao.flush();
	        assertNotNull("Expected 'Vet' identifier to no longer be null", obj.getId());
	    }
	    
	    @Test
	    @Transactional
	    public void testRemove() {
	        assertNotNull("Data on demand for 'Vet' failed to initialize correctly", getDod().getRandomVet());
	        Long id = getDod().getRandomVet().getId();
	        assertNotNull("Data on demand for 'Vet' failed to provide an identifier", id);
	        Vet obj = vetDao.findVet(id);
	        assertNotNull("Find method for 'Vet' illegally returned null for id '" + id + "'", obj);
	        vetDao.remove(obj.getId());
	        vetDao.flush();
	        assertNull("Failed to remove 'Vet' with identifier '" + id + "'", vetDao.findVet(id));
	    }
}
