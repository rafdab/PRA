package com.pracownia.spring.services;

import com.pracownia.spring.entities.Customer;
import com.pracownia.spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> listAllCustomersPaging(Integer pageNr, Integer count) {
        return customerRepository.findAll((Iterable<Integer>) new PageRequest(pageNr, count));
    }

    @Override
    public Iterable<Customer> listAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id){
        return customerRepository.findOne(id);
    }

    @Override
    public Customer saveCustomer(Customer address) {
        return customerRepository.save(address);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (customerRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
