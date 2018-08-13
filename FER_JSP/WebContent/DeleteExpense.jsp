<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<% 
FERService ferService = new FERServiceImpl();


List<Expense> expenses = ferService.getdeleteDrop();

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
			"<input type='button' value='delete' onclick=\"javascript:submitForm('DeleteExpensePost.jsp')\" ></td>");
} else {
	out.println("No Expenses are Available To DELETE");
}
%>
<jsp:include page="Footer.jsp"/>
