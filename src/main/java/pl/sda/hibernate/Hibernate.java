package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.entity.Book;
import pl.sda.hibernate.utils.HibernateUtil;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // stworzenie encji, ktora zapiszemy w bazie danych
        Book book = new Book();
        book.setId(1);
        book.setTitle("Harry Potter");
        book.setType("fantasy");

        // ZAPIS DO BAZY DANYCH
        session.save(book);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
