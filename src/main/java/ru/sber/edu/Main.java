package ru.sber.edu;

import ru.sber.edu.dao.generalDAO;
import ru.sber.edu.entity.AccountType;
import ru.sber.edu.entity.Bank;
import ru.sber.edu.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) throws Exception {
        hibernate();
    }

    private static void hibernate() throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("ru.sber.edu.entity");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        generalDAO dao = new generalDAO(entityManager);

        Bank bankSber = new Bank("Sber");
        dao.saveBank(bankSber);
        AccountType accountDebit = bankSber.addAccount("Debit");
        //  dao.saveAccountType(accountDebit);

        AccountType accountCredit = bankSber.addAccount("Credit");
        //   dao.saveAccountType(accountCredit);

        Client clientPetrov = accountDebit.addClient("Petrov");
        Client clientIvanov = accountCredit.addClient("Ivanov");
        Client clientSidorov = accountDebit.addClient("Sidorov");

        dao.saveClient(clientPetrov);
        dao.saveClient(clientIvanov);
        dao.saveClient(clientSidorov);

        clientPetrov.setName("Petrovich");
        dao.updateClient(clientPetrov);

        entityManager.clear();

        dao.deleteClient(clientIvanov.getId());
        //dao.deleteBank(clientPetrov.getAccount().getBank().getId());

        System.out.println(dao.readAllClient());

        entityManager.close();

    }
}
