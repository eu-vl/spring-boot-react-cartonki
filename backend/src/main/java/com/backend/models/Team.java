package com.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @JsonManagedReference
    @ManyToMany(mappedBy = "teams")
    private Set<User> users = new HashSet<>();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="lead", nullable=false)
    private User lead;

    @JsonBackReference
    @OneToMany(mappedBy = "team")
    private List<Room> rooms = new ArrayList<>();

    public Team() {
    }

    public Team(String title, User lead) {
        this.title = title;
        this.lead = lead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public User getLead() {
        return lead;
    }

    public void setLead(User lead) {
        this.lead = lead;
    }
}
