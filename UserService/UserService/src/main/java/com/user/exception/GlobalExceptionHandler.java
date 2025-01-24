package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResouceNotFoundException(ResourceNotFoundException exception) {
		
		String message = exception.getMessage();
		ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
}
