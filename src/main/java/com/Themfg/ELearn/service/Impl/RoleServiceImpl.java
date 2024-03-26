package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Role;
import com.Themfg.ELearn.repository.RolesRepository;
import com.Themfg.ELearn.service.Interface.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RolesRepository rolesRepository;

    public RoleServiceImpl(RolesRepository rolesRepository){
        this.rolesRepository=rolesRepository;
    }

    @Override
    public Role findRoleByName(String roleName){
        return rolesRepository.findByRoleName(roleName);
    }
}
