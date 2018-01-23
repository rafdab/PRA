package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByNameAndSurname(String name, String surname);
    Integer countAll();
    Customer findById(Integer id);
}
