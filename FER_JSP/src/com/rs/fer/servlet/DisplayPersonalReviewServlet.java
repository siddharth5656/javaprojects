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

public class DisplayPersonalReviewServlet extends HttpServlet {

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			FERService service=new FERServiceImpl();
			PrintWriter out=response.getWriter();
			
			PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
			
			personalinfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
			personalinfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
			personalinfo.getAddress().setCity(request.getParameter("city"));
			personalinfo.getAddress().setState(request.getParameter("state"));
			personalinfo.getAddress().setZip(request.getParameter("zip"));
			personalinfo.getAddress().setCountry(request.getParameter("country"));
		
			HTMLUtil.displayHeaderAndLeftFrame(out,session.getAttribute("username").toString());
			
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<td>First Name</td>");
			out.println("<td>" +personalinfo.getUser().getFirstName() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Middle Name</td>");
			out.println("<td>"+ personalinfo.getUser().getMiddleName() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Last Name</td>");
			out.println("<td>"+ personalinfo.getUser().getLastName() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>userName Id</td>");
			out.println("<td>"+ personalinfo.getUser().getUserName() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Mobile No</td>");
			out.println("<td>"+ personalinfo.getUser().getMobileNo() + "</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td>AddressLine1</td>");
			out.println("<td>"+ personalinfo.getAddress().getAddressLine1() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>AddressLine2</td>");
			out.println("<td>"+ personalinfo.getAddress().getAddressLine2() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>City</td>");
			out.println("<td>"+ personalinfo.getAddress().getCity() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>State</td>");
			out.println("<td>"+ personalinfo.getAddress().getState() + "</td>");
			out.println("</tr>");

		
			out.println("<tr>");
			out.println("<td>Country</td>");
			out.println("<td>"+ personalinfo.getAddress().getCountry() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td colspan='2' align='center'>");
			out.println("<input type='button' value='update' onclick='javascript:submitForm(\"updatePersonalInfo\");'></td>");
			out.println("</tr>");
			out.println("</table>");
			
			HTMLUtil.displayFooter(out);
		}




	}
