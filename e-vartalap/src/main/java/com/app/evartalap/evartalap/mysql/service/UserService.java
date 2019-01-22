package com.app.evartalap.evartalap.mysql.service;

import com.app.evartalap.evartalap.mysql.pojos.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
