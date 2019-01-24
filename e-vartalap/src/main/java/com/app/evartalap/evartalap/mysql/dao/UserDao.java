package com.app.evartalap.evartalap.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.evartalap.evartalap.mysql.pojos.User;


@Repository
public interface UserDao extends JpaRepository<User,Integer>{
  
	@Query(value = "select u from User u where u.user_email = ?1 and u.user_password = ?2")
	User findByUser_emailandpassword(String user_email,String user_password);
	@Query(value  = "select u from User u where u.user_email = ?1")
	User findByUser_email(String user_email);
	
}

