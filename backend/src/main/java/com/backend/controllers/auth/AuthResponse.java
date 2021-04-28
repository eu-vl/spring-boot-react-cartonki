package com.backend.controllers.auth;

import com.backend.models.User;

public class AuthResponse {
    private String token;
    private Long id;
    private String firstName;
    private String secondName;
    private String email;

    public AuthResponse() {
    }

    public AuthResponse build(String token, User user) {
        AuthResponse response = new AuthResponse();
        response.token = token;
        response.id = user.getId();
        response.firstName = user.getFirstName();
        response.secondName = user.getSecondName();
        response.email = user.getEmail();
        return response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
