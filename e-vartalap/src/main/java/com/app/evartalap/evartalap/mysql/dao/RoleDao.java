package com.app.evartalap.evartalap.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.evartalap.evartalap.mysql.pojos.Role;
@Repository("roleRepository ")
public interface RoleDao extends JpaRepository<Role,Integer>{
     // Role findByRole(String role_name);
}
