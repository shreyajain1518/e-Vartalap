package com.app.evartalap.evartalap.pojos.mongodbpojos;

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
	Integer post_id;
	int post_abusive;
	int userId;
    Date post_date;
    String post_text;
    int comment_id;
    String[] post_ratings;
    int[] post_reviews;
    Comment[] comments;
	
    
    
    

}
