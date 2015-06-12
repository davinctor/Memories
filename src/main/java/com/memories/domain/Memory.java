package com.memories.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "memories")
public class Memory {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text",columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "mood_type_id")
    private Mood mood;

    @Column(name = "mood_descr")
    private String moodDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "memory", fetch = FetchType.EAGER)
    private Collection<Picture> pictures;

    public Memory() {
        pictures = new ArrayList<Picture>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMoodDescription() {
        return moodDescription;
    }

    public void setMoodDescription(String moodDescription) {
        this.moodDescription = moodDescription;
    }

    public Collection<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Collection<Picture> pictures) {
        this.pictures = pictures;
    }
}
