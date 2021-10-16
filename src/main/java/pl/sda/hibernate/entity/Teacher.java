package pl.sda.hibernate.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

    @EmbeddedId // oznacza uzycie klucza zlozonego
    private TeacherId teacherId;

    @Embedded
    private Person person;


    public TeacherId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherId teacherId) {
        this.teacherId = teacherId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
