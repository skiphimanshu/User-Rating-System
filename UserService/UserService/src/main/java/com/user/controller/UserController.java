package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.addUser(user));		
	}
	int retry = 1;
	@PostMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		System.out.println(retry);
		retry++;
		return ResponseEntity.ok(this.userService.getSingleUserById(userId));
	}
	
	@PostMapping("/all-user")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	public ResponseEntity<User> ratingHotelFallBack(String userId, Exception exception) {
		System.out.println(exception.getMessage());
		User user = User.builder()
		.name("Dummy-Name")
		.email("dummy@email.com")
		.about("Dummy about")
		.userId("DummyuserID")
		.build();
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
