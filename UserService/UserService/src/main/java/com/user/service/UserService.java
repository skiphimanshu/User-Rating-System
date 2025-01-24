package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	// add user
	User addUser(User user);
	
	// Find Single user by User Id
	User getSingleUserById(String userId);
	
	// Find All User
	List<User> getAllUser();
	
	// Delete User By User Id
	String deleteUserById(String userId);

}
