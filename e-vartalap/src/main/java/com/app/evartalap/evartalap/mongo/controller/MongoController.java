
package com.app.evartalap.evartalap.mongo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.evartalap.evartalap.mongodb.dao.CommentDao;
import com.app.evartalap.evartalap.mongodb.dao.PostDao;
import com.app.evartalap.evartalap.mongodb.pojos.Comment;
import com.app.evartalap.evartalap.mongodb.pojos.Post;
import com.app.evartalap.evartalap.mysql.dao.KeyGeneratorDao;
import com.app.evartalap.evartalap.mysql.pojos.KeyGenerator;
import com.app.evartalap.evartalap.mysql.pojos.User;

@Controller
//@RequestMapping(value = "/")
@Transactional
@EnableMongoRepositories(basePackages = "com.app.evartalap.evartalap.mongodb.dao")
public class MongoController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final PostDao postdao;
	@Autowired 
	KeyGeneratorDao keydao;
	
	@Autowired
	private CommentDao commentdao;
	
	MongoController(PostDao postdao) {

		this.postdao = postdao;
	}
	// getting all posts

	@RequestMapping(value = "/allpost", method = RequestMethod.GET)
	public List<Post> getAllPosts() {
		LOG.info("getting all posts");
		return postdao.findAll();

	}
	
	
		
	
	
	// getting post by postid

	@RequestMapping(value = "/{post_id}", method = RequestMethod.GET)
	public Optional<Post> getPost(@PathVariable Integer post_id) {
		LOG.info("getting post with id:{}.", post_id);
		return postdao.findById(post_id);

	}

	// adding new post

	@PostMapping("/submit")
	public ModelAndView savePost(@RequestParam("post") String post_text, HttpSession hs) {
		ModelAndView model = new ModelAndView();
		User currentUser = (User) hs.getAttribute("user");
		if (currentUser == null) {
			model.setViewName("login1");
		}
		
		//kg.setId(1);
		
		Post post = new Post();
		post.setPost_text(post_text);
	
		int count=keydao.findByIdnum(1).getValue();
        post.setPost_id(count);
		post.setUser_id(currentUser.getUser_id());
		post.setUser_name(currentUser.getUser_name());
		postdao.save(post);
		System.out.println("successfull saving");
		KeyGenerator kg = new KeyGenerator();
		kg.setId(1);
		kg.setValue(++count);
		keydao.saveAndFlush(kg);
		
		model.setViewName("home");
		return model;
	}
	@PostMapping("/comment")
	public String saveComment(@RequestParam("comment") String comment_text,@RequestParam("newid") Integer post_id, HttpSession hs) {
		User currentUser = (User) hs.getAttribute("user");
		if (currentUser == null) {
			return "redirect:/login1";
		}
	
		Comment comment = new Comment();
		System.out.println("post id is " + post_id);
		
		
		int count=keydao.findByIdnum(2).getValue();
		

		comment.setComment_id(count);
		comment.setComment_text(comment_text);
		comment.setUserId(currentUser.getUser_id());
		comment.setPostId(post_id);
		commentdao.save(comment);
		KeyGenerator kg = new KeyGenerator();
		kg.setId(2);
		kg.setValue(++count);
		keydao.saveAndFlush(kg);
		System.out.println("commnet is saved in commnet");
		
		System.out.println(comment_text);
		System.out.println("commnet is saved and getcommnets is null");
		
		return "redirect:/home";
	}
	@GetMapping("/home")
	public ModelAndView loadAllPost(HttpSession hs) {
		ModelAndView model = new ModelAndView();
		User currentUser = (User) hs.getAttribute("user");
		if (currentUser == null) {
			model.setViewName("login1");
			return model;
		}
		model.setViewName("home");
												hs.setAttribute("allPost", postdao.findAll());
												hs.setAttribute("allComment", commentdao.findAll());
												List<Comment> post1 = commentdao.findAll();
												for(Comment post : post1)
												{
												System.out.println(post);
													}
		return model;
	}
	@GetMapping("/postabusive")
	public String getPostabusive(@RequestParam("post_id") Integer post_id, HttpSession hs)
	{
		Post post = null;
		ArrayList<Post> list = (ArrayList<Post>)postdao.findAll();
						for(Post pos :list )
						{
							if(pos.getPost_id()==post_id)
							{
								post=pos;
							}
						}
System.out.println(post);
post.setPost_abusive(post.getPost_abusive()+1);
postdao.save(post);
		return "redirect:/home";
	}
	@GetMapping("/commentabusive")
	public String getCommnetabusive(@RequestParam("comment_id") int comment_id, HttpSession hs)
	{
		
	
		
		Comment comt = null;
							ArrayList<Comment> list = (ArrayList<Comment>)commentdao.findAll();
											for(Comment com :list )
											{
												if(com.getComment_id()==comment_id)
												{
													comt=com;
												}
											}
		System.out.println(comt);
		comt.setComment_abusive(comt.getComment_abusive()+1);
		commentdao.save(comt);
		return "redirect:/home";
	}
	
	@GetMapping("/commentdislike")
	public String getCommnetdislike(@RequestParam("comment_id") Integer comment_id, HttpSession hs)
	{
		
		Comment comt = null;
		ArrayList<Comment> list = (ArrayList<Comment>)commentdao.findAll();
						for(Comment com :list )
						{
							if(com.getComment_id()==comment_id)
							{
								comt=com;
							}
						}
System.out.println(comt);
comt.setComment_dislike(comt.getComment_dislike()+1);
commentdao.save(comt);
		return "redirect:/home";
	}
	@GetMapping("/commentlike")
	public String getCommnetlike(@RequestParam("comment_id") Integer comment_id, HttpSession hs)
	{
		
		Comment comt = null;
		ArrayList<Comment> list = (ArrayList<Comment>)commentdao.findAll();
						for(Comment com :list )
						{
							if(com.getComment_id()==comment_id)
							{
								comt=com;
							}
						}
System.out.println(comt);
comt.setComment_like(comt.getComment_like()+1);
commentdao.save(comt);
		return "redirect:/home";
	}
}
