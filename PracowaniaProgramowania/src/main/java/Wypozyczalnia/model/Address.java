package Wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Address.class)
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(generator = "address_gen")
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", allocationSize = 1)
    @Column(name = "id")
    int id;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "street", nullable = false)
    String street;

    @Column(name = "nr", nullable = false)
    String nr;

    @Column(name = "houseNumber")
    String houseNumber;

    @Column(name = "postcode", nullable = false)
    String postcode;

    @Column(name = "phoneNumber", nullable = false)
    String phoneNumber;

    @Column(name = "mail", nullable = false)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
