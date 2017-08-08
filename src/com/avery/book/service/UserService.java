package com.avery.book.service;

import java.util.HashMap;
import java.util.Map;

import com.avery.book.dao.UserDao;
import com.avery.book.exception.ParameterException;
import com.avery.book.exception.ServiceException;
import com.avery.book.model.User;

public class UserService {
	
	public User login(String userName, String password) throws ParameterException, ServiceException {
		Map<String, String> errorFields = new HashMap<String, String>();
		
		if (userName == null && "".equals(userName)) {
			errorFields.put("errorUserName", "user name is required.");
		}
		if (password == null && "".equals(password)) {
			errorFields.put("errorPassword", "password is required.");
		}
		if (!errorFields.isEmpty()) {
			ParameterException parameterException = new ParameterException();
			parameterException.setErrorFields(errorFields);
			throw parameterException;
		}
		
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.getUserByName(userName);
		if (user == null) {
			throw new ServiceException(1000, "user name is not exist.");
		}
		if (!password.equals(user.getPassword())) {
			throw new ServiceException(1001, "password is not exist.");
		}
		
		return user;
		
	}
}
