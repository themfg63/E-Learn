package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
