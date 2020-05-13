package com.shankar.udemy.mobileapp.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shankar.udemy.mobileapp.model.ErrorMessage;


@ControllerAdvice
public class ExceptiomHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException (Exception ex, WebRequest req) {
		
		String errMessage = ex.getLocalizedMessage();
		if(errMessage==null)errMessage=ex.toString();
		
		
		ErrorMessage err = new ErrorMessage(new Date(), errMessage);
		
		return new ResponseEntity<Object> (err, 
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
}
