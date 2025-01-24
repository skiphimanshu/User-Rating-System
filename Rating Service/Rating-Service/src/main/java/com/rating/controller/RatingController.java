package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.ok(this.ratingService.addRating(rating));
	}
	
	@PostMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
		return ResponseEntity.ok(this.ratingService.getRatingById(ratingId));
	}
	
	@PostMapping("/all")
	public ResponseEntity<List<Rating>> getAllRating() {
		return ResponseEntity.ok(this.ratingService.getAllRatings());
	}
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(this.ratingService.getAllRatingsByUserId(userId));
	}
	
	@PostMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(this.ratingService.getAllRatingsByHotelId(hotelId));
	}
}
