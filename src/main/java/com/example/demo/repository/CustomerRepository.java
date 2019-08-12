package com.example.demo.repository;

import com.example.demo.model.CustomerDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDetails,String> {

    //find data by customer id
    @Query(value="SELECT * FROM customer_details e WHERE e.customer_id LIKE :customerId AND e.client_id LIKE :clientId",
            nativeQuery = true
    )
    public CustomerDetails findByCustomerId(@Param("customerId") String customerId, @Param("clientId") String clientId);

    //find data by client id
    @Query(value="SELECT * FROM customer_details e WHERE e.client_id LIKE :clientId",
            nativeQuery = true
    )
    public List<CustomerDetails> findByClientId(@Param("clientId") String clientId);

    //update email
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE customer_details t SET t.email = :email WHERE t.customer_id LIKE :customerId AND t.client_id LIKE :clientId",
            nativeQuery=true
    )
    public void updateEmail(@Param("clientId") String clientId, @Param("customerId") String customerId, @Param("email") String email);


    //update contact
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE customer_details t SET t.contact_number = :contactNumber WHERE t.customer_id LIKE :customerId AND t.client_id LIKE :clientId",
            nativeQuery=true
    )
    public void updateContact(@Param("clientId") String clientId, @Param("customerId") String customerId, @Param("contactNumber") String contactNumber);

    //update name
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE customer_details t SET t.name = :name WHERE t.customer_id LIKE :customerId AND t.client_id LIKE :clientId",
            nativeQuery=true
    )
    public void findAndUpdateName(@Param("clientId") String clientId, @Param("customerId") String customerId, @Param("name") String name);

    //update country

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE customer_details t SET t.country = :country WHERE t.customer_id LIKE :customerId AND t.client_id LIKE :clientId",
            nativeQuery=true
    )
    public void updateCountry(@Param("clientId") String clientId, @Param("customerId") String customerId, @Param("country") String country);

}
