package com.pracownia.spring.repository;

import com.pracownia.spring.entities.Thing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Integer>{

    @Query("select count(*) from Thing")
    Integer countAll();
}
