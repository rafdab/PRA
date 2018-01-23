package com.pracownia.spring.services;

import com.pracownia.spring.entities.Thing;

public interface ThingService {

    Iterable<Thing> listAllThings();

    Thing getThingById(Integer id);

    Thing saveThing(Thing address);

    void deleteThing(Integer id);

    public Iterable<Thing> listAllThingsPaging(Integer pageNr, Integer count);

    Boolean checkIfExist(Integer id);
}
