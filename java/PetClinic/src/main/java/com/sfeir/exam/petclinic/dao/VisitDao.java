package com.sfeir.exam.petclinic.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.Visit;

@Repository
public class VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public void persist(Visit visit) {
        this.entityManager.persist(visit);
    }

    @Transactional
    public void remove(Long id) {
        Visit attached = this.entityManager.find(Visit.class, id);
        if (attached != null)
            this.entityManager.remove(attached);
    }

    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public Visit merge(Visit visit) {
        Visit merged = this.entityManager.merge(visit);
        this.flush();
        return merged;
    }

    public long countVisits() {
        return ((Number) getEntityManager().createQuery("select count(o) from Visit o").getSingleResult()).longValue();
    }

    @SuppressWarnings("unchecked")
    public List<Visit> findAllVisits() {
        return getEntityManager().createQuery("select o from Visit o").getResultList();
    }

    public Visit findVisit(Long id) {
        if (id == null) return null;
        return entityManager.find(Visit.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Visit> findVisitEntries(int firstResult, int maxResults) {
        return getEntityManager().createQuery("select o from Visit o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public Query findVisitsByDescriptionAndVisitDate(String description, Date visitDate) {
    	throw new UnsupportedOperationException("To be implemented");
    }

    public Query findVisitsByVisitDateBetween(Date minVisitDate, Date maxVisitDate) {
    	throw new UnsupportedOperationException("To be implemented");
    }

    public Query findVisitsByDescriptionLike(String description) {
    	throw new UnsupportedOperationException("To be implemented");
    }
}
