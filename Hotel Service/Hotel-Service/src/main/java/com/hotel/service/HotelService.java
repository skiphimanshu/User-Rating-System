package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;

public interface HotelService {
	
	//add Hotel
	Hotel addHotel(Hotel hotel);
	
	// Get Single Hotel by Id
	Hotel getSingleHotelById(String id);
	
	// Get All Hotels
	List<Hotel> getAllHotels();
	
	// Delete Hotel By Id
	String deleteHotelById(String id);

}
