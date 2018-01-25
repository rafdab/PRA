package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Employee.class)
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "surname", nullable = false)
    String surname;

    @Column(name = "salary", nullable = false)
    float salary;

    @Column(name = "hired", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    DateTime hired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id")
    Address address;

    @OneToMany(mappedBy = "id")
    private Set<Rent> rent;

    public Employee() {
    }

    public Employee(String name, String surname, float salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }


    public Employee(String name, String surname, float salary, String city, String street, String nr, String postcode, String phoneNumber, String mail) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.address = new Address(city, street, nr, postcode, phoneNumber, mail);
        this.hired = DateTime.now();
    }


    public Employee(String name, String surname, float salary, String city, String street, String nr, String houseNumber, String postcode, String phoneNumber, String mail) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.address = new Address(city, street, nr, houseNumber, postcode, phoneNumber, mail);
        this.hired = DateTime.now();
    }

    public Employee(String name, String surname, float salary, DateTime hired, Address address) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.hired = hired;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public DateTime getHired() {
        return hired;
    }

    public void setHired(DateTime hired) {
        this.hired = hired;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
