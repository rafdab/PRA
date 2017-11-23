package Wypozyczalnia.serialization;

import Wypozyczalnia.model.*;
import Wypozyczalnia.queries.Select;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XML {
    static public int serialization(ObjectMapper objectMapper, EntityManager entityManager){
        int checker = 0;

        List<Employee> employeeList = new Select(entityManager).allEmployees();
        try {
            objectMapper.writeValue(new File("employee.xml"), employeeList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Customer> customerList = new Select(entityManager).allCustomers();
        try {
            objectMapper.writeValue(new File("customer.xml"), customerList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Thing> thingList = new Select(entityManager).allThings();
        try {
            objectMapper.writeValue(new File("thing.xml"), thingList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Address> addressList = new Select(entityManager).allAddresses();
        try {
            objectMapper.writeValue(new File("address.xml"), addressList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Rent> rentList = new Select(entityManager).allRents();
        try {
            objectMapper.writeValue(new File("rent.xml"), rentList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        return checker;
    }
}
