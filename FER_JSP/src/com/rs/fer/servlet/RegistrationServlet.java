package com.rs.fer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstName(request.getParameter("firstName"));
		user.setMiddleName(request.getParameter("middleName"));
		user.setLastName(request.getParameter("lastName"));
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobileNo(request.getParameter("mobileNo"));
		boolean isValid = ferService.registration(user);
		String forwordPage = isValid ? "login.html" : "Registration.html";
		response.sendRedirect(forwordPage);

	}

}
