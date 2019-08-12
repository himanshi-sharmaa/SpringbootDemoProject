package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="uuid",strategy="system-uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "client_id",nullable = false)
    private String clientId;

    @Column(name = "customer_id",nullable = false,unique = true)
    private String customerId;

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

    public CustomerDetails(String id, String clientId, String customerId, String name, String email, String contactNumber, String country) {
        this.id = id;
        this.clientId = clientId;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
