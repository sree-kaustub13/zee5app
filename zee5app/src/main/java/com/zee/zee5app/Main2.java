package com.zee.zee5app;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;

public class Main2 {
	public static void main(String[] args) {
//		UserService userService = UserServiceImpl.getInstance();
//		  userService.insertUser(
//	                new User("ab001","abhi","chivate","abhi@gmail.com",LocalDate.now(),LocalDate.of(1988, 12, 9), false));
//		  userService.insertUser(
//	                new User("ab002","abhi","chivate","abhi@gmail.com",LocalDate.now(),LocalDate.of(1988, 12, 9), false));
//		  Optional<User> result = userService.getUserById("ab001");
//		  if(!result.isPresent()) {
//	            System.out.println("No Record Found");
//	        }
//	        else {
//	            User user = result.get();
//	            System.out.println(user);
//	        }
//		  
//		  
//		  Optional<User[]> result2 = userService.getAllUsers();
//
//	        if(!result.isPresent() ) {
//	            System.out.println("no record found");
//	        }
//	        else {
//	            User[] users = result2.get();
//	            for (User user1 : users) {
//	                System.out.println(user1);
//	            }
//	        }
//	        
//	        int temp = UserService.
		
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "a");
		hashMap.put(4, "b");
		hashMap.put(3, "x");
		hashMap.put(2, "e");
		hashMap.put(6, "a");
		for(Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		System.out.println(hashMap.get(4));
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			
		}

	}
}

