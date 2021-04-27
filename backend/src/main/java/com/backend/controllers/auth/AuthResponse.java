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

}
