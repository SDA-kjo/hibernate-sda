package pl.sda.hibernate.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@IdClass(StudentId.class) // referencja do klasy z kluczem złożonym
public class Student {

    /**
     * Te same pola co w StudentId - niestety w tym rozwiazaniu nalezy skopiowac te pola
     */
    @Id
    private int documentId;
    @Id
    private String indexNumber;

    @Embedded
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
}
