package Wypozyczalnia;

import Wypozyczalnia.model.Customer;
import Wypozyczalnia.model.Employee;
import Wypozyczalnia.model.Rent;
import Wypozyczalnia.model.Thing;
import Wypozyczalnia.queries.Drop;
import Wypozyczalnia.queries.Select;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Let's start");
/*
        Employee e1 = new Employee("Jan", "Kowlski", 2000, "Poznan", "Wrzosowa", "1", "60-600", "123123123", "jkowal@mail.pl");
        Customer c1 = new Customer("Tomasz", "Malinowski", "Poznan", "Głogowska", "13", "60-688", "918293042", "tmalina@mail.pl");
        Thing t1 = new Thing("Toyota Corolla", "sedan", 500 , 1000);
        Rent r1 = new Rent(c1, e1, t1);
*/
        //connect to db
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
/*
            entityManager.persist(e1);
            entityManager.persist(t1);
            entityManager.persist(c1);
            entityManager.persist(r1);
*/
            List<Object[]> result = new Select(entityManager).getRentsWithoutReturnDate();
            for (Object[] a : result){
                System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
            }

            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Throwable e){
            System.err.println("Error: " + e);
        }finally {
            entityManagerFactory.close();
        }
    }
}
