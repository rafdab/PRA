package Wypozyczalnia.queries;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Drop {
    EntityManager entityManager;

    public Drop(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void emptyCustomerTable(){
        entityManager.createQuery("delete from Customer").executeUpdate();
    }

    public void emptyRentTable(){
        entityManager.createQuery("delete from Rent ").executeUpdate();
    }

    public void emptyThingTable(){
        entityManager.createQuery("delete from Thing ").executeUpdate();
    }

    public void emptyEmployeeTable(){
        entityManager.createQuery("delete from Employee ").executeUpdate();
    }

    public void emptyAddressTable(){
        entityManager.createQuery("delete from Address ").executeUpdate();
    }

    public void emptyAllTables(){
        emptyRentTable();
        emptyThingTable();
        emptyEmployeeTable();
        emptyCustomerTable();
        emptyAddressTable();
    }

    public void deleteEmployee(int id){
        entityManager.createQuery("delete from Employee where Employee.id = :id").setParameter("id", id).executeUpdate();
    }

    public void deleteCustomer(int id){
        entityManager.createQuery("delete from Customer where Customer .id = :id").setParameter("id", id).executeUpdate();
    }

    public void deleteThing(int id){
        entityManager.createQuery("delete from Thing where Thing .id = :id").setParameter("id", id).executeUpdate();
    }

    public void deleteRent(int id){
        entityManager.createQuery("delete from Rent where Rent .id = :id").setParameter("id", id).executeUpdate();
    }

    public void deleteAddress(int id){
        entityManager.createQuery("delete from Address where Address .id = :id").setParameter("id", id).executeUpdate();
    }
}
