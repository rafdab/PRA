package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Thing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Integer>{

    @Query("select count(t) from Thing t")
    Integer countAll();
}