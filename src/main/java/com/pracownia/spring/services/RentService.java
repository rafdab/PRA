package com.pracownia.spring.services;

import com.pracownia.spring.entities.Rent;

public interface RentService {

    Iterable<Rent> listAllRents();

    Rent getRentById(Integer id);

    Rent saveRent(Rent address);

    void deleteRent(Integer id);

    public Iterable<Rent> listAllRentsPaging(Integer pageNr, Integer count);

    Boolean checkIfExist(Integer id);
}
