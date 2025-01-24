package com.hotel.exception;

public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException() {
		super();
	}
	
	public HotelNotFoundException(String exception) {
		super(exception);
	}
	
}
