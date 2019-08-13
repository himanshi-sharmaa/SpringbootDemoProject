package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //get all data
    public List<Account> getAccountDatabase() {
        List<Account> accounts = new ArrayList<Account>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    //add customer details to customer_details
    public void addAccountsData(Account accountDetailsToBeAdded) {
        accountRepository.save(accountDetailsToBeAdded);
    }

    //delete customer_details by id
    public void deleteAccountDetails(String id){
        accountRepository.deleteById(id);
    }
}
