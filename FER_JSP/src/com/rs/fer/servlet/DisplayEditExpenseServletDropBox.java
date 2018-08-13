package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayEditExpenseServletDropBox extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		List<Expense> expenses = ferservice.getdeleteDrop();

		if (expenses != null && !expenses.isEmpty()) {
			out.println("Expense ID: ");

			out.println("<select name='id'>");

			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println("  " + expense.getId() + "," + expense.getExpenseType() + "," + expense.getDate() + ","
						+ expense.getPricee() + "," + expense.getNoOfItems() + "," + expense.getTotalAccount() + ","
						+ expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println(
					"<input type='button' value='Edit Expense' onclick=\"javascript:submitForm('displayEditExpense')\">");
		} else {
			out.println("No Expense Available to Edit");
		}
		HTMLUtil.displayFooter(out);

	}
}
