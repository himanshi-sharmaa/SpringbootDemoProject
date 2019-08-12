package com.example.demo.service;

import com.example.demo.model.CustomerDetails;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //get all data
    public List<CustomerDetails> getCustomerDatabase() {
        List<CustomerDetails> customerData = new ArrayList<CustomerDetails>();
        customerRepository.findAll().forEach(customerData::add);
        return customerData;
    }

    //add customer details to customer_details
    public void addCustomerData(CustomerDetails customerDetailsToBeAdded) {
        customerRepository.save(customerDetailsToBeAdded);
    }

    //delete customer_details by id
    public void deleteCustomerDetails(String id){
        customerRepository.deleteById(id);
    }


}

