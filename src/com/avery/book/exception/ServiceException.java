package com.avery.book.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -2970242808583708987L;
	private int code;
    private String message = "";
    
	public ServiceException() {
	}

	public ServiceException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
