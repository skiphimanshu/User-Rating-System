package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.ok(this.hotelService.addHotel(hotel));
	}
	
	@PostMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
		return ResponseEntity.ok(this.hotelService.getSingleHotelById(hotelId));
	}
	
	@PostMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		return ResponseEntity.ok(this.hotelService.getAllHotels());
	}
}
