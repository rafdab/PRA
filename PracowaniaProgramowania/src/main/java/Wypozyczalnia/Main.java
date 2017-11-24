package Wypozyczalnia;

import Wypozyczalnia.model.Customer;
import Wypozyczalnia.model.Employee;
import Wypozyczalnia.model.Rent;
import Wypozyczalnia.model.Thing;
import Wypozyczalnia.queries.Select;
import Wypozyczalnia.serialization.UsingJackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JodaModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.registerModule(new JodaModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        Employee e1 = new Employee("Patryk", "Januszek", 2000, "Poznan", "Wrzosowa", "1", "60-600", "123123123", "januszek@mail.pl");
        Customer c1 = new Customer("Bartosz", "Konieczny", "Poznan", "Głogowska", "13", "60-688", "918293042", "Konieczko@mail.pl");
        Thing t1 = new Thing("BMW E46", "sedan", 500 , 1000);
        Rent r1 = new Rent(c1, e1, t1);

        //connect to db
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

/*            entityManager.persist(e1);
            entityManager.persist(t1);
            entityManager.persist(c1);
            entityManager.persist(r1);
            List<Object[]> result = new Select(entityManager).getRentsWithoutReturnDate();
            for (Object[] a : result){
                System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
            }*/

            UsingJackson.serialization(objectMapper, entityManager, "json");
//            UsingJackson.deserialization(objectMapper,entityManager, "json");

            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Throwable e){
            System.err.println("Error: " + e);
            e.printStackTrace();
        }finally {
            entityManagerFactory.close();
        }
    }
}
