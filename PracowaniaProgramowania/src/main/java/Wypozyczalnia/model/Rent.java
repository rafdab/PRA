package Wypozyczalnia.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue(generator = "rent_gen")
    @SequenceGenerator(name = "rent_gen", sequenceName = "rent_seq", allocationSize = 1)
    @Column(name = "id")
    int id;

    @Column(name = "rent_date", nullable = false)
    ZonedDateTime rentDate;

    @Column(name = "return_date")
    ZonedDateTime returnDate;

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
        this.rentDate = ZonedDateTime.now();
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;
    }

    public Rent(ZonedDateTime rentDate, Customer customer, Employee employee, Thing thing) {
        this.rentDate = rentDate;
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;
    }

    public Rent(ZonedDateTime rentDate, ZonedDateTime returnDate, float profit, Customer customer, Employee employee, Thing thing) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.profit = profit;
        this.customer = customer;
        this.employee = employee;
        this.thing = thing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(ZonedDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public ZonedDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(ZonedDateTime returnDate) {
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
