package com.girish.crudoperation.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
	
	@ExceptionHandler(value=NotProductfoundException.class)
	public ResponseEntity<ExceptionMessage> notfoundExceptionMessage(NotProductfoundException n)
	{
		ExceptionMessage e=new ExceptionMessage();
		e.setErrorcode("NFE522");
		e.setMsg("Not found id in data base");
		e.setLocaldatetime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionMessage>(e,HttpStatus.BAD_REQUEST);
		
		
	}
	

}
