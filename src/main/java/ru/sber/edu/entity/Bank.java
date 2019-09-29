package ru.sber.edu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<AccountType> accounts = new ArrayList();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public AccountType addAccount(String name) {
        AccountType account = new AccountType(name);
        accounts.add(account);
        account.setBank(this);
        return account;
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
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
