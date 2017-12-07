package com.pracownia.spring.repository;

import com.pracownia.spring.entities.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentRepository extends CrudRepository<Rent, Integer> {

    Integer countAll();

    List<Rent> getRentsByReturnDateIsNull();
}
