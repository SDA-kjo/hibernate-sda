package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.hibernate.entity.Customer;
import pl.sda.hibernate.entity.Movie;
import pl.sda.hibernate.entity.Order;
import pl.sda.hibernate.utils.HibernateUtil;

import java.util.List;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // zapytanie rownoznaczne z select * from customers
        Query<Customer> query = session.createQuery("from Customer");
        // wykonanue zapytania, czyli de facto jest to rownoznaczne z execute w JDBC
        List<Customer> list = query.list();

        for(Customer c : list) {
            // pobieramy liste zamowien -> tutaj zakladamy, ze Hibernate za nas zaciagnie zamowienia dla kazdego customera
            // czyli stanie sie 'magia' Hibernate'a
            List<Order> orders = c.getOrders();
            System.out.println("Customer: " + c.getCustomerName() + " ma nastepujace zamowienia: ");
            for(Order o : orders) {
                System.out.println("****  OrderNumber: " + o.getOrderNumber() + " | Status: " + o.getStatus());
            }
        }

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
