package com.pracownia.spring.services;

import com.pracownia.spring.entities.Rent;
import com.pracownia.spring.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("rentService")
public class RentServiceImpl implements RentService{

    @Autowired
    public RentRepository rentRepository;

    @Override
    public Iterable<Rent> listAllRentsPaging(Integer pageNr, Integer count) {
        return rentRepository.findAll((Iterable<Integer>) new PageRequest(pageNr, count));
    }

    @Override
    public Iterable<Rent> listAllRents(){
        return rentRepository.findAll();
    }

    @Override
    public Rent getRentById(Integer id){
        return rentRepository.findOne(id);
    }

    @Override
    public Rent saveRent(Rent address) {
        return rentRepository.save(address);
    }

    @Override
    public void deleteRent(Integer id) {
        rentRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (rentRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
