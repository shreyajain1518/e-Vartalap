package com.app.evartalap.evartalap.mysql.pojos;


import javax.persistence.*;





@Entity
public class User {

	private Integer user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private int active;
	
	
	
	
	private Role role;
	
	public User() {
		super();
	}

	public User(String user_name, String user_email, String user_password, Role role) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.role = role;
	}
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + ", role=" + role + "]";
	}

	
	
	
	
	
	
}
