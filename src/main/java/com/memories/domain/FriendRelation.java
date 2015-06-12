package com.memories.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friend_relations")
public class FriendRelation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusRelation status;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_action")
    private Date dateAction;

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public StatusRelation getStatus() {
        return status;
    }

    public void setStatus(StatusRelation status) {
        this.status = status;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
