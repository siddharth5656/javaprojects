package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class EditExpenseServlet extends HttpServlet {
	FERService ferService = new FERServiceImpl();
	Expense expense = new Expense();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		
		HttpSession session = request.getSession();
		Expense expense = new Expense();
		PrintWriter out = response.getWriter();
		{

			int id= Integer.parseInt(session.getAttribute("id").toString());
			
			expense.setId(id);
			expense.setExpenseType(request.getParameter("expenseType"));
			expense.setDate(request.getParameter("date"));
			expense.setPricee(request.getParameter("price"));
			expense.setNoOfItems(request.getParameter("noOfItems"));
			expense.setTotalAccount(request.getParameter("totalAccount"));
			expense.setByWhom(request.getParameter("byWhom"));

			boolean isAdded = ferService.editExpense(expense);

			HTMLUtil.displayHeaderAndLeftFrame(out, "");
			out.println(isAdded ? "Expense Edit successfully" : "Edit Expense failed");
			HTMLUtil.displayFooter(out);
		}
	}

}
