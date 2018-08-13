package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class AddExpenseServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		
	
		
		
		expense.setExpenseType(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPricee(request.getParameter("price"));
		expense.setNoOfItems(request.getParameter("noOfItems"));
		expense.setTotalAccount(request.getParameter("total"));
	
		expense.setByWhom(request.getParameter("byWhom"));
	//	expense.setUserid(Integer.parseInt(request.getParameter("userId")));

		boolean isAdded = ferService.addExpense(expense);
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(out, "");
		out.println(isAdded ? "Expense added successfully" : "Add Expense failed");
		HTMLUtil.displayFooter(out);
	}
}
