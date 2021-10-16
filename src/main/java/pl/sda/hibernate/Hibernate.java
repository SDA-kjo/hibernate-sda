package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.utils.HibernateUtil;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("SUKCES");

        session.close();
        HibernateUtil.close();
    }
}
