package com.pracownia.spring.service;

import com.pracownia.spring.entities.Employee;

public interface EmployeeService {

    Iterable<Employee> listAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee address);

    void deleteEmployee(Integer id);

    public Iterable<Employee> listAllEmployeesPaging(Integer pageNr, Integer count);
}
