package ru.sber.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

public abstract class DaoAbstract<T, Id extends Serializable> {

    private EntityManager entityManager;

    public DaoAbstract(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public T read(T entity, Id id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T record = (T) entityManager.find(entity.getClass(), id);
        transaction.commit();
        return record;
    }

    public void update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void delete(T entity, Id id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T record = (T) entityManager.find(entity.getClass(), id);
        entityManager.remove(record);
        transaction.commit();
    }

}
