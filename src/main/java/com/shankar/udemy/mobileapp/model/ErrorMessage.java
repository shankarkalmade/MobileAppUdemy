package com.shankar.udemy.mobileapp.model;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String message;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorMessage(Date timestamp, String message) {
		// TODO Auto-generated constructor stub
		this.message= message;
		this.timestamp = timestamp;
		
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
