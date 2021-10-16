package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.entity.Movie;
import pl.sda.hibernate.utils.HibernateUtil;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // tworzenie obiektu do zapisu
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Lord of the Rings");
        movie.setGenre("fantasy");
        movie.setYearOfRelease(2002);
        // nie ustawiamy createdDate - chcemy, zeby hibernate sam nam to utowrzył

        // ZAPIS DO BAZY DANYCH
        session.save(movie);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
