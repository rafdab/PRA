package com.pracownia.spring.service;

import com.pracownia.spring.entities.Rent;

public interface RentService {

    Iterable<Rent> listAllRents();

    Rent getRentById(Integer id);

    Rent saveRent(Rent address);

    void deleteRent(Integer id);

    public Iterable<Rent> listAllRentsPaging(Integer pageNr, Integer count);
}
