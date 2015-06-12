package com.memories.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "mood")
    private Collection<Memory> memories;

    public Mood() {
        memories = new ArrayList<Memory>();
    }

    public Collection<Memory> getMemories() {
        return memories;
    }

    public void setMemories(Collection<Memory> memories) {
        this.memories = memories;
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
}
