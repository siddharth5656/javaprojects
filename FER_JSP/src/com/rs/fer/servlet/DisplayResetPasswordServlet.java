
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
@WebServlet("/resetPasswordDisplay")
public class DisplayResetPasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, username);

		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Reset Password</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Current Password</td>");
		out.println("<td><input type='text' name='currentPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>New Password</td>");
		out.println("<td><input type='password' name='newPassword'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Confirm Password</td>");
		out.println("<td><input type='password' name='confirmPassword'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><a");
		out.println("<a href=\"javascript:submitForm('resetPassword')\">Reset Password</a></td>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayFooter(out);

	}

	FERService ferService = new FERServiceImpl();

}
