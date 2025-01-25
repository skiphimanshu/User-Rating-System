package com.user.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.HotelService;
import com.user.service.RatingService;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User addUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return this.userRepository.save(user);
	}

	@Override
	public User getSingleUserById(String userId) {
		// Get User from database with the help of User Repository
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User With Particular Id Not Found !!"));
		//fetching rating service of the user with help of RATING - SERVICE
		List<Rating> ratingsOfUser = this.ratingService.getRatingsOfUserByUserId(userId);
		List<Rating> ratingList = ratingsOfUser.stream().map(rating -> {
			rating.setHotel(this.hotelService.getHotelById(rating.getHotelId()));
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		 List<User> allUser = this.userRepository.findAll();
		 allUser.forEach(user -> {
			 List<Rating> ratingsOfUserByUser = this.ratingService.getRatingsOfUserByUserId(user.getUserId());
			 List<Rating> ratingList = ratingsOfUserByUser.stream().map(rating -> {
				 rating.setHotel(this.hotelService.getHotelById(rating.getHotelId()));
				 return rating;
			 }).collect(Collectors.toList());
			 user.setRatings(ratingList);
		 });
		 return allUser;
	}
	

	@Override
	public String deleteUserById(String userId) {
		 this.userRepository.deleteById(userId);
		 return "User with ID " + userId + " has been deleted successfully.";
	}

}
