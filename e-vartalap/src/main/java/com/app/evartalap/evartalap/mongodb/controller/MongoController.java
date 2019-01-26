package com.app.evartalap.evartalap.mongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.evartalap.evartalap.mongodb.dao.PostDao;
import com.app.evartalap.evartalap.mongodb.pojos.Post;
import com.app.evartalap.evartalap.mysql.pojos.User;

@RestController
@RequestMapping(value="/")
public class MongoController {

    @Autowired
	
	private PostDao postdao;
    
	private final Logger LOG=LoggerFactory.getLogger(getClass());

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
	
	@PostMapping("/submit")
	  public String getregistration(@RequestParam("post") String post_text,HttpSession hs )
	  {
		  ModelAndView model=new ModelAndView();
		  Post post = new Post();
		 post.setPost_text(post_text);
		 User currentUser=(User)hs.getAttribute("user");
		 post.setUser_id(currentUser.getUser_id());
		 postdao.save(post);
		 model.setViewName("/home");
		 System.out.println("successfull saving");
		 postdao.findAll().size();
		 return "";
		 }
		  
	@GetMapping("/post")
	public String getPost()
	{
		return "/post";
	}
	@PostMapping("/post")
	public String savePost(@RequestParam("post_text")String post_text, HttpSession hs)
	{
		Post post = new Post();
		post.setPost_date(new Date());
		post.setPost_text(post_text);
		User user = (User) hs.getAttribute("user");
		post.setUser_id(user.getUser_id());
		try{
		postdao.save(post);

	}catch(Exception e)
		{
		System.out.println("exception in mongodb comtroller: "+ e);
		return "redirect:home";
		}
		
		return "redirect:listpost";
	
	}
	//getting all list
	@GetMapping("/listpost")
	public String getlistpost()
	{
		System.out.println("in get method of list");
		return "listpost";
	}
	   
		 
	
}
