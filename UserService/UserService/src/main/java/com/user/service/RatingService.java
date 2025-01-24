package com.user.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.entity.Rating;

@FeignClient(name = "RATING-SERVICE",path = "/rating")
public interface RatingService {
	
	@PostMapping("/user/{userId}")
	List<Rating> getRatingsOfUserByUserId(@PathVariable String userId);

}
