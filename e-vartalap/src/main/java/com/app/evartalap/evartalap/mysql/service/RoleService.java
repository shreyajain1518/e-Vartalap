package com.app.evartalap.evartalap.mysql.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.evartalap.evartalap.mysql.dao.RoleDao;
import com.app.evartalap.evartalap.mysql.pojos.Role;

@Service
@Transactional
public class RoleService {
@Autowired
	RoleDao rd;


 public void saveRole(Role role)
 {
	rd.save(role);
 }
}
