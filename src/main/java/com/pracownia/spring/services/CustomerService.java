package com.pracownia.spring.services;

import com.pracownia.spring.entities.Customer;

public interface CustomerService {

    Iterable<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveCustomer(Customer address);

    void deleteCustomer(Integer id);

    public Iterable<Customer> listAllCustomersPaging(Integer pageNr, Integer count);

    Boolean checkIfExist(Integer id);
}
