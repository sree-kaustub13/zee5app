package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.repo.MovieRepository;
import com.zee.zee5app.repo.UserRepo;
import com.zee.zee5app.repo.UserRepoImpl;

public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo = UserRepoImpl.getInstance();
    private static UserServiceImpl userService;
    public static UserServiceImpl getInstance() {
        if(userService == null) userService = new UserServiceImpl();
        return userService;
    }

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.insertUser(user);
	}

	@Override
	public User updateUser(String userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 public Optional<List<User>> getAllUsers() {
	        return userRepo.getAllUsers();
	    }

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepo.getUserById(userId);
	}

}
