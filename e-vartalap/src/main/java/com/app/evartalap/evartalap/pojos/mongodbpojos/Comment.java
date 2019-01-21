
package com.app.evartalap.evartalap.pojos.mongodbpojos;


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
	private String[] comment_ratings;
	private int[] comment_reviews;
	private int comment_like;
	private int comment_dislike;
   

   
   
   
   
}
