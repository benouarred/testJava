package com.sfeir.exam.petclinic.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Pet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class PetIntegrationTest{

	  private PetDataOnDemand dod;
	    
	    @Autowired
	    private PetDao petDao;
	    
	    private PetDataOnDemand getDod() {
	    	if(dod == null){
	    		dod = new PetDataOnDemand(petDao);
	    	} 
	    	return dod; 
	    }

		@Before
		@Transactional
		public void initTest(){
			getDod().getRandomPet();
			assertNotNull("Data on demand for 'Pet' failed to initialize correctly", dod);
		}

	  

		@Test
		@Transactional
	    public void testCountPets() {
	        long count = petDao.countPets();
	        assertTrue("Counter for 'Pet' incorrectly reported there were no entries", count > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindPet() {
	        Long id = getDod().getRandomPet().getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        Pet obj = petDao.findPet(id);
	        assertNotNull("Find method for 'Pet' illegally returned null for id '" + id + "'", obj);
	        assertEquals("Find method for 'Pet' returned the incorrect identifier", id, obj.getId());
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindAllPets() {
	        long count = petDao.countPets();
	        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Pet', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
	        List<Pet> result = petDao.findAllPets();
	        assertNotNull("Find all method for 'Pet' illegally returned null", result);
	        assertTrue("Find all method for 'Pet' failed to return any data", result.size() > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindPetEntries() {
	        long count = petDao.countPets();
	        if (count > 20) count = 20;
	        List<Pet> result = petDao.findPetEntries(0, (int)count);
	        assertNotNull("Find entries method for 'Pet' illegally returned null", result);
	        assertEquals("Find entries method for 'Pet' returned an incorrect number of entries", count, result.size());
	    }
	    
	    @Test
	    @Transactional
	    public void testFlush() {
	        Long id = getDod().getRandomPet().getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        Pet obj = petDao.findPet(id);
	        assertNotNull("Find method for 'Pet' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyPet(obj);
	        Integer currentVersion = obj.getVersion();
	        petDao.flush();
	        assertTrue("Version for 'Pet' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testMerge() {
	        Long id = getDod().getRandomPet().getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        Pet obj = petDao.findPet(id);
	        assertNotNull("Find method for 'Pet' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyPet(obj);
	        Integer currentVersion = obj.getVersion();
	        petDao.merge(obj);
	        petDao.flush();
	        assertTrue("Version for 'Pet' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testPersist() {
	        Pet obj = getDod().getNewTransientPet(Integer.MAX_VALUE);
	        assertNotNull("Data on demand for 'Pet' failed to provide a new transient entity", obj);
	        assertNull("Expected 'Pet' identifier to be null", obj.getId());
	        petDao.persist(obj);
	        petDao.flush();
	        assertNotNull("Expected 'Pet' identifier to no longer be null", obj.getId());
	    }
	    
	    @Test
	    @Transactional
	    public void testRemove() {
	        Long id = getDod().getRandomPet().getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        Pet obj = petDao.findPet(id);
	        assertNotNull("Find method for 'Pet' illegally returned null for id '" + id + "'", obj);
	        petDao.remove(obj.getId());
	        petDao.flush();
	        assertNull("Failed to remove 'Pet' with identifier '" + id + "'", petDao.findPet(id));
	    }

	    @Test
	    @Transactional
	    public void testFindPetsByNameAndWeight() {
	        Pet obj = getDod().getRandomPet();
	        Long id = obj.getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        Pet obj2 = (Pet) petDao.findPetsByNameAndWeight(obj.getName(), obj.getWeight()).getSingleResult();
	        assertNotNull("Find method for 'Pet' illegally returned null for id '" + obj2.getId() + "'", obj2);
	        assertEquals(obj, obj2);
	    }

	    @Test
	    @Transactional
	    public void testFindPetsBySendRemindersAndWeightLessThan() {
	        Pet obj = getDod().getRandomPet();
	        Long id = obj.getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        @SuppressWarnings("unchecked")
			List<Pet> petList = (List<Pet>) petDao.findPetsBySendRemindersAndWeightLessThan(obj.isSendReminders(), obj.getWeight() + 1).getResultList();
	        assertTrue(petList.contains(obj));
	    }

	    @Test
	    @Transactional
	    public void testFindPetsByTypeAndNameLike() {
	        Pet obj = getDod().getRandomPet();
	        Long id = obj.getId();
	        assertNotNull("Data on demand for 'Pet' failed to provide an identifier", id);
	        @SuppressWarnings("unchecked")
			List<Pet> petList = (List<Pet>) petDao.findPetsByTypeAndNameLike(obj.getType(), obj.getName().substring(0, obj.getName().length() - 1)).getResultList();
	        assertTrue(petList.contains(obj));
	    }
}
