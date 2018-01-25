package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Thing;
import com.pracownia.spring.services.ThingService;
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
public class ThingController {

    @Autowired
    private ThingService thingService;

    // ######## POST methods
    @RequestMapping(value = "/thing", method = RequestMethod.POST)
    public ResponseEntity<Thing> create(@RequestBody @Valid @NotNull Thing thing) {
        thingService.saveThing(thing);
        return ResponseEntity.ok().body(thing);
    }

    // ######## GET methods
    @RequestMapping(value = "/thing/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Thing getThingById(@PathVariable("id") Integer pid){
        return thingService.getThingById(pid);
    }

    @RequestMapping(value = "/thing", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Thing> list(Model model){
        return thingService.listAllThings();
    }

    @RequestMapping(value = "/thing/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Thing> list(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> count) {
        return thingService.listAllThingsPaging(pageNr, count.orElse(10));
    }

    // ######## PUT methods
    @RequestMapping(value = "/thing", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Thing thing) {
        if(!thingService.checkIfExist(thing.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            thingService.saveThing(thing);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // ######## DELETE methods
    @RequestMapping(value = "/thing/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        thingService.deleteThing(id);
        return new RedirectView("/api/thing", true);
    }
}
