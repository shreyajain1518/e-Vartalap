package com.app.evartalap.evartalap.mysql.service;

import java.util.HashSet;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.evartalap.evartalap.mysql.dao.RoleDao;
import com.app.evartalap.evartalap.mysql.dao.UserDao;
import com.app.evartalap.evartalap.mysql.pojos.Role;
import com.app.evartalap.evartalap.mysql.pojos.User;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private RoleDao roledao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User findUserByEmail(String email) {
		return userdao.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		
		user.setUser_password(bCryptPasswordEncoder.encode(user.getUser_password()));
		user.setActive(1);
		Role userRole=roledao.findByRole("ADMIN");
		//user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
		userdao.save(user);
	}

	

}
