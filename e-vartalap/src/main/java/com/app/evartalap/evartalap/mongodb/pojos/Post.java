package com.app.evartalap.evartalap.mongodb.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import  lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
@Document
public class Post {
	
	@Id
	private int post_id;
	private int post_abusive;
	private int user_id;
	private  Date post_date = new Date() ;
	private String post_text;
	private String user_name;
	

  
	
	public Post() {
		super();
		
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getPost_abusive() {
		return post_abusive;
	}
	public void setPost_abusive(int post_abusive) {
		this.post_abusive = post_abusive;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_text() {
		return post_text;
	}
	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
    

}
