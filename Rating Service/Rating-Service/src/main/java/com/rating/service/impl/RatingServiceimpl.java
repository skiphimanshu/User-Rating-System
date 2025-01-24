package com.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.exception.RatingNotFoundException;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;

@Service
public class RatingServiceimpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating addRating(Rating rating) {
		rating.setId(UUID.randomUUID().toString());
		return this.ratingRepository.save(rating);
	}

	@Override
	public Rating getRatingById(String id) {
		return this.ratingRepository.findById(id).orElseThrow(() -> new RatingNotFoundException("Rating is not found !"));
	}

	@Override
	public List<Rating> getAllRatings() {
		return this.ratingRepository.findAll();
	}

	@Override
	public String deleteRatingById(String id) {
		this.ratingRepository.deleteById(id);
		return "Deleted Successfully !";
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		return this.ratingRepository.findByHotelId(hotelId);
	}

}
