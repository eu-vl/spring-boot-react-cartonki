package com.backend.services.interfaces;

import com.backend.controllers.auth.RegistrationRequest;
import com.backend.models.User;

import java.util.List;

public interface IUserService {
    User getUserByEmailAndPassword(String email, String password);

    User getUserByEmail(String email);

    boolean saveUser(RegistrationRequest userFromRequest);

    List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUserById(Long id);
}
