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
import java.util.Set;

public class UsingJackson {
    //      database -> json
    static public int serialization(ObjectMapper objectMapper,EntityManager entityManager, String extension){
        int checker = 0;

        List<Employee> employeeList = new Select(entityManager).allEmployees();
        List<Customer> customerList = new Select(entityManager).allCustomers();
        List<Thing> thingList = new Select(entityManager).allThings();
        List<Address> addressList = new Select(entityManager).allAddresses();
        List<Rent> rentList = new Select(entityManager).allRents();
        try {
            objectMapper.writeValue(new File("employee." + extension), employeeList);
            objectMapper.writeValue(new File("customer." + extension), customerList);
            objectMapper.writeValue(new File("thing." + extension), thingList);
            objectMapper.writeValue(new File("address." + extension), addressList);
            objectMapper.writeValue(new File("rent." + extension), rentList);
        } catch (IOException e) {
            e.printStackTrace();
            checker += 1;
        }

        return checker;
    }

    //      json -> database
    static public int deserialization(ObjectMapper objectMapper, EntityManager entityManager, String extension){
        int checker = 0;

        try {
            List<Employee> employeeList = objectMapper.readValue(new File("employee." + extension), new TypeReference<List<Employee>>(){});
            List<Customer> customerList = objectMapper.readValue(new File("customer." + extension), new TypeReference<List<Customer>>(){});
            List<Thing> thingList = objectMapper.readValue(new File("thing." + extension), new TypeReference<List<Thing>>(){});
            List<Address> addressList = objectMapper.readValue(new File("address." + extension), new TypeReference<List<Address>>(){});
            List<Rent> rentList = objectMapper.readValue(new File("rent." + extension), new TypeReference<List<Rent>>(){});
            for (Employee e : employeeList){
                entityManager.persist(e);
            }
            for (Customer e : customerList){
                entityManager.persist(e);
            }
            for (Thing e : thingList){
                entityManager.persist(e);
            }
            for (Address e : addressList){
                entityManager.persist(e);
            }
            for (Rent e : rentList){
                entityManager.persist(e);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            checker++;
        }

        return checker;
    }
}
