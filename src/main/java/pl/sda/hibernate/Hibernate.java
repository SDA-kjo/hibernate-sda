package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.hibernate.entity.Customer;
import pl.sda.hibernate.utils.HibernateUtil;

import java.util.List;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Customer customerToSave = new Customer();
        customerToSave.setCustomerName("Ibis hotel");
        customerToSave.setContactFirstName("Jan");
        customerToSave.setContactLastName("Kowalski");
        customerToSave.setCity("Warszawa");
        customerToSave.setAddressLine1("Grzybowska");
        customerToSave.setState("mazowieckie");
        customerToSave.setPostalCode("00-000");
        customerToSave.setCountry("Poland");
        customerToSave.setPhone("123-456-789");

        session.save(customerToSave);

        session.getTransaction().commit();

        Query<Customer> q = session.createQuery("From Customer", Customer.class);
        List<Customer> resultList = q.list();

        for(Customer c: resultList) {
            System.out.println("Customer: " + c.getCustomerNumber() + " : " + c.getCustomerName());
        }


        session.close();
        HibernateUtil.close();
    }
}
