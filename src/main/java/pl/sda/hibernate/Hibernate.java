package pl.sda.hibernate;

import org.hibernate.Session;
import pl.sda.hibernate.entity.Reader;
import pl.sda.hibernate.entity.Subscription;
import pl.sda.hibernate.utils.HibernateUtil;

import java.util.List;

public class Hibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Subscription subOne = new Subscription();
        subOne.setSubsrciptionId(1);
        subOne.setSubscriptionName("Wyborcza");

        Subscription subTwo = new Subscription();
        subTwo.setSubsrciptionId(2);
        subTwo.setSubscriptionName("Newsweek");

        Subscription subThree = new Subscription();
        subThree.setSubsrciptionId(3);
        subThree.setSubscriptionName("Fakt");


        Reader readerOne = new Reader();
        readerOne.setReaderId(1);
        readerOne.setEmail("demo-user1@mail.com");
        readerOne.setFirstName("Demo");
        readerOne.setLastName("UserOne");

        Reader readerTwo = new Reader();
        readerTwo.setReaderId(2);
        readerTwo.setEmail("demo-user2@mail.com");
        readerTwo.setFirstName("Demo");
        readerTwo.setLastName("UserTwo");

        Reader readerThree = new Reader();
        readerThree.setReaderId(3);
        readerThree.setEmail("demo-user3@mail.com");
        readerThree.setFirstName("Demo");
        readerThree.setLastName("UserThree");


        readerOne.setSubscriptions(List.of(
                subOne, subTwo
        ));

        readerTwo.setSubscriptions(List.of(
                subTwo, subThree
        ));

        readerThree.setSubscriptions(List.of(
                subThree, subOne
        ));

        session.save(readerOne);
        session.save(readerTwo);
        session.save(readerThree);

        // POTWIERDZENIE ZAPISU DO BAZY DANYCH - COMMIT
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }
}
