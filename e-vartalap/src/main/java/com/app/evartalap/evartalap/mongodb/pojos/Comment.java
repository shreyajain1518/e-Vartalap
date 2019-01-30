
package com.app.evartalap.evartalap.mongodb.pojos;


import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;
import  lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
@Document
public class Comment {
	@Id
	private int comment_id;
	private int comment_abusive;
	private int postId;
	private int userId;
	private String  comment_text;
	
	
	private int comment_like;
	private int comment_dislike;
	private Date comment_date  = new Date();
	private String user_name;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_abusive() {
		return comment_abusive;
	}
	public void setComment_abusive(int comment_abusive) {
		this.comment_abusive = comment_abusive;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
	
	public int getComment_like() {
		return comment_like;
	}
	public void setComment_like(int comment_like) {
		this.comment_like = comment_like;
	}
	public int getComment_dislike() {
		return comment_dislike;
	}
	public void setComment_dislike(int comment_dislike) {
		this.comment_dislike = comment_dislike;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", comment_abusive=" + comment_abusive + ", postId=" + postId
				+ ", userId=" + userId + ", comment_text=" + comment_text + ", comment_like=" + comment_like
				+ ", comment_dislike=" + comment_dislike + ", comment_date=" + comment_date + ", user_name=" + user_name
				+ "]";
	}
	

   
   
   
   
}
