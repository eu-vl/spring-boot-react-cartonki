package com.backend.services;

import com.backend.models.Role;
import com.backend.repositories.IRoleRepository;
import com.backend.services.interfaces.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository iRoleRepository;

    public RoleService(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }

    @Override
    public boolean createRole(Role roleFromRequest) {
        Role roleDb = iRoleRepository.findRoleByTitle(roleFromRequest.getTitle());
        if (roleDb != null) {
            return false;
        }
        iRoleRepository.save(roleFromRequest);
        return true;
    }

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<>(iRoleRepository.findAll());
    }

    @Override
    public Role getRoleById(Long id) {
        return iRoleRepository.findRoleById(id);
    }

    @Override
    public Role getRoleByTitle(String title) {
        return iRoleRepository.findRoleByTitle(title);
    }
}
