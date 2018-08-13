
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<% 
 FERService ferService = new FERServiceImpl();

 int Id=Integer.parseInt(request.getParameter("expenseId")); 
 
 boolean isDeleteExpense= ferService.deleteExpense(Id);
 
%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<% 

out.println( isDeleteExpense ? "Delete successfully" : "Delete failed");
%>
<jsp:include page="Footer.jsp"/>