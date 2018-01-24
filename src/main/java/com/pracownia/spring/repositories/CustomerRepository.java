package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByNameAndSurname(String name, String surname);

    Customer findById(Integer id);

    @Query("select count(p) from Customer p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
