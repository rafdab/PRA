package Wypozyczalnia.serialization;

import Wypozyczalnia.model.*;
import Wypozyczalnia.queries.Select;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSON {
    //      database -> json
    static public int serialization(ObjectMapper objectMapper,EntityManager entityManager){
        int checker = 0;

        List<Employee> employeeList = new Select(entityManager).allEmployees();
        try {
            objectMapper.writeValue(new File("employee.json"), employeeList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Customer> customerList = new Select(entityManager).allCustomers();
        try {
            objectMapper.writeValue(new File("customer.json"), customerList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Thing> thingList = new Select(entityManager).allThings();
        try {
            objectMapper.writeValue(new File("thing.json"), thingList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Address> addressList = new Select(entityManager).allAddresses();
        try {
            objectMapper.writeValue(new File("address.json"), addressList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }
        List<Rent> rentList = new Select(entityManager).allRents();
        try {
            objectMapper.writeValue(new File("rent.json"), rentList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }

        return checker;
    }

    //      json -> database
    static public int deserialization(ObjectMapper objectMapper, EntityManager entityManager){
        int checker = 0;

        try {
            List<Employee> employeeList = objectMapper.readValue(new File("employee.json"), new TypeReference<List<Employee>>(){});
            for (Employee e : employeeList){
                entityManager.persist(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
            checker++;
        }

        return checker;
    }
}
