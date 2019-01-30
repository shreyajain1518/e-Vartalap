package com.app.evartalap.evartalap.mongodb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.app.evartalap.evartalap.mongodb.pojos.Post;
@Repository
@Transactional
public interface PostDao extends MongoRepository<Post,Integer>{

	
	
}
