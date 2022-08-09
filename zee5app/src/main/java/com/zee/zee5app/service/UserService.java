package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;

public interface UserService {

	public User insertUser(User user);
	public User	updateUser(String userId, User user);
	public String deleteUser(String userId);
	public Optional<List<User>> getAllUsers();
	public Optional<User> getUserById(String userId);
}
