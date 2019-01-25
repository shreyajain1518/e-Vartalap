package com.app.evartalap.evartalap.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.evartalap.evartalap.mongodb.pojos.Post;

@Repository

public interface PostDao extends MongoRepository<Post,Integer>{

	
}
