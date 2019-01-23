package com.app.evartalap.evartalap.mysql.service;

import java.util.HashSet;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.evartalap.evartalap.mysql.dao.RoleDao;
import com.app.evartalap.evartalap.mysql.dao.UserDao;
import com.app.evartalap.evartalap.mysql.pojos.Role;
import com.app.evartalap.evartalap.mysql.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	
	/*@Override
	public User findUserByEmail(String email) {
		return userdao.findByEmail(email);
	}
*/
	@Override
	public void saveUser(User user) {
		
		//user.setUser_password(bCryptPasswordEncoder.encode(user.getUser_password()));
		//user.setActive(1);
		//userdao.findByUser_email(user_email);
		//roledao.
	//	Role userRole=roledao.findByRole("ADMIN");
		//user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
		userdao.save(user);
	}
	
	@Override
	public User findUserByUser_email(String user_email) {
		// TODO Auto-generated method stub
		return userdao.findByUser_email(user_email);
	}
	@Override
	public User findByUser_emailandpassword(String user_email, String user_password) {

		User user=userdao.findByUser_emailandpassword(user_email, user_password);
		return user;
	}

	

}
