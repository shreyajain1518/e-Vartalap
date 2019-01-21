
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
   int comment_id;
   int comment_abusive;
   int postId;
   int userId;
   String  comment_text;
   String[] comment_ratings;
   int[] comment_reviews;
   int comment_like;
   int comment_dislike;
   

   
   
   
   
}
