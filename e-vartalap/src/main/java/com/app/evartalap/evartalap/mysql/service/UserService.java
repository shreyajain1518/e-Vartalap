package com.app.evartalap.evartalap.mysql.service;

import com.app.evartalap.evartalap.mysql.pojos.User;

public interface UserService {
	//public User findUserByEmail(String email);
	public void saveUser(User user);

	public User findUserByUser_email(String user_email);
	User findByUser_emailandpassword(String user_email,String user_password);
	String forgetpassword(String user_email);
}
