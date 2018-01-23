package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Customer;
import com.pracownia.spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RentService rentService;

    @Autowired
    private ThingService thingService;

    // ### POST
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer, UriComponentsBuilder builder){
        if(customerService.checkIfExist(customer.getId())){
            return null;
        }

        customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/user/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}