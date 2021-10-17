package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select customerName from Customer"); // proste zapytanie HQL
        List<String> listOfNames = query.getResultList(); // odebranie wynikow
        listOfNames.forEach(System.out::println); // uzycie referencji metody zamiast lambdy

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
