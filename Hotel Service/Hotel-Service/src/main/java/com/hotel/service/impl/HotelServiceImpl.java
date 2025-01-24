package com.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return this.hotelRepository.save(hotel);
	}

	@Override
	public Hotel getSingleHotelById(String id) {
		return this.hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel is not Found"));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return this.hotelRepository.findAll();
	}

	@Override
	public String deleteHotelById(String id) {
		this.hotelRepository.deleteById(id);
		return "Hotel Deleted Successfully !";
	}

}
