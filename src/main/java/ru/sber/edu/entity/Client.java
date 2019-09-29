package ru.sber.edu.entity;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private AccountType accountType;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public void setAccount(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountType getAccount() {
        return this.accountType;
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
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
