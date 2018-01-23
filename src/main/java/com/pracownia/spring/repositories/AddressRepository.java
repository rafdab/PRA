package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer>{

    Integer countAllById();

    @Query("select count(*) from Address p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
