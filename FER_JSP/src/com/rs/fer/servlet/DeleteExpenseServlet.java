package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DeleteExpenseServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FERService ferService = new FERServiceImpl();
	
		int Id=  Integer.parseInt(request.getParameter("expenseId"));
		
		boolean isDeleteExpense= ferService.deleteExpense(Id);
		
		PrintWriter out = response.getWriter();
		
		HTMLUtil.displayHeaderAndLeftFrame(out,"");
		out.println( isDeleteExpense ?  "Delete successfully" : "Delete failed");
		HTMLUtil.displayFooter(out);
		
	}

}
 