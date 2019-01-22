package com.app.evartalap.evartalap.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.evartalap.evartalap.mysql.pojos.User;


@Repository("userRepository")
public interface UserDao extends JpaRepository<User,Integer>{
    /* User validateUser(String em,String pass);
	 String register(User u);
	 void updatePassword(User u);
     String updateProfile(User u);
	 String delete(User u);
	 void delete(Integer userid);
	 User getEmailById(Integer userid);
	 User getUserlById(Integer userid);
	 List<User> findAll();
	 List<User> findByProperty(String propName,Object propValue);*/
	User findByEmail(String email);
}
