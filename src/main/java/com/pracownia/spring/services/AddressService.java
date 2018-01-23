package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;

public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    void deleteAddress(Integer id);

    public Iterable<Address> listAllAddressesPaging(Integer pageNr, Integer count);

    Boolean checkIfExist(Integer id);
}
