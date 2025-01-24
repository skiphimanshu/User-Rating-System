package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	
	// add Rating
	Rating addRating(Rating rating);
	
	// get Rating by Id
	Rating getRatingById(String id);
	
	// Get All Rating
	List<Rating> getAllRatings();
	
	//Get All Ratings by User Id
	List<Rating> getAllRatingsByUserId(String userId);
	
	//Get All Ratings by User Id
	List<Rating> getAllRatingsByHotelId(String hotelId);
	
	// Delete Rating By Id
	String deleteRatingById(String id);

}
