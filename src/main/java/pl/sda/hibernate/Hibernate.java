package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.utils.HibernateUtil;

import java.util.Optional;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // zwrocenie optionala - jezeli nie ma wyniku to bedzie pusty
        Optional result =  session.createQuery("select sum(creditLimit) from Customer").uniqueResultOptional();

        // wykorzystanie lambdy do pobrania wyniku z optionala
        result.ifPresent(s -> System.out.println("Laczna suma wszyskich limitow to: " + result));


        /**
         * Przyklady: https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
         */

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
