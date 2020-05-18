package com.shankar.udemy.mobileapp.service.user.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.udemy.mobileapp.exceptions.UserServiceException;
import com.shankar.udemy.mobileapp.model.User;
import com.shankar.udemy.mobileapp.model.request.UpdateUserRequest;
import com.shankar.udemy.mobileapp.model.request.UserRequest;
import com.shankar.udemy.mobileapp.service.user.UserService;
import com.shankar.udemy.mobileapp.utils.CommonUtlity;

@Service
public class UserServiceImpl implements UserService{

	CommonUtlity utility;
	
	@Autowired
	public UserServiceImpl(CommonUtlity util) {
		// TODO Auto-generated constructor stub
		this.utility = util;
	}
	
	
	Map<String, User> userMap = new HashMap<String, User>();
	
	
	
	@Override
	public User createUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		
		User resUser= new User();
		resUser.setEmail(userRequest.getEmail());
		resUser.setFirstName(userRequest.getFirstName());
		resUser.setLastName(userRequest.getLastName());
		resUser.setUserId(utility.createUserId());
	
		userMap.put(resUser.getUserId(), resUser);
		System.out.println("User Map contains : "+ userMap.size());
		
		return resUser;
	}

	@Override
	public User getUserbyId(String userId) {
		
		return userMap.get(userId);
	}

	@Override
	public User updateUserbyId(String userId, UpdateUserRequest reqUser) {
		User userDetails = userMap.get(userId);
		
		if (userDetails!=null) {
			userDetails.setFirstName(reqUser.getFirstName());
			userDetails.setLastName(reqUser.getLastName());
			
		} else {
			throw new UserServiceException("User Service Exception : trying to update unvaialable user");
			//return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		userMap.put(userId, userDetails);
		return userDetails;
	}

	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		userMap.remove(userId);
		return true;
	} 
	

}
