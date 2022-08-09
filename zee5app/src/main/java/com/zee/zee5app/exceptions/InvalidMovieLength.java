package com.zee.zee5app.exceptions;

public class InvalidMovieLength extends Exception {
	public InvalidMovieLength(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
}
