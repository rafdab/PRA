package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentRepository extends CrudRepository<Rent, Integer> {

    List<Rent> getRentsByReturnDateIsNull();

    @Query("select count(p) from Rent p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
