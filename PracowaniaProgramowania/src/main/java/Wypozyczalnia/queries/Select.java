package Wypozyczalnia.queries;

import Wypozyczalnia.model.Customer;
import Wypozyczalnia.model.Employee;
import Wypozyczalnia.model.Thing;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Select {
    EntityManager entityManager;

    public Select(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> allEmployees(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    public List<Customer> allCustomers(){
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    public List<Thing> allThings(){
        TypedQuery<Thing> query = entityManager.createQuery("SELECT t FROM Thing t", Thing.class);
        return query.getResultList();
    }

    public List<Employee> employeesByPadge(int pageNr){
        int pageSize = 10;

        Query query = entityManager.createQuery("select count(e) from Employee e");
        long count = (long) query.getSingleResult();
        int pageNumber = (int)(count / pageSize) + 1;

        query = entityManager.createQuery("select e from Employee e order by e.surname");

        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult(pageNr - 1);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Customer> customersByPage(int pageNr){
        int pageSize = 10;

        Query query = entityManager.createQuery("select count(c) from Customer c");
        long count = (long)query.getSingleResult();
        int pageNumber = (int)(count / pageSize) + 1;

        query = entityManager.createQuery("select c from Customer c order by c.surname");

        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult(pageNr - 1);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Thing> thingsByPage(int pageNr){
        int pageSize = 10;

        Query query = entityManager.createQuery("select count(c) from Thing c");
        long count = (long)query.getSingleResult();
        int pageNumber = (int)(count / pageSize) + 1;

        query = entityManager.createQuery("select c from Thing c order by c.name");

        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult(pageNr - 1);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Thing> thingByName(String name){
        Query query = entityManager.createQuery("select a from Thing a where a.name = :name");
        query.setParameter("name", name);

        return query.getResultList();
    }

    public List<Object[]> getRentsWithoutReturnDate(){
        Query query = entityManager.createQuery("select t.name, c.name, c.surname, r.rentDate, t.price from Thing t left join Rent r on t.id = r.thing.id left join Customer c on r.customer.id = c.id");

        return query.getResultList();
    }
}
