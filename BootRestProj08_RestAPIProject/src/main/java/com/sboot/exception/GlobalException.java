package com.sboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(TravellerNotFoundException.class)
	public ResponseEntity<String> travellerNoFound(TravellerNotFoundException tnfe)
	{
		System.out.println("GlobalException.travellerNoFound()");
		return new ResponseEntity<String>(tnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>  glboalTravellerNoFound(Exception tnfe)
	{
		System.out.println("GlobalException.travellerNoFound()");
		System.out.println(tnfe.getStackTrace());
		return new ResponseEntity<String>(tnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}

}
