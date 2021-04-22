package com.backend.repositories;

import com.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);

    Role findRoleByTitle(String title);
}
