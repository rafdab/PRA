package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Employee;
import com.pracownia.spring.services.EmployeeService;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ######## POST methods
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody @Valid @NotNull Employee employee) {
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok().body(employee);
    }

    // ######## GET methods
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable("id") Integer pid){
        return employeeService.getEmployeeById(pid);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> list(Model model){
        return employeeService.listAllEmployees();
    }

    @RequestMapping(value = "/employee/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> list(@PathVariable("page") Integer pageNr, @RequestParam("size")Optional<Integer> count) {
        return employeeService.listAllEmployeesPaging(pageNr, count.orElse(10));
    }

    // ######## PUT methods
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Employee employee) {
        if(!employeeService.checkIfExist(employee.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    // ######## DELETE methods
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new RedirectView("/api/employee", true);
    }
}
