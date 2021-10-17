package pl.sda.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    private int subsrciptionId;

    private String subscriptionName;

    @ManyToMany(mappedBy = "subscriptions")
    private List<Reader> readers;

    public int getSubsrciptionId() {
        return subsrciptionId;
    }

    public void setSubsrciptionId(int subsrciptionId) {
        this.subsrciptionId = subsrciptionId;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
}
