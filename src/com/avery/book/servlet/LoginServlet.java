package com.avery.book.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avery.book.Constants;
import com.avery.book.exception.ParameterException;
import com.avery.book.exception.ServiceException;
import com.avery.book.model.User;
import com.avery.book.service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        try {
            User user = null;
            UserService userService = new UserService();
            user = userService.login(userName, password);
            HttpSession session = request.getSession();
            user.setPassword(null);
            session.setAttribute(Constants.USER, user);
            response.sendRedirect(request.getContextPath() + "/mybook");
        } catch (ParameterException parameterException) {
            Map<String, String> errorFields = parameterException.getErrorFields();
            request.setAttribute(Constants.ERROR_FIELDS, errorFields);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        } catch (ServiceException serviceException) {
            request.setAttribute(Constants.TIP_MESSAGE, serviceException.getMessage() + "[" + serviceException.getCode() + "]");
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
	}
}
