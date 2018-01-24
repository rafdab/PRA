package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Customer;
import com.pracownia.spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class customerController {

    @Autowired
    private CustomerService customerService;

    // ######## POST methods
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody @Valid @NotNull Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().body(customer);
    }
}
