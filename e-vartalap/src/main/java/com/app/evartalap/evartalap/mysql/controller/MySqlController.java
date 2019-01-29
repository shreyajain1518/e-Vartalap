
package com.app.evartalap.evartalap.mysql.controller;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.evartalap.evartalap.mysql.dao.UserDao;
import com.app.evartalap.evartalap.mysql.pojos.Role;
import com.app.evartalap.evartalap.mysql.pojos.User;
import com.app.evartalap.evartalap.mysql.service.RoleService;
import com.app.evartalap.evartalap.mysql.service.UserService;


@Controller
@ComponentScan
@RequestMapping("/")
public class MySqlController {
  @Autowired
  
  private UserService service;
  @Autowired
  private RoleService roleservice;
  @Autowired
  private UserDao userdao;
  
  @GetMapping("/home")
  public String get()
  {
	  System.out.println("================getCalled");
	  return "home";
  }
  
  
  @GetMapping("/login1")
  public String getLogin(){
	  
	  
	  System.out.println("get login");
	  return "login1";
	  
  }
  
  @PostMapping("/login1")
  public String postLogin(@RequestParam("user_email") String email,@RequestParam("user_password") String password,HttpSession hs){
	ModelAndView model=new ModelAndView();
	User user = null;
	try{
		System.out.println("post method of login");
	 user=service.findByUser_emailandpassword(email,password);
	}catch(NoResultException e)
	{
		System.out.println(e);
		model.setViewName("/login1");
		return "redirect:/login1";
	}
	model.addObject("user",user);
	model.setViewName("/home");
	hs.setAttribute("user", user);
	if(user==null)
		return "redirect:/login1";
	else
	return "redirect:"
			+ "/home1";
	
  }
  @GetMapping("/register")
  public String registration()
  {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("register");
	  System.out.println("Register get method");
	  return "register";
  }
  @PostMapping("/register")
  public String getregistration(@RequestParam("user_name") String user_name,@RequestParam("user_email") String user_email, @RequestParam("user_password") String user_password )
  {
	  ModelAndView model=new ModelAndView();
	  User user = new User();
	  System.out.println("register post method");
	 if(service.findUserByUser_email(user_email)==null)
	 {//Role role = roleservice.saveRole(role);
		Role role = new Role("user");
		roleservice.saveRole(role);
		user.setRole(role);
		user.setUser_name(user_name);
		user.setUser_email(user_email);
		user.setUser_password(user_password);
		user.setActive(0);
		user.setUser_photo(null);
		service.saveUser(user);
	 model.setViewName("/login");
	 System.out.println("successfull saving");
	 return "redirect:login1";
	 }
	 else{
	  model.setViewName("/register");
	  System.out.println("Unsuccessfull ");
	 return "redirect:home";	  
	 }
	  }
	 
	  
  	@GetMapping("/forgetpassword")
  	public String forgetPassword()
  	{
  		
  		return "forgot_password";
  	}
  	@PostMapping("/forgetpassword")
  	public ModelAndView changepassword(@RequestParam String user_email ){
  		ModelAndView model = new ModelAndView();
  		if(service.forgetpassword(user_email).equals("valid")){
  			model.addObject("message","successful");
  			
  		 model.setViewName   ("redirect:/login");
  		return model;
  		}
  		else{
  			model.addObject("message","unsuccessful");
  			 model.setViewName("redirect:/forgot_password");
  			return	model;	
  		}
  	
  	}	
  	
  	
     @RequestMapping(value={"/home/home"},method=RequestMethod.POST)
     public ModelAndView home(){
		return null;
    	 
     }
     @GetMapping("/update")
     public ModelAndView updateProfile(HttpSession hs){
    	 ModelAndView model = new ModelAndView();
    	 model.setViewName("redirect:/updateprofile");
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
     
    //For profile photo upload
    public static String uploadDirectory =System.getenv("user.dir")+"/uploads";
 	
 	@RequestMapping("/")
 	public String UploadPage(Model model){
 		return "uploadview";
 	}
 	
 	@RequestMapping("/upload")
 	public String upload(Model model,@RequestParam("files") MultipartFile[] files){
 		
 		StringBuilder fileNames = new StringBuilder();
 		for(MultipartFile file : files ){
 			Path fileNameAndPath=Paths.get(uploadDirectory,file.getOriginalFilename());
             fileNames.append(file.getOriginalFilename());
             try {
 				Files.write(fileNameAndPath, file.getBytes());
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		}
 		
 		 model.addAttribute("msg","Successfuly uploaded files"+fileNames.toString());
          return "uploadstatusview";
 	}
 	@GetMapping("/profile")
 	public String showProfile(HttpSession hs)
 	{System.out.println(hs.getAttribute("user"));
 		System.out.println("in show profile..........get");
 		return "profile";
 	}
 	@PostMapping("/profile")
 	public String getProfile(HttpSession hs)
 	{
 		System.out.println("in get profile..........post");
 		return "redirect:updateProfile";
 		
 	}
 	
 	@GetMapping("/updateProfile")
 	public String updateProfile()
 	{
 		System.out.println("in update profile..........get");
 		return "updateProfile";
 	}
 	@PostMapping("/updateProfile")
 	public String getupdateProfile(HttpSession hs,@RequestParam("user_password")String password)
 	{
 		System.out.println("in get update profile............post");
 		User user=(User)hs.getAttribute("user");
 		System.out.println(password);
 								user.setUser_password(password);
 		userdao.saveAndFlush(user);
 		System.out.println(user);
 		System.out.println("post update complete................");
 		return "redirect:profile";	
 	}
 	@GetMapping("/admin")
 	public String adminDetails()
 	{
 		return "admin";
 	}
 	@GetMapping("/userlist")
 	public String getuserList(HttpSession hs, Model map)
 	{
 		List<User> userlist = userdao.findAll();
 								map.addAttribute("userlist", userlist);
 								
 		
 		return "userlist";
 	}
 	@PostMapping("/userlist")
 	public String postuserlist(HttpSession hs)
 	{
 		return "redirect:admin";
 	}
 	
}

