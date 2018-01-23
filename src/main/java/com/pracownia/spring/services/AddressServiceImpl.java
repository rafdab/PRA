package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class AddressServiceImpl implements AddressService {

    @Autowired
    public AddressRepository addressRepository;

    @Override
    public Iterable<Address> listAllAddressesPaging(Integer pageNr, Integer count) {
        return addressRepository.findAll(new PageRequest(pageNr,count));
    }

    @Override
    public Iterable<Address> listAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (addressRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}




