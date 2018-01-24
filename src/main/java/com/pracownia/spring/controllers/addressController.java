package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.services.AddressService;
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
public class addressController {

    @Autowired
    private AddressService addressService;

    // ##### POST methods
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody @Valid @NotNull Address address){
        addressService.saveAddress(address);
        return  ResponseEntity.ok().body(address);
    }
}