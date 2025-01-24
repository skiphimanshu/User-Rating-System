package com.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rating.entity.ErrorResponseApi;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<ErrorResponseApi> handleRatingNotFoundException(RatingNotFoundException exception) {
		ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().message(exception.getMessage()).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ErrorResponseApi>(errorResponseApi,HttpStatus.NOT_FOUND);
	}
}