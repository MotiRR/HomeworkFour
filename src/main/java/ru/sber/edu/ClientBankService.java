package ru.sber.edu;

import ru.sber.edu.dao.AccountTypeDao;
import ru.sber.edu.dao.BankDao;
import ru.sber.edu.dao.ClientDao;
import ru.sber.edu.entity.AccountType;
import ru.sber.edu.entity.Bank;
import ru.sber.edu.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientBankService {

    public void hibernate() {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("ru.sber.edu.entity");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        AccountTypeDao accountTypeDao = new AccountTypeDao(entityManager);
        BankDao bankDao = new BankDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);

        Bank bankSber = new Bank("Sber");

        AccountType accountDebit = bankSber.addAccount("Debit");
        AccountType accountCredit = bankSber.addAccount("Credit");
        bankDao.create(bankSber);

        Client clientPetrov = accountDebit.addClient("Petrov");
        Client clientIvanov = accountCredit.addClient("Ivanov");
        Client clientSidorov = accountDebit.addClient("Sidorov");

        clientDao.create(clientPetrov);
        clientDao.create(clientIvanov);
        clientDao.create(clientSidorov);

        clientPetrov.setName("Petrovich");
        clientDao.update(clientPetrov);

        entityManager.clear();

        clientDao.delete(clientIvanov, clientIvanov.getId());
        System.out.println(clientDao.read(clientPetrov, clientPetrov.getId()));

        entityManager.close();

    }
}
