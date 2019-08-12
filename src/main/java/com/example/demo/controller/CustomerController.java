package com.example.demo.controller;

import com.example.demo.model.CustomerDetails;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //get all the customer details
    @RequestMapping(value = "/customerdetails/v1",method = RequestMethod.GET)
    public List<CustomerDetails> getCustomerDetails(){
        List<CustomerDetails> eventData = customerService.getCustomerDatabase();
        return eventData;
    }

    //for adding single customer data
    @RequestMapping(method = RequestMethod.POST,value = "/customerdetails/v1")
    public void addCustomerDetails(@RequestBody CustomerDetails customerDetailsToBeAdded) {
        if (customerDetailsToBeAdded == null) {
            System.out.println("Enter valid data for notification details");
        } else {
            customerService.addCustomerData(customerDetailsToBeAdded);
        }
    }

    //for deleting client details
    @RequestMapping(method = RequestMethod.DELETE,value = "/customerdetails/v1/{id}")
    public void deleteCustomerDetails(@PathVariable String id){
        customerService.deleteCustomerDetails(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/customerdetails/v1/byclientid/{clientid}")
    public List<CustomerDetails> getCustomerByClientId(@PathVariable("clientid") String clientId) {
        return customerRepository.findByClientId(clientId);
    }
}
