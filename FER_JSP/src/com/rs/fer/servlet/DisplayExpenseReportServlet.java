package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayExpenseReportServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(out, " ");
		out.println("<table border='1'>");
		out.println("<tr ><td colspan='2' align='center'>Expense Report</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr><tr>");
		out.println("<td>From Date</td>");
		out.println("<td><input type='text' name='fromdate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>To Date</td>");
		out.println("<td><input type='text' name='toDate'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=\"javascript:submitForm('expenseReport')\">Get Report</a>");
		out.println("</td>");
		out.println("</tr>");

		//HTMLUtil.displayFooter(out);
		
	}
	

}
