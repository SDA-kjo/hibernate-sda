package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.entity.Person;
import pl.sda.hibernate.entity.Student;
import pl.sda.hibernate.entity.Teacher;
import pl.sda.hibernate.entity.TeacherId;
import pl.sda.hibernate.utils.HibernateUtil;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // stworzenie encji, ktora zapiszemy w bazie danych
        Student student = new Student();
        // dla studenta nie tworzymy studentId, tylko w obiekcie student ustawiamy pola z klucza zlozonego
        student.setDocumentId(123);
        student.setIndexNumber("09876543");

        Person person = new Person();
        person.setLastName("Bond");
        person.setFirstName("James");
        student.setPerson(person);

        // ZAPIS DO BAZY DANYCH
        session.save(student);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
