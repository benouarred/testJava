package com.sfeir.exam.petclinic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sfeir.exam.petclinic.domain.AbstractPerson;

public abstract class AbstractPersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public void persist(AbstractPerson abstractPerson) {
        this.entityManager.persist(abstractPerson);
    }

    @Transactional
    public void refresh(AbstractPerson abstractPerson) {
        this.entityManager.refresh(abstractPerson);
    }

    @Transactional
    public void remove(Long id) {
        AbstractPerson attached = this.entityManager.find(AbstractPerson.class, id);
        if (attached != null) {
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void flush() {
        this.entityManager.flush();
    }

    @Transactional
    public AbstractPerson merge(AbstractPerson abstractPerson) {
        AbstractPerson merged = this.entityManager.merge(abstractPerson);
        this.entityManager.flush();
        return merged;
    }

    public long countAbstractpeople() {
        return ((Number) this.entityManager.createQuery("select count(o) from AbstractPerson o").getSingleResult()).longValue();
    }

    @SuppressWarnings("unchecked")
    public List<AbstractPerson> findAllAbstractpeople() {
        return this.getEntityManager().createQuery("select o from AbstractPerson o").getResultList();
    }

    public AbstractPerson findAbstractPerson(Long id) {
        if (id == null) return null;
        return entityManager.find(AbstractPerson.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<AbstractPerson> findAbstractPersonEntries(int firstResult, int maxResults) {
        return getEntityManager().createQuery("select o from AbstractPerson o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }


}
