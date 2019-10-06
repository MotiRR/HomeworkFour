package ru.sber.edu.dao;

import ru.sber.edu.entity.Bank;

import javax.persistence.EntityManager;

public class BankDao extends DaoAbstract<Bank, Integer> {
    public BankDao(EntityManager entityManager) {
        super(entityManager);
    }
}
