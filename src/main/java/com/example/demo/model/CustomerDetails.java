package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(generator= "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name="client_id")
    private String clientId;

    @Column(name = "customer_id",nullable = false,unique = true)
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="client_id",referencedColumnName = "client_id")
    private List<Account> accounts;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "country")
    private String country;

    public CustomerDetails() {
    }

    public CustomerDetails(String clientId, String customerId, List<Account> accounts, String name, String email, String contactNumber, String country) {
        this.clientId = clientId;
        this.customerId = customerId;
        this.accounts = accounts;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.country = country;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
