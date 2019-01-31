package com.app.evartalap.evartalap.mysql.service;

import java.util.HashSet;

import javax.persistence.NoResultException;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	@Autowired
	JavaMailSender javamailserver;
	
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
		try{
		userdao.saveAndFlush(user);
		}catch(Exception e)
		{
		System.out.println("Exception in user");
		}
	}
	
	@Override
	public User findUserByUser_email(String user_email) {

		User user = null;
		try{
			user = userdao.findByUser_email(user_email);
		}catch(Exception e)
		{
			System.out.println("no email is found ");
		}
	
		return user;
	}
	@Override
	public User findByUser_emailandpassword(String user_email, String user_password) {

		User user=userdao.findByUser_emailandpassword(user_email, user_password);
		return user;
	}

	
	@Override
	public String forgetpassword(String user_email) {
		
		User user = null;
		
		try{
			//user = userdao.findByUser_email(user_email);
			//String password = user.getUser_password();
			String password = "password";
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(user_email);
			mail.setFrom("z.rahul.k@gmail.com");
			mail.setSubject("Password");
			mail.setText(password);
			javamailserver.send(mail);
		}
		catch(NoResultException e)
		{
			System.out.println(e);
			return "invalid email";
		}
		
		return "valid";
	}

	

}
