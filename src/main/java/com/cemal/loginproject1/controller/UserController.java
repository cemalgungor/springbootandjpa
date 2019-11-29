
package com.cemal.loginproject1.controller;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cemal.loginproject1.dao.model.User;
import com.cemal.loginproject1.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//my home page
	@GetMapping("home")
	public String home() {
			return "home";
	}
	@GetMapping("/users")
	public List<User> get() {
			return userService.get();
	}
	@GetMapping("reg")
	public String reg() {
			return "newreg";
	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> validateUsr(@RequestParam("username")String username, @RequestParam("password")String password){
		System.out.println(username);
		
		 
		 User user=userService.findByUser(username, password);
		 System.out.println(user.getPassword());
		 System.out.println(password);
       if(user.getUsername()!=null) {
    	   System.out.println("giriş başarılı");
    	   return new ResponseEntity<>("success",HttpStatus.OK);
 }
       else {
    	   
       return new ResponseEntity<>("not success",HttpStatus.OK);
       }	
    }
	//new user to database
    @RequestMapping(value = "/registiration", method = RequestMethod.POST)
    public ResponseEntity<Object> registirationUser(@RequestBody User user) {
    	
		System.out.println(user.getUsername());
		if(userService.findByUsername(user.getUsername())!=null) {
			
			 return new ResponseEntity<>("not success",HttpStatus.OK);
		}
		
	
		 userService.save(user);
		// ServiceResponse<User> response = new ServiceResponse<User>("success", user);
			
		
     return new ResponseEntity<>("success",HttpStatus.OK);
    		
    }
    

	
	@RequestMapping(value = "/logout", method= RequestMethod.GET)
    public String logout(HttpSession session) {
      session.invalidate();
      return "home";
    }

}
