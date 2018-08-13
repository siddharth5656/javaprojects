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

public class DisplayPersonalNameInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		
		FERService service = new FERServiceImpl();
		PersonalInfo personalinfo = service.getPersonalInfo(username);
		session.setAttribute("personalinfo", personalinfo);


		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, username);

		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Name Info</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td><input type='text' name='FirstName' value='" + personalinfo.getUser().getFirstName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Middle Name</td>");
		out.println("<td><input type='name' name='MiddleName' value='" + personalinfo.getUser().getMiddleName() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Last Name</td>");
		out.println("<td><input type='name' name='LastName' value='" + personalinfo.getUser().getLastName() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><a");
		//out.println("<a href=\"javascript:submitForm('DisplayPersonalContactInfo')\">Next</a></td>");
		out.println(
				"<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"DisplayPersonalContactInfo\");'></td>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayFooter(out);

	}

	

}
