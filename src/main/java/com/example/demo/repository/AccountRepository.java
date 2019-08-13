package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.CustomerDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,String> {

    //find data by client id
    @Query(value="SELECT * FROM account_details e WHERE e.client_id LIKE :clientId",
            nativeQuery = true
    )
    public List<Account> findByClientId(@Param("clientId") String clientId);
}
