package com.shankar.udemy.mobileapp.utils;

import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class CommonUtlity {

	public String createUserId () {
		return UUID.randomUUID().toString();
	}
	
}
