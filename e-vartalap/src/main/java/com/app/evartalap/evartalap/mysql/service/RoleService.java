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
	 if(role!=null){
		 try{
	 
	rd.saveAndFlush(role);
	System.out.println("role is saved");
		 }
		 catch(Exception e){
			 System.out.println("Exception in role");
		 }
	 }
	 else{
		 System.out.println("role is null");
	 }
 }
}
