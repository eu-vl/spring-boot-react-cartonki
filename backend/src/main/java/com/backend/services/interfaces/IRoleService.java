package com.backend.services.interfaces;

import com.backend.models.Role;

import java.util.List;

public interface IRoleService {
    boolean createRole(Role roleFromRequest);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByTitle(String title);
}
