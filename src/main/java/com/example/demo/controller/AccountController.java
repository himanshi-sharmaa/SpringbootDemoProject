package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //get all the customer details
    @RequestMapping(value = "/accountdetails/v1",method = RequestMethod.GET)
    public List <Account> getCustomerDetails(){
        List<Account> eventData = accountService.getAccountDatabase();
        return eventData;
    }

    //for adding single customer data
    @RequestMapping(method = RequestMethod.POST,value = "/accountdetails/v1")
    public void addCustomerDetails(@RequestBody Account accountDetailsToBeAdded) {
        if (accountDetailsToBeAdded == null) {
            System.out.println("Enter valid data for notification details");
        } else {
            accountService.addAccountsData(accountDetailsToBeAdded);
        }
    }

    //for deleting client details
    @RequestMapping(method = RequestMethod.DELETE,value = "/accountdetails/v1/{id}")
    public void deleteCustomerDetails(@PathVariable String id){
        accountService.deleteAccountDetails(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/accountdetails/v1/byclientid/{clientid}")
    public List<Account> getCustomerByClientId(@PathVariable("clientid") String clientId) {
        return accountRepository.findByClientId(clientId);
    }
}
