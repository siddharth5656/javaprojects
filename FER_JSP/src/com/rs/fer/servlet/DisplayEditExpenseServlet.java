package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayEditExpenseServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		request.getSession().setAttribute("id", id);
		Expense expense = ferService.getExpense(id);
		
		
		HTMLUtil.displayHeaderAndLeftFrame(out, " ");
		out.println("<table align='center' border='1'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Edit Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType' value="+expense.getExpenseType()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date' value="+expense.getDate()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price' value="+expense.getPricee()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>NoOfItems</td>");
		out.println("<td><input type='text' name='noOfItems' value="+expense.getNoOfItems()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>totalA/c</td>");
		out.println("<td><input type='text' name='totalAccount' value="+expense.getTotalAccount()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ByWhom</td>");
		out.println("<td><input type='text' name='byWhom' value="+expense.getByWhom()+"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><a");
		out.println("<a href=\"javascript:submitForm('editExpenses')\">EditExpense</a></td>");
		out.println("</tr>");
		

	}

	
}
