package com.app.evartalap.evartalap.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.app.evartalap.evartalap.mongodb.pojos.Post;

public interface PostDao extends MongoRepository<Post,Integer>{

	@Query("{user_id:?0}")
	List<Post>findByuser_id(int user_id);
	List<Post>fildAll();
	@Query("{post_abusive:?0}")
	List<Post> findByPost_abusive(int post_abusive);
	
	
}
