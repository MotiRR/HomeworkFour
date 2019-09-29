package ru.sber.edu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList();

    public AccountType() {
    }

    public AccountType(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public Client addClient(String name) {
        Client client = new Client(name);
        clients.add(client);
        client.setAccount(this);
        return client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


