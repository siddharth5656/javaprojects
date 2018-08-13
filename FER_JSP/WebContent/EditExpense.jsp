<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	FERService ferService = new FERServiceImpl();

	int id = Integer.parseInt(request.getParameter("id"));
	Expense expense = ferService.getExpense(id);
	session.setAttribute("id", id);
%>
<table align='center' border='1'>
	<tr>
		<td colspan='2' align='center'>Edit Expense</td>
	</tr>
	<tr>
		<td>Expense Type</td>
		<td><input type='text' name='expenseType' value="<%=expense.getExpenseType() %>"></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type='text' name='date' value="<%=expense.getDate() %>"></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type='text' name='price' value="<%=expense.getPricee() %>"></td>
	</tr>
	<tr>
		<td>NoOfItems</td>
		<td><input type='text' name='noOfItems' value="<%=expense.getNoOfItems() %>"></td>
	</tr>
	<tr>
		<td>totalA/c</td>
		<td><input type='text' name='totalAccount' value="<%=expense.getTotalAccount() %>"></td>
	</tr>
	<tr>
		<td>ByWhom</td>
		<td><input type='text' name='byWhom' value="<%=expense.getByWhom() %>"></td>
	</tr>
	<tr>
		<td colspan='2' align='center'><a
			href="javascript:submitForm('EditExpensePost.jsp')">EditExpense</a></td>
	</tr>
</table>
<jsp:include page="Footer.jsp" />
