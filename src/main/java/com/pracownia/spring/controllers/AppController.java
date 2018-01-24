package com.pracownia.spring.controllers;

import com.pracownia.spring.Utils.CustomErrorType;
import com.pracownia.spring.entities.*;
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

    // ### POST - creating things
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer, UriComponentsBuilder builder){

        if(customerService.checkIfExist(customer.getId())){
            return new ResponseEntity(new CustomErrorType("Unable to create. A customer with name " + customer.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee, UriComponentsBuilder builder){

        if(employeeService.checkIfExist(employee.getId())){
            return new ResponseEntity(new CustomErrorType("Unable to create. An employee with name " +  employee.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        employeeService.saveEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<?> createAddress(@RequestBody Address address, UriComponentsBuilder builder){

        if(addressService.checkIfExist(address.getId())){
            return new ResponseEntity(new CustomErrorType("Unable to create. An address with id " + address.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        addressService.saveAddress(address);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/address/{id}").buildAndExpand(address.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public ResponseEntity<?> createRent(@RequestBody Rent rent, UriComponentsBuilder builder){

        if(rentService.checkIfExist(rent.getId())){
            return new ResponseEntity(new CustomErrorType("Unable to create. A rent with id " + rent.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        rentService.saveRent(rent);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/rent/{id}").buildAndExpand(rent.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/thing", method = RequestMethod.POST)
    public ResponseEntity<?> createThing(@RequestBody Thing thing, UriComponentsBuilder builder){

        if(thingService.checkIfExist(thing.getId())){
            return new ResponseEntity(new CustomErrorType("Unable to create. A thing with name " + thing.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        thingService.saveThing(thing);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/thing/{id}").buildAndExpand(thing.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ### PUT - updating things

}