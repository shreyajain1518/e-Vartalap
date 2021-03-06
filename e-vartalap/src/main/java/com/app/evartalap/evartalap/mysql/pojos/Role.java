package com.app.evartalap.evartalap.mysql.pojos;

import javax.persistence.*;

@Entity
public class Role {
	
	private Integer role_id;
	private String role_name;
	public Role() {
		super();
		System.out.println("Role default constructor");
	}
	public Role(String role_name) {
		super();
		this.role_name = role_name;
	}
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	

}
