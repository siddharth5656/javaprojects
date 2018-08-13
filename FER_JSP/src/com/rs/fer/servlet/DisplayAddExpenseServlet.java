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

public class DisplayAddExpenseServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, username);
        
		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Add Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("	<td>ExpenseType</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>No Of Items</td>");
		out.println("<td><input type='text' name='noOfItems'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>total A/c</td>");
		out.println("<td><input type='text' name='total'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>By Whom</td>");
		out.println("<td><input type='text' name='byWhom'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><a");
		out.println("<a href=\"javascript:submitForm('AddExpenseServlet')\">addExpense</a></td>");
		out.println("</tr>");

		out.println("</table>");

		HTMLUtil.displayFooter(out);
	}
}
