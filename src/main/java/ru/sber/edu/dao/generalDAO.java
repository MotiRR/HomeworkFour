package ru.sber.edu.dao;

import ru.sber.edu.entity.AccountType;
import ru.sber.edu.entity.Bank;
import ru.sber.edu.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class generalDAO {

    private EntityManager entityManager;

    public generalDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveBank(Bank bank) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(bank);
        transaction.commit();
    }

    public void saveAccountType(AccountType accountType) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(accountType);
        transaction.commit();
    }

    public void saveClient(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    public List<Client> readAllClient() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Client> clients = entityManager
                .createQuery("SELECT c FROM Client c")
                .getResultList();
        transaction.commit();
        return clients;
    }

    public void updateClient(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(client);
        transaction.commit();
    }

    public void deleteBank(int idBank) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Bank delBank = entityManager.find(Bank.class, idBank);
        entityManager.remove(delBank);
        transaction.commit();
    }

    public void deleteAccountType(int idAccountType) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        AccountType delAccountType = entityManager.find(AccountType.class, idAccountType);
        entityManager.remove(delAccountType);
        transaction.commit();
    }

    public void deleteClient(int idClient) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Client delClient = entityManager.find(Client.class, idClient);
        entityManager.remove(delClient);
        transaction.commit();
    }

}