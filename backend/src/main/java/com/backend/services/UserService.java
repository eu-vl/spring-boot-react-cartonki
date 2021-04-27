package com.backend.services;

import com.backend.controllers.auth.RegistrationRequest;
import com.backend.models.Role;
import com.backend.models.User;
import com.backend.repositories.IUserRepository;
import com.backend.services.interfaces.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
    private final IUserRepository iUserRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository iUserRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User userDb = iUserRepository.findUserByEmail(email);
        if (userDb != null) {
            if (passwordEncoder.matches(password, userDb.getPassword()))
                return userDb;
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return iUserRepository.findUserByEmail(email);
    }

    @Override
    public boolean createUser(RegistrationRequest userFromRequest) {
        User userDb = iUserRepository.findUserByEmail(userFromRequest.getEmail());
        if (userDb != null) {
            return false;
        }
        User user = new User();
        user.setFirstName(userFromRequest.getFirstName());
        user.setSecondName(userFromRequest.getSecondName());
        user.setEmail(userFromRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userFromRequest.getPassword()));

        Role role = roleService.getRoleByTitle("ROLE_ADMIN");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);

        iUserRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(iUserRepository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        return iUserRepository.findUserById(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        if (iUserRepository.findById(id).isPresent()) {
            iUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
