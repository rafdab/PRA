package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Address.class)
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String city;

    @Column
    String street;

    @Column
    String nr;

    @Column
    String houseNumber;

    @Column
    String postcode;

    @Column
    String phoneNumber;

    @Column
    String mail;

    public Address() {
    }

    public Address(String city, String street, String nr, String postcode, String phoneNumber, String mail) {
        this.city = city;
        this.street = street;
        this.nr = nr;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public Address(String city, String street, String nr, String houseNumber, String postcode, String phoneNumber, String mail) {
        this.city = city;
        this.street = street;
        this.nr = nr;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String gethouseNumber() {
        return houseNumber;
    }

    public void sethouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
