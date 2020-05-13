package com.shankar.udemy.mobileapp.service.user;

import com.shankar.udemy.mobileapp.model.User;
import com.shankar.udemy.mobileapp.model.request.UpdateUserRequest;
import com.shankar.udemy.mobileapp.model.request.UserRequest;

public interface UserService {

	
	User createUser(UserRequest reqUser);
	User getUserbyId (String userId);
	User updateUserbyId (String userId, UpdateUserRequest reqUser);
	boolean deleteUser(String userId);
}
