package com.shankar.udemy.mobileapp.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserRequest {

	@NotNull(message = "FirstName cannot be missing or empty or null")
	private String firstName;
	
	@NotNull(message = "lastname cannot be missing or empty or null")
	private String lastName;

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

	
	
}
