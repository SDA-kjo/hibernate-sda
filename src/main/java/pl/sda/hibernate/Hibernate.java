package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.entity.Person;
import pl.sda.hibernate.entity.Teacher;
import pl.sda.hibernate.entity.TeacherId;
import pl.sda.hibernate.utils.HibernateUtil;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Teacher teacher = new Teacher();
        TeacherId teacherId = new TeacherId();
        teacherId.setDocumentId(123);
        teacherId.setLicence("Licence abc");
        teacher.setTeacherId(teacherId);

        Person person = new Person();
        person.setFirstName("Adam");
        person.setLastName("Kwiatkowski");
        teacher.setPerson(person);

        // ZAPIS DO BAZY DANYCH
        session.save(teacher);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
