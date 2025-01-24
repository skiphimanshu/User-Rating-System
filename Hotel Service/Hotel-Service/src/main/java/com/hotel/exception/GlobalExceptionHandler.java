package com.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.entity.ErrorApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ErrorApiResponse> handleHotelNotFoundException(HotelNotFoundException exception) {

		ErrorApiResponse errorApiResponse = ErrorApiResponse.builder().message(exception.getMessage()).success(true)
				.httpStatus(HttpStatus.NOT_FOUND).build();

		return new ResponseEntity<ErrorApiResponse>(errorApiResponse, HttpStatus.NOT_FOUND);
	}

}
