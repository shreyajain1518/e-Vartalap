package com.app.evartalap.evartalap.mysql.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.evartalap.evartalap.mysql.pojos.User;
import com.app.evartalap.evartalap.mysql.service.UserService;

@Controller

public class MySqlController {
  @Autowired
  
  private UserService service;
  
  
  @RequestMapping(value={"/","/login"},method=RequestMethod.GET)
  public ModelAndView UserLogin(){
	  ModelAndView model=new ModelAndView();
	  model.setViewName("user/login");
	  return model;
	  
  }
  @RequestMapping(value={"/signup"},method=RequestMethod.GET)
  public ModelAndView signup(){
	ModelAndView model=new ModelAndView();
	User user=new User();
	model.addObject("user",user);
	model.setViewName("user/signup");
	return model;
	
  }
  @RequestMapping(value={"/signup"},method=RequestMethod.POST)
  public ModelAndView createUser(@Valid User user ,BindingResult bindingResult)
  {
	  ModelAndView model=new ModelAndView();
	  User userExists=service.findUserByEmail(user.getUser_email());
	  if(userExists!=null)
	  {
		  bindingResult.rejectValue("email","error.user","this email already exists");
		  
	  }
	  if(bindingResult.hasErrors()){
		  model.setViewName("user/signup");
		  
		  
	  }
	  else{
		  service.saveUser(user);
		  model.addObject("msg", "userhas been registered successfully");
		  model.addObject("user",new User());
		  model.setViewName("user/signup");
		  
		  
	  }
	  return model;
	  
  }
  
     @RequestMapping(value={"/home/home"},method=RequestMethod.POST)
     public ModelAndView home(){
		return null;
    	 
     }
  }

