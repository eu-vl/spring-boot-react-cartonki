package com.backend.controllers.auth;

public class RegistrationRequest {
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public RegistrationRequest(String firstName, String secondName, String email, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



}
