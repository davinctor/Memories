package com.memories.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "status_relation")
public class StatusRelation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "status")
    private Collection<FriendRelation> friendRelation;

    public StatusRelation() {
        friendRelation = new ArrayList<FriendRelation>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<FriendRelation> getFriendRelation() {
        return friendRelation;
    }

    public void setFriendRelation(Collection<FriendRelation> friendRelation) {
        this.friendRelation = friendRelation;
    }
}
