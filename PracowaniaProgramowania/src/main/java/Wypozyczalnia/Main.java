package Wypozyczalnia;

import Wypozyczalnia.model.Customer;
import Wypozyczalnia.model.Employee;
import Wypozyczalnia.model.Thing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class Main {
    public static void main(String[] args){
        System.out.println("Let's start");

        Employee e1 = new Employee("Jan", "Kowlski", 2000, "Poznan", "Wrzosowa", "1", "60-600", "123123123", "jkowal@mail.pl");
        Thing t1 = new Thing("Toyota Corolla", "sedan", 500 , 1000);

        //łącznie z db
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(e1);
            entityManager.persist(t1);

            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Throwable e){
            System.err.println("Error: " + e);
        }finally {
            entityManagerFactory.close();
        }
    }
}
