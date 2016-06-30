package com.sfeir.exam.petclinic.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import com.sfeir.exam.petclinic.domain.Visit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class VisitIntegrationTest {
	    
	private VisitDataOnDemand dod;
	    
	    @Autowired
	    private VisitDao visitDao;
	    @Autowired
	    private PetDao petDao;
	    
	    private VisitDataOnDemand getDod() {
	    	if(dod == null){
	    		dod = new VisitDataOnDemand(visitDao, petDao);
	    	} 
	    	return dod; 
	    }

		@Before
		@Transactional
		public void init(){
			getDod().getRandomVisit();
			assertNotNull("Data on demand for 'Visit' failed to initialize correctly", dod);

		}

	    @Test
	    @Transactional	    
	    public void testCountVisits() {
	        long count = visitDao.countVisits();
	        assertTrue("Counter for 'Visit' incorrectly reported there were no entries", count > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindVisit() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit obj = visitDao.findVisit(id);
	        assertNotNull("Find method for 'Visit' illegally returned null for id '" + id + "'", obj);
	        assertEquals("Find method for 'Visit' returned the incorrect identifier", id, obj.getId());
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindAllVisits() {
	        long count = visitDao.countVisits();
	        assertTrue("Too expensive to perform a find all test for 'Visit', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
	        List<Visit> result = visitDao.findAllVisits();
	        assertNotNull("Find all method for 'Visit' illegally returned null", result);
	        assertTrue("Find all method for 'Visit' failed to return any data", result.size() > 0);
	    }
	    
	    @Test
	    @Transactional	    
	    public void testFindVisitEntries() {
	        long count = visitDao.countVisits();
	        if (count > 20) count = 20;
	        List<Visit> result = visitDao.findVisitEntries(0, (int)count);
	        assertNotNull("Find entries method for 'Visit' illegally returned null", result);
	        assertEquals("Find entries method for 'Visit' returned an incorrect number of entries", count, result.size());
	    }
	    
	    @Test
	    @Transactional
	    public void testFlush() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit obj = visitDao.findVisit(id);
	        assertNotNull("Find method for 'Visit' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyVisit(obj);
	        Integer currentVersion = obj.getVersion();
	        visitDao.flush();
	        assertTrue("Version for 'Visit' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testMerge() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit obj = visitDao.findVisit(id);
	        assertNotNull("Find method for 'Visit' illegally returned null for id '" + id + "'", obj);
	        boolean modified =  getDod().modifyVisit(obj);
	        Integer currentVersion = obj.getVersion();
	        visitDao.merge(obj);
	        visitDao.flush();
	        assertTrue("Version for 'Visit' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
	    }
	    
	    @Test
	    @Transactional
	    public void testPersist() {
	        Visit obj = getDod().getNewTransientVisit(Integer.MAX_VALUE);
	        assertNotNull("Data on demand for 'Visit' failed to provide a new transient entity", obj);
	        assertNull("Expected 'Visit' identifier to be null", obj.getId());
	        visitDao.persist(obj);
	        visitDao.flush();
	        assertNotNull("Expected 'Visit' identifier to no longer be null", obj.getId());
	    }
	    
	    @Test
	    @Transactional
	    public void testRemove() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit obj = visitDao.findVisit(id);
	        assertNotNull("Find method for 'Visit' illegally returned null for id '" + id + "'", obj);
	        visitDao.remove(obj.getId());
	        visitDao.flush();
	        assertNull("Failed to remove 'Visit' with identifier '" + id + "'", visitDao.findVisit(id));
	    }
	    
	    @SuppressWarnings("unchecked")
		@Test
	    @Transactional
	    public void testFindVisitsByDescriptionAndVisitDate() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit visit = visitDao.findVisit(id);
	        @SuppressWarnings("unused")
			List<Visit> visitList = (List<Visit>)visitDao.findVisitsByDescriptionAndVisitDate(visit.getDescription(), visit.getVisitDate()).getResultList();
	        assertTrue(visitList.contains(visit));
	    }	    
	    
	    @SuppressWarnings("unchecked")
		@Test
	    @Transactional
	    public void testFindVisitsByVisitDateBetween() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit visit = visitDao.findVisit(id);
	        @SuppressWarnings("unused")
			List<Visit> visitList = (List<Visit>) visitDao.findVisitsByVisitDateBetween(visit.getVisitDate() , visit.getVisitDate()).getResultList();
	        assertTrue(visitList.contains(visit));
	    }	
	    
	    @Test
	    @Transactional
	    public void testFindVisitsByDescriptionLike() {
	        Long id = getDod().getRandomVisit().getId();
	        assertNotNull("Data on demand for 'Visit' failed to provide an identifier", id);
	        Visit visit = visitDao.findVisit(id);
	        @SuppressWarnings("unchecked")
			List<Visit> visitList = (List<Visit>) visitDao.findVisitsByDescriptionLike(visit.getDescription().substring(0, visit.getDescription().length() - 1)).getResultList();
	        assertTrue(visitList.contains(visit));	        
	    }		    
}
