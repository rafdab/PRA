package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.org.apache.regexp.internal.RE;
import org.joda.time.DateTime;

import javax.persistence.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Rent.class)
@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "rent_date", nullable = false)
    DateTime rentDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "return_date")
    DateTime returnDate;

    @Column(name = "profit")
    float profit;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Thing thing;

    public Rent() {
    }

    public Rent(Customer customer, Employee employee, Thing thing) {
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;

        this.rentDate = DateTime.now();
        this.returnDate = null;
    }

    public Rent(DateTime rentDate, Customer customer, Employee employee, Thing thing) {
        this.rentDate = rentDate;
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;
    }

    public Rent(DateTime rentDate, DateTime returnDate, float profit, Customer customer, Employee employee, Thing thing) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.profit = profit;
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(DateTime rentDate) {
        this.rentDate = rentDate;
    }

    public DateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(DateTime returnDate) {
        this.returnDate = returnDate;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }
}
