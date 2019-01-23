package com.app.evartalap.evartalap.mysql.controller;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.evartalap.evartalap.mysql.pojos.Role;
import com.app.evartalap.evartalap.mysql.pojos.User;
import com.app.evartalap.evartalap.mysql.service.RoleService;
import com.app.evartalap.evartalap.mysql.service.UserService;


@Controller

public class MySqlController {
  @Autowired
  
  private UserService service;
  @Autowired
  private RoleService roleservice;
  
  @RequestMapping(value={"/","/login"},method=RequestMethod.GET)
  public ModelAndView getLogin(){
	  ModelAndView model=new ModelAndView();
	  model.setViewName("user/login");
	  return model;
	  
  }
  
  @PostMapping("/login")
  public ModelAndView postLogin(@RequestParam("user_email") String email,@RequestParam("user_password") String password,HttpSession hs){
	ModelAndView model=new ModelAndView();
	User user = null;
	try{
	 user=service.findByUser_emailandpassword(email,password);
	}catch(NoResultException e)
	{
		System.out.println(e);
		model.setViewName("user/login");
		return model;
	}
	model.addObject("user",user);
	model.setViewName("user/signup");
	hs.setAttribute("user", user);
	return model;
	
  }

  
  @PostMapping("/user/registration")
  public ModelAndView registration(@RequestBody User user)
  {
	  ModelAndView model=new ModelAndView();
	 if(user.getUser_email().equals(service.findUserByUser_email(user.getUser_email()).getUser_email()))
	 {//Role role = roleservice.saveRole(role);
		Role role = new Role("user");
		roleservice.saveRole(role);
		user.setRole(role);
		
		service.saveUser(user);
	 model.setViewName("/user/login");
	 }
	 
	  model.setViewName("/user/registration");
	 
	 return model;	  
		  
	  }
	 
	  
  	@GetMapping("/forgetpassword")
  	public String forgetPassword()
  	{
  		
  		return "/forgetpassword";
  	}
  	@PostMapping("/forgetpassword")
  	public String changepassword(@RequestParam String email ){
  		
  		
  		return "/login";
  	}
  	
     @RequestMapping(value={"/home/home"},method=RequestMethod.POST)
     public ModelAndView home(){
		return null;
    	 
     }
     @GetMapping("/update")
     public ModelAndView updateProfile(HttpSession hs){
    	 ModelAndView model = new ModelAndView();
    	 model.setViewName("/updateprofile");
    	 return model;
    	 
     }
     @PostMapping("/updateprofile")
     public String updatePorfile(@RequestParam byte[] photo, HttpSession hs)
     {
    	 ModelAndView mv =  new ModelAndView();
    	 User u =(User) mv.getModel().get("user");
    	 //User u = service.findUserByUser_email();
    	 
    	 return null;
     }
     
}

