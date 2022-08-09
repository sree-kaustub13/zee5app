package com.zee.zee5app.exceptions;

public class InvalidEmailExcpetion extends Exception {
	
	public InvalidEmailExcpetion(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.getMessage();
	}

}
