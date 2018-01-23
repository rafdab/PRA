package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer>{

    Integer countAllById();
}
