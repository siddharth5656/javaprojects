
<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();
	Expense expense = new Expense();

	expense.setExpenseType(request.getParameter("expenseType"));
	expense.setDate(request.getParameter("date"));
	expense.setPricee(request.getParameter("price"));
	expense.setNoOfItems(request.getParameter("noOfItems"));
	expense.setTotalAccount(request.getParameter("total"));

	expense.setByWhom(request.getParameter("byWhom"));

	boolean isAdded = ferService.addExpense(expense);
%>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
out.println(isAdded ? "Expense added successfully" : "Add Expense failed");
%>
<jsp:include page="Footer.jsp" />