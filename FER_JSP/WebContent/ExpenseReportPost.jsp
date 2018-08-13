<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<% 
   FERService ferService = new FERServiceImpl();
		
		String type = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromdate");
		String toDate = request.getParameter("toDate");
		
		List<Expense> expense = ferService.getExpenseReport(type, fromDate, toDate);
		
		if (expense != null) {
			for (Expense expenses : expense) {
%>
				
				<table  border='1'>
				<tr>
				<td>Expense Type</td>
				<td>Date</td>
				<td>Price</td>
				<td>No Of Items</td>
				<td>By Whom</td>
				<td>Action</td></tr>
				<tr>
				<td><%=expenses.getExpenseType()  %> </td>
				<td> <%= expenses.getDate() %></td>
				<td> <%= expenses.getPricee()  %></td>
				<td><%= expenses.getNoOfItems()  %></td>
				<td><%=expenses.getByWhom() %></td>
				<td><a href='EditExpenseDrop.jsp'>Edit</a>

				<a href='DeleteExpense.jsp'>Delete</a></td></tr>
				</table>

			
			

<%
			}
		}
		%>
		<jsp:include page="Footer.jsp"/>



	