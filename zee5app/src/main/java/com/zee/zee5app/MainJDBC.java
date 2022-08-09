package com.zee.zee5app;

import java.time.LocalDate;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;

public class MainJDBC {
	public static void main(String[] args) {
		UserService userService = UserServiceImpl.getInstance();

        userService.insertUser(new User("009", "james", "bond", "james21@bond.com", LocalDate.of(1980, 10, 10), LocalDate.now(), true));
		
	}
}
