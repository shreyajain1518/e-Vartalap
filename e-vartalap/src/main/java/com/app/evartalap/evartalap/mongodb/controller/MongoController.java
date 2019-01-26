package com.app.evartalap.evartalap.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.evartalap.evartalap.mongodb.dao.PostDao;
import com.app.evartalap.evartalap.mongodb.pojos.Post;

@RestController
@RequestMapping(value="/")
public class MongoController {

	private final Logger LOG=LoggerFactory.getLogger(getClass());
	private final PostDao postdao;
	
	public MongoController(PostDao postdao){
		
		this.postdao=postdao;
	}
	//getting all posts
	
	@RequestMapping(value="/allpost",method=RequestMethod.GET)
	public List<Post> getAllPosts(){
		LOG.info("getting all posts");
		return postdao.findAll();
		
	}
	//getting post by postid
	
	@RequestMapping(value="/{post_id}",method=RequestMethod.GET)
	public Optional<Post> getPost(@PathVariable Integer post_id){
		LOG.info("getting post with id:{}.",post_id);
		return postdao.findById(post_id);
		
	}
	
	//adding new post
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Post addNewPosts(@RequestBody Post post)
	{
		
		LOG.info("saving post");
		return postdao.save(post);
	}
	
}
