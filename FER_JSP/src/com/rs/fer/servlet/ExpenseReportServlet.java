	      package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class ExpenseReportServlet extends HttpServlet {
	FERService ferservice = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferService = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		String type = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromdate");
		String toDate = request.getParameter("toDate");
		List<Expense> expense = ferService.getExpenseReport(type, fromDate, toDate);
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		if (expense != null) {
			for (Expense expenses : expense) {

				
				out.println("<table  border='1'>");
				out.println("<tr>");
				out.println("<td>Expense Type</td>");
				out.println("<td>Date</td>");
				out.println("<td>Price</td>");
				out.println("<td>No Of Items</td>");
				out.println("<td>By Whom</td>");
				out.println("<td>Action</td></tr>");
				out.println("<tr>");
				out.println("<td> " + expenses.getExpenseType() + "</td>");
				out.println("<td> " + expenses.getDate() + "</td>");
				out.println("<td> " + expenses.getPricee() + "</td>");
				out.println("<td>" + expenses.getNoOfItems() + "</td>");
				out.println("<td>" + expenses.getByWhom() + "</td>");
				out.println("<td><a href='EditExpenseDropbox.html'>Edit</a>");

				out.println("<a href='DeletExpenseDropbox.html'>Delete</a></td></tr>");
				out.println("</table>");

			}
			HTMLUtil.displayFooter(out);
			
		}

	}

}
