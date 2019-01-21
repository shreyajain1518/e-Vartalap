package com.app.evartalap.evartalap.mongodb.pojos;

import java.util.Date;

import org.springframework.data.annotation.Id;
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
	private int userId;
	private  Date post_date;
	private String post_text;
	
	private String[] post_ratings;
	private  int[] post_reviews;
	private Comment[] comments;
	
    
    
    

}
