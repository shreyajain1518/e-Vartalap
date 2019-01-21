package com.app.evartalap.evartalap.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.evartalap.evartalap.mongodb.pojos.Post;

public interface PostDao extends MongoRepository<Post,Integer>{

}
