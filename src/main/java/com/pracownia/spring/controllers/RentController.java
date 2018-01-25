package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Rent;
import com.pracownia.spring.services.RentService;
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
public class RentController {

    @Autowired
    private RentService rentService;

    // ######## POST methods
    @RequestMapping(value = "/rent", method = RequestMethod.POST)
    public ResponseEntity<Rent> create(@RequestBody @Valid @NotNull Rent rent) {
        rentService.saveRent(rent);
        return ResponseEntity.ok().body(rent);
    }

    // ######## GET methods
    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Rent getRentById(@PathVariable("id") Integer pid){
        return rentService.getRentById(pid);
    }

    @RequestMapping(value = "/rent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rent> list(Model model){
        return rentService.listAllRents();
    }

    @RequestMapping(value = "/rent/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Rent> list(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> count) {
        return rentService.listAllRentsPaging(pageNr, count.orElse(10));
    }

    // ######## PUT methods
    @RequestMapping(value = "/rent", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Rent rent) {
        if(!rentService.checkIfExist(rent.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            rentService.saveRent(rent);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // ######## DELETE methods
    @RequestMapping(value = "/rent/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        rentService.deleteRent(id);
        return new RedirectView("/api/rent", true);
    }
}