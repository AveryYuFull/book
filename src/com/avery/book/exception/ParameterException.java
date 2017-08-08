package com.avery.book.exception;

import java.util.HashMap;
import java.util.Map;

public class ParameterException extends Exception {
	private static final long serialVersionUID = -4233834439772089608L;
	private Map<String, String> errorFields = new HashMap<String, String>();
	
	public Map<String, String> getErrorFields() {
		return errorFields;
	}
	public void setErrorFields(Map<String, String> errorFields) {
		this.errorFields = errorFields;
	}
}
