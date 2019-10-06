package ru.sber.edu.dao;

import ru.sber.edu.entity.AccountType;

import javax.persistence.EntityManager;

public class AccountTypeDao extends DaoAbstract<AccountType, Integer> {
    public AccountTypeDao(EntityManager entityManager) {
        super(entityManager);
    }
}
