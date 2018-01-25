package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Customer;
import com.pracownia.spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // ######## POST methods
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody @Valid @NotNull Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().body(customer);
    }

    // ######## GET methods
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable("id") Integer pid){
        return customerService.getCustomerById(pid);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> list(Model model){
        return customerService.listAllCustomers();
    }

    @RequestMapping(value = "/customer/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> list(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> count) {
        return customerService.listAllCustomersPaging(pageNr, count.orElse(10));
    }

    // ######## PUT methods
    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Customer customer) {
        if(!customerService.checkIfExist(customer.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            customerService.saveCustomer(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // ######## DELETE methods
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return new RedirectView("/api/customer", true);
    }
}
