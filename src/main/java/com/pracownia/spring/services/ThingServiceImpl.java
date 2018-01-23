package com.pracownia.spring.services;

import com.pracownia.spring.entities.Thing;
import com.pracownia.spring.repositories.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class ThingServiceImpl implements ThingService {

    @Autowired
    public ThingRepository thingRepository;

    @Override
    public Iterable<Thing> listAllThingsPaging(Integer pageNr, Integer count) {
        return thingRepository.findAll((Iterable<Integer>) new PageRequest(pageNr, count));
    }

    @Override
    public Iterable<Thing> listAllThings(){
        return thingRepository.findAll();
    }

    @Override
    public Thing getThingById(Integer id){
        return thingRepository.findOne(id);
    }

    @Override
    public Thing saveThing(Thing address) {
        return thingRepository.save(address);
    }

    @Override
    public void deleteThing(Integer id) {
        thingRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (thingRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
