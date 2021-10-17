package pl.sda.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    private int readerId;

    private String email;

    private String firstName;

    private String lastName;

    @ManyToMany
    @JoinTable(name = "reader_subscriptions", joinColumns = {@JoinColumn(referencedColumnName = "readerId")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "subsrciptionId")})
    private List<Subscription> subscriptions;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readeId) {
        this.readerId = readeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
