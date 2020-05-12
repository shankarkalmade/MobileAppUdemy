package com.shankar.udemy.mobileapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.udemy.mobileapp.model.User;

@RestController

public class UserController {

	
	@GetMapping(path = "/users/{userId}", produces = {
			MediaType.APPLICATION_XML_VALUE, 
			MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<User> getUsersbyID(@PathVariable String userId ) {
		
		User resUser= new User();
		resUser.setEmail("shankar@gmail.com");
		resUser.setFirstName("Shankar");
		resUser.setLastName("K");
		resUser.setUserId("shankar");
		
		return new ResponseEntity<User>(resUser,HttpStatus.OK);
	} 
//	
//	@GetMapping("/users")
//	public String getAllUsers() {
//		return "List of All Users";
//	}
	
	@GetMapping("/users")
	public String getUsersPerPage(@RequestParam(value = "page") String page, @RequestParam(value = "limit", defaultValue = "30") String limit,
			@RequestParam(value = "sort", required = false) String sort) {
		
		//for required usage manually null check required
		boolean sortRequired = false;
		if(sort!=null) 
				sortRequired = true;
		return "List of sample "+limit+" Users for page:  "+ page +" sort :"+ sortRequired;
	}
	
	@PostMapping("/users")
	public String createUsers() {
		return "Create User operration";
	}
	
	@PutMapping("/users")
	public String updateUsers() {
		return "Update User operration";
	}
	
	@DeleteMapping("/users")
	public String deleteUsers() {
		return "Delete User operration";
	}
}
