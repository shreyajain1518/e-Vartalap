package com.app.evartalap.evartalap.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.app.evartalap.evartalap.mongodb.pojos.Post;

public interface PostDao extends MongoRepository<Post,Integer>{

	
	
}
