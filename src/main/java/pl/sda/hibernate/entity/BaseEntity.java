package pl.sda.hibernate.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    private int id;

    private LocalDate createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist // to oznacza, ze hibernate wywola ta metode tuz przed zapisem encji do bazy danych. UWAGA, bedzie wywolane tylko raz
    public void createDate() {
        createdDate = LocalDate.now();
    }
}
