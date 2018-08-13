package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		FERService ferService = new FERServiceImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isValidUser = ferService.login(username, password);
	
		// response.sendRedirect(forwordPage);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		if (isValidUser) {

			HTMLUtil.displayHeaderAndLeftFrame(out, username);
			out.println("Welcome to the User");
			HTMLUtil.displayFooter(out);

		} else {
			out.println("password is invalid");
		}

	}

}
