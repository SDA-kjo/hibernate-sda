package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.hibernate.entity.Book;
import pl.sda.hibernate.utils.HibernateUtil;

import java.util.List;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // WYKONIANIE ZAPYTANIA. ROWNOZNACZNE Z SELECT * FROM BOOKS
        Query<Book> result = session.createQuery("from Book WHERE id = 1");
        // POBRANIE WYNIKU JAKO LISTY
        List<Book> list = result.list();
        // ZAKLADAMY, ZE BEDZIE JEDEN WYNIK
        Book harryPotter = list.get(0);
        // SPRAWDZAMY TYPE. HIBERNATE POWINIEN ZROBIC JOIN-a TABEL books I book_type
        System.out.println("Harry Potter type: " + harryPotter.getType());

        // ROBIMY UPDATE TYPU
        harryPotter.setType("sci-fi");
        session.update(harryPotter);

        // USUWAMY REKORD
        session.delete(harryPotter);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
