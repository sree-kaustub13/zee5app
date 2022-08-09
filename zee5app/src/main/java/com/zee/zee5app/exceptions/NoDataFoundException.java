package com.zee.zee5app.exceptions;

public class NoDataFoundException extends Exception {
	public NoDataFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
}
