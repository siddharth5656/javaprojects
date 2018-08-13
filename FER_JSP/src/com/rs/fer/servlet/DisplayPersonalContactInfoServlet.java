package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayPersonalContactInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		PrintWriter out = response.getWriter();
	//	HTMLUtil.displayHeaderAndLeftFrame(out, username);


		PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

		personalinfo.getUser().setFirstName(request.getParameter("FirstName"));
		personalinfo.getUser().setMiddleName(request.getParameter("MiddleName"));
		personalinfo.getUser().setLastName(request.getParameter("LastName"));

		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>ContactInfo</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='MobileNo' value='" + personalinfo.getUser().getMobileNo() + "'></td>");

		out.println("</tr>");

		out.println("<tr>");
		out.println(
				"<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalAddressInfo\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		HTMLUtil.displayFooter(out);

	}

}
