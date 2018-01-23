package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findById(Integer id);
    Integer countAll();
}
