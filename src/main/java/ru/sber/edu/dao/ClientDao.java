package ru.sber.edu.dao;

import ru.sber.edu.entity.Client;

import javax.persistence.EntityManager;

public class ClientDao extends DaoAbstract<Client, Integer> {

    public ClientDao(EntityManager entityManager) {
        super(entityManager);
    }
}
