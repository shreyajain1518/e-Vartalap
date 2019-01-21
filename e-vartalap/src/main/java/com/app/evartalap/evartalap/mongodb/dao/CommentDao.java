package com.app.evartalap.evartalap.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.evartalap.evartalap.mongodb.pojos.Comment;


public interface CommentDao extends MongoRepository<Comment,Integer>
{

}
