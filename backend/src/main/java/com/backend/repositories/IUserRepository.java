package com.backend.repositories;

import com.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    User findUserByEmail(String email);
}
