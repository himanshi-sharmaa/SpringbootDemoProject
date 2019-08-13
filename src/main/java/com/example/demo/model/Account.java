package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
public class Account {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="uuid",strategy="system-uuid")
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "client_id",nullable = false)
    private String clientId;

    @Column(name = "balance")
    private long balance;

    public Account() {
    }

    public Account(String accountNumber, String clientId, long balance) {
        this.accountNumber = accountNumber;
        this.clientId = clientId;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
