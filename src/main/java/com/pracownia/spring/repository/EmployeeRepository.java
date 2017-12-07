package com.pracownia.spring.repository;

import com.pracownia.spring.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findById(Integer id);
    Integer countAll();
}
