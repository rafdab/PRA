package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.services.AddressService;
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
public class AddressController {

    @Autowired
    private AddressService addressService;

    // ##### POST methods
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody @Valid @NotNull Address address){
        addressService.saveAddress(address);
        return  ResponseEntity.ok().body(address);
    }

    // ######## GET methods
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Address getAddressById(@PathVariable("id") Integer pid){
        return addressService.getAddressById(pid);
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> list(Model model){
        return addressService.listAllAddresses();
    }

    @RequestMapping(value = "/address/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> list(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> count) {
        return addressService.listAllAddressesPaging(pageNr, count.orElse(10));
    }

    // ######## PUT methods
    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Address address) {
        if(!addressService.checkIfExist(address.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            addressService.saveAddress(address);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // ######## DELETE methods
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return new RedirectView("/api/address", true);
    }
}