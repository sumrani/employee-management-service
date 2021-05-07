package com.publicissapient.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException 
			resourceNotFound, WebRequest request){
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.NOT_FOUND.value(),
		        resourceNotFound.getMessage(),
		        request.getDescription(false));
		 return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	

}
