package com.shankar.udemy.mobileapp.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

	
	@NotNull(message = "FirstName cannot be missing or empty or null")
	private String firstName;
	
	@NotNull(message = "lastname cannot be missing or empty or null")
	private String lastName;
	
	@NotNull(message = "email cannot be missing or empty or null")
	@Email
	private String email;
	
	@NotNull(message = "passowrd cannot be missing or empty or null")
	@Size(min = 8, max = 16, message = "Password cannot be less than 8 and more than 16 chars")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
