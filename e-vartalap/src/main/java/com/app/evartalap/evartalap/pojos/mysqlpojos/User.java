package com.app.evartalap.evartalap.pojos.mysqlpojos;
import javax.persistence.*;
import com.mysql.cj.jdbc.Blob;

@Entity
public class User {

	int user_id;
	String user_name;
	String user_email;
	String user_password;
	Role role;
	Blob user_photo;
	
	public User() {
		super();
	}

	public User(String user_name, String user_email, String user_password, Role role, Blob user_photo) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.role = role;
		this.user_photo = user_photo;
	}
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Column(unique = true)
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Blob getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(Blob user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", role=" + role + ", user_photo=" + user_photo + "]";
	}
	
	
	
	
	
}
