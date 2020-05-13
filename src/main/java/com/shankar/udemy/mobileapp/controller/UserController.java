package com.shankar.udemy.mobileapp.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;
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

import com.shankar.udemy.mobileapp.model.User;
import com.shankar.udemy.mobileapp.model.request.UpdateUserRequest;
import com.shankar.udemy.mobileapp.model.request.UserRequest;

@RestController

public class UserController {

	Map<String, User> userMap;
	
	
	@GetMapping(path = "/users/{userId}", produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<User> getUsersbyID(@PathVariable String userId ) {
		
		if(userMap.containsKey(userId)) 
			return new ResponseEntity<User>(userMap.get(userId),HttpStatus.OK);
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
		
		User resUser= new User();
		resUser.setEmail(userRequest.getEmail());
		resUser.setFirstName(userRequest.getFirstName());
		resUser.setLastName(userRequest.getLastName());
		resUser.setUserId(UUID.randomUUID().toString());
	
		if(userMap==null)
				userMap = new HashMap<String, User>();
		
		userMap.put(resUser.getUserId(), resUser);
		System.out.println("User Map contains : "+ userMap.size());
		
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
		
		User userDetails = userMap.get(userId);
		System.out.println(userDetails.getFirstName());
		
		if (userDetails!=null) {
			userDetails.setFirstName(userRequest.getFirstName());
			userDetails.setLastName(userRequest.getLastName());
			
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		userMap.put(userId, userDetails);
		
		return new ResponseEntity<User>(userMap.get(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Void> deleteUsers(@PathVariable String userId) {
		
		userMap.remove(userId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
