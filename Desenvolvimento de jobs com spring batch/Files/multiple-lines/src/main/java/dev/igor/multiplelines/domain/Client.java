package dev.igor.multiplelines.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String surname;
    private String age;
    private String email;
    private List<Transaction> transactions = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String surname, String age, String email, List<Transaction> transactions) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
