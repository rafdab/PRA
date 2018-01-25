package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Customer.class)
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "surname", nullable = false)
    String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id")
    Address address;

    @OneToMany(mappedBy = "id")
    private Set<Rent> rent;

    public Customer() {
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname, String city, String street, String nr, String postcode, String phoneNumber, String mail) {
        this.name = name;
        this.surname = surname;
        this.address = new Address(city, street, nr, postcode, phoneNumber, mail);
    }

    public Customer(String name, String surname, String city, String street, String nr, String houseNumber, String postcode, String phoneNumber, String mail) {
        this.name = name;
        this.surname = surname;
        this.address = new Address(city, street, nr, houseNumber, postcode, phoneNumber, mail);
    }

    public Customer(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Set<Rent> getRent() {
        return rent;
    }

    public void setRent(Set<Rent> rent) {
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
