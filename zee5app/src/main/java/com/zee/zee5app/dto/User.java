package com.zee.zee5app.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
//@ToString(exclude = "userId")
public class User implements Comparable<User>{
	
//	//static block
//	static {
//		System.out.println("Hello from Static");
//	}
//	
//	//initialization block
//	{
//		System.out.println("Hello from initialization");
//	}
//	
	//constructor
//	public User() {
//		// TODO Auto-generated constructor stub
//		System.out.println("Hello from edc");
//	}
	
	// order of exec -> static -> init -> constructor
	
//	Class Chaining
//	public User(String firstName, String lastName, String email) {
//		//super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//	}
//    
//	
//
//	public User(String userId, String firstName, String lastName, String email, LocalDate doj, LocalDate dob,
//			boolean active) {
//		//super();
//		this(firstName, lastName, email);
//		this.doj = doj;
//		this.dob = dob;
//		this.active = active;
//	}

	
	
	@Setter(value=AccessLevel.NONE)
	private String userId;
	
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate doj;
	private LocalDate dob;
	private boolean active;
	
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.userId.compareTo(o.userId);
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
