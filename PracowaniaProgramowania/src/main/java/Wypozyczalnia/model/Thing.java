package Wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Thing.class)
@Entity
@Table(name = "Thing")
public class Thing {

    @Id
    @GeneratedValue(generator = "thing_gen")
    @SequenceGenerator(name = "thing_gen", sequenceName = "thing_seq", allocationSize = 1)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;

    @Column(name = "price")
    float price;

    @Column(name = "bail")
    float bail;

    @OneToMany(mappedBy = "id")
    private Set<Rent> rent;

    public Thing(String name, String type, float price, float bail) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.bail = bail;
    }

    public Thing() {
    }

    public Set<Rent> getRent() {
        return rent;
    }

    public void setRent(Set<Rent> rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getBail() {
        return bail;
    }

    public void setBail(float bail) {
        this.bail = bail;
    }
}
