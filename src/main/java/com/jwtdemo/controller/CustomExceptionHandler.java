package com.jwtdemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.jwtdemo.config.CustomException;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(CustomException.class)//service side add user part it used
	public ResponseEntity<Object> globalExceptionHandler(CustomException ex) {
		    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
    

