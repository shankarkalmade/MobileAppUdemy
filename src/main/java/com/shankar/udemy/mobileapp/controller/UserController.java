package com.shankar.udemy.mobileapp.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.udemy.mobileapp.exceptions.UserServiceException;
import com.shankar.udemy.mobileapp.model.User;
import com.shankar.udemy.mobileapp.model.request.UpdateUserRequest;
import com.shankar.udemy.mobileapp.model.request.UserRequest;
import com.shankar.udemy.mobileapp.service.user.impl.UserServiceImpl;

@RestController

public class UserController {

	@Autowired
	UserServiceImpl userService;
		
	
	@GetMapping(path = "/users/{userId}", produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<User> getUsersbyID(@PathVariable String userId ) {
		
		User resUser = userService.getUserbyId(userId);
		
		if(resUser != null) 
			return new ResponseEntity<User>(resUser,HttpStatus.OK);
		else 
			return 	new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	} 

	
	@GetMapping("/users")
	public String getUsersPerPage(@RequestParam(value = "page") String page, @RequestParam(value = "limit", defaultValue = "30") String limit,
			@RequestParam(value = "sort", required = false) String sort) {
		
		//for required usage manually null check required
		boolean sortRequired = false;
		if(sort!=null) 
				sortRequired = true;
		return "List of sample "+limit+" Users for page:  "+ page +" sort :"+ sortRequired;
	}
	
	@PostMapping(path = "/users", 
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE },
			consumes  = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUsers(@Valid @RequestBody UserRequest userRequest) {
		
		User resUser = userService.createUser(userRequest);		
		
		return new ResponseEntity<User>(resUser,HttpStatus.OK);
		

	}
	
	@PutMapping(path= "/users/{userId}",
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE },
			consumes  = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<User> updateUsers(@PathVariable String userId,@Valid @RequestBody UpdateUserRequest userRequest) {
		
		User resUser = userService.updateUserbyId(userId, userRequest);
		
		return new ResponseEntity<User>(resUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Void> deleteUsers(@PathVariable String userId) {
		
		boolean status = userService.deleteUser(userId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
