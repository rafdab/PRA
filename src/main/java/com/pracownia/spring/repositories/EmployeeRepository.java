package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findById(Integer id);

    @Query("select count(p) from Employee p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
