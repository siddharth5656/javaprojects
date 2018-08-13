package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class DisplayDeleteExpenseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		FERService ferService = new FERServiceImpl();

		HttpSession session = request.getSession();
		

		List<Expense> expenses = ferService.getdeleteDrop();

		PrintWriter out = response.getWriter();

		HTMLUtil.displayHeaderAndLeftFrame(out, session.getAttribute("username").toString());

		if (expenses != null && !expenses.isEmpty()) {
			out.println("ExpenseId:");
			out.println("<select name='expenseId'>");
			for (Expense expense : expenses) {
				out.println("<option value=" + expense.getId() + ">");
				out.println(" " + expense.getId() + ", " + expense.getExpenseType() + ", " + expense.getTotalAccount()
						+ ", " + expense.getByWhom());
				out.println("</option>");
			}
			out.println("</select>");
			out.println(
					"<input type='button' value='delete' onclick=\"javascript:submitForm('deleteExpense')\" ></td>");
		} else {
			out.println("No Expenses are Available To DELETE");
		}
		HTMLUtil.displayFooter(out);
		
		
		
	}
}
