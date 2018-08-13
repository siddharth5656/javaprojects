<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@page import= " java.util.List" %>

<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<% 
    FERService ferservice = new FERServiceImpl();
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
		}
			%>
<select>
			
				<input type='button' value='EditExpense' onclick="javascript:submitForm('EditExpense.jsp')">
</select>
<jsp:include page="Footer.jsp" />