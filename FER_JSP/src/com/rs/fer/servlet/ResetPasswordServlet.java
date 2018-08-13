package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		String username = request.getSession().getAttribute("username").toString();
		String currentPassword = request.getParameter("currentPassword");

		String newPassword = request.getParameter("newPassword");
		String confromPassword = request.getParameter("confirmPassword");

		boolean isResetPassword = ferService.resetPassword(username, currentPassword, newPassword);
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		out.println(isResetPassword ? "password changed successfully" : "password changed failed");
		HTMLUtil.displayFooter(out);

	}
}
