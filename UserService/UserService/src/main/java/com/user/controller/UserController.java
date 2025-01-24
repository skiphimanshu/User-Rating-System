package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.addUser(user));		
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		return ResponseEntity.ok(this.userService.getSingleUserById(userId));
	}
	
	@PostMapping("/all-user")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	

}
