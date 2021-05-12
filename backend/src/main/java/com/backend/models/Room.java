package com.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "user_room",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<User> users = new ArrayList<>();

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "room")
    private List<Card> cards = new ArrayList<>();

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "lead", nullable = false)
    private User lead;

    public Room() {
    }

    public Room(String title, User lead){
        this.title = title;
        this.lead = lead;
    }

    public User getLead() {
        return lead;
    }

    public void setLead(User lead) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
