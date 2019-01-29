package com.app.evartalap.evartalap.mongo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
import com.app.evartalap.evartalap.mysql.pojos.User;

@RestController
@RequestMapping(value = "/")
public class MongoController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final PostDao postdao;
	@Autowired 
	private  CommentDao commentdao;
	
	
	
	public MongoController(PostDao postdao) {

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
		
		Post post = new Post();
		post.setPost_text(post_text);
        post.setPost_id( postdao.findAll().size()+1);
		post.setUser_id(currentUser.getUser_id());
		post.setUser_name(currentUser.getUser_name());
		postdao.save(post);
		System.out.println("successfull saving");
		hs.setAttribute("allPost", postdao.findAll());
		model.setViewName("home");
		return model;
	}
	@PostMapping("/comment")
	public String saveComment(@RequestParam("comment") String comment_text,@RequestParam("post_id") int post_Id, HttpSession hs) {
		User currentUser = (User) hs.getAttribute("user");
		if (currentUser == null) {
			return "redirect:/login1";
		}
		Comment post = new Comment();
//		post.getComment_text(comment_text);
//        post.setPost_id( UUID.randomUUID();
//		post.setUser_id(currentUser.getUser_id());
//		post.setUser_name(currentUser.getUser_name());
//		postdao.save(post);
//		System.out.println("successfull saving");
		return "redirect:/home1";
	}
	@GetMapping("/home1")
	public ModelAndView loadAllPost(HttpSession hs) {
		ModelAndView model = new ModelAndView();
		User currentUser = (User) hs.getAttribute("user");
		if (currentUser == null) {
			model.setViewName("login1");
			return model;
		}
		model.setViewName("home");
		hs.setAttribute("allPost", postdao.findAll());
		return model;
	}

	@GetMapping("/commentlist")
	public String getcommentslist(@RequestParam int postid,Model map)
	{
		List<Comment> comment = commentdao.findByPostId(postid);
	    map.addAttribute("commentlist", comment);
		return "commnetlist";	
	}
	@PostMapping("/commnetlist")
	public String postcommnetlist()
	{
		return "redirect:postlist";
	}
	@GetMapping("/postlist")
	public String getpostlist(HttpSession hs,Model map)
	{
		List<Post> postlist = postdao.findAll();
		map.addAttribute("postlist", postlist);
		return "postlist";
	}
										

}
