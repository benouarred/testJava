package com.sfeir.exam.petclinic.dao;

import java.util.List;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Owner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class OwnerIntegrationTest {

    private OwnerDataOnDemand dod;

    @Autowired
    private OwnerDao ownerDao;
    
    private OwnerDataOnDemand getDod() {
    	if(dod == null){
    		dod = new OwnerDataOnDemand(ownerDao);
    	} 
    	return dod; 
    	
    }

    @Before
    @Transactional
    public void initTest(){
        getDod().getRandomOwner();
        assertNotNull("Data on demand for 'Owner' failed to initialize correctly", dod);
    }

    @Test
    @Transactional
    public void testCountOwners() {

        long count = ownerDao.countOwners();
        assertTrue("Counter for 'Owner' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    @Transactional
    public void testFindOwner() {
        Long id = getDod().getRandomOwner().getId();
        assertNotNull("Data on demand for 'Owner' failed to provide an identifier", id);
        Owner obj = ownerDao.findOwner(id);
        assertNotNull("Find method for 'Owner' illegally returned null for id '" + id + "'", obj);
        assertEquals("Find method for 'Owner' returned the incorrect identifier", id, obj.getId());
    }

    @Test
    @Transactional
    public void testFindAllOwners() {
        long count = ownerDao.countOwners();
        assertTrue("Too expensive to perform a find all test for 'Owner', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Owner> result = ownerDao.findAllOwners();
        assertNotNull("Find all method for 'Owner' illegally returned null", result);
        assertTrue("Find all method for 'Owner' failed to return any data", result.size() > 0);
    }
    

    @Test
    @Transactional
    public void testFindOwnerEntries() {
        long count = ownerDao.countOwners();
        if (count > 20) count = 20;
        List<Owner> result = ownerDao.findOwnerEntries(0, (int)count);
        assertNotNull("Find entries method for 'Owner' illegally returned null", result);
        assertEquals("Find entries method for 'Owner' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void testFlush() {
        Long id = getDod().getRandomOwner().getId();
        assertNotNull("Data on demand for 'Owner' failed to provide an identifier", id);
        Owner obj = ownerDao.findOwner(id);
        assertNotNull("Find method for 'Owner' illegally returned null for id '" + id + "'", obj);
        boolean modified =  getDod().modifyOwner(obj);
        Integer currentVersion = obj.getVersion();
        ownerDao.flush();
        assertTrue("Version for 'Owner' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void testMerge() {
        Long id = getDod().getRandomOwner().getId();
        assertNotNull("Data on demand for 'Owner' failed to provide an identifier", id);
        Owner obj = ownerDao.findOwner(id);
        assertNotNull("Find method for 'Owner' illegally returned null for id '" + id + "'", obj);
        boolean modified =  getDod().modifyOwner(obj);
        Integer currentVersion = obj.getVersion();
        ownerDao.merge(obj);
        ownerDao.flush();
        assertTrue("Version for 'Owner' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void testPersist() {
        Owner obj = getDod().getNewTransientOwner(Integer.MAX_VALUE);
        assertNotNull("Data on demand for 'Owner' failed to provide a new transient entity", obj);
        assertNull("Expected 'Owner' identifier to be null", obj.getId());
        ownerDao.persist(obj);
        ownerDao.flush();
        assertNotNull("Expected 'Owner' identifier to no longer be null", obj.getId());
    }
    
    @Test(expected = EmptyResultDataAccessException.class)
    @Transactional
    public void testRemove() {
        Long id = getDod().getRandomOwner().getId();
        assertNotNull("Data on demand for 'Owner' failed to provide an identifier", id);
        Owner obj = ownerDao.findOwner(id);
        assertNotNull("Find method for 'Owner' illegally returned null for id '" + id + "'", obj);
        ownerDao.remove(obj.getId());
        ownerDao.flush();
        ownerDao.findOwner(id);
        //assertNull("Failed to remove 'Owner' with identifier '" + id + "'", ownerDao.findOwner(id));
    }
}
