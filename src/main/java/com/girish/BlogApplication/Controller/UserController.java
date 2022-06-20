package com.girish.BlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.girish.BlogApplication.Entity.User;
import com.girish.BlogApplication.Service.UserServiceI;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceI userservice;
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> save(@RequestBody User user)
	{
		User saveUser = userservice.saveUser(user);
		
		return new ResponseEntity<User>(saveUser,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateUser/{userid}")
	public ResponseEntity<User> updateUser(User user,@PathVariable Integer userid)
	{
		User updateUser = userservice.updateUser(user, userid);
		return new ResponseEntity<User>(updateUser, HttpStatus.OK);
		
	}
	
	@GetMapping("/getid/{userid}")
	public ResponseEntity<User> getbyid(@PathVariable Integer userid)
	{
		User getuser = userservice.getuser(userid);
		return new ResponseEntity<User>(getuser, HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getall()
	{
		List<User> getall = userservice.getall();
		
		return new ResponseEntity<List<User>>(getall, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteid/{userid}")
	public ResponseEntity<String> delete(@PathVariable Integer userid)
	{
		userservice.deleteid(userid);
		return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
