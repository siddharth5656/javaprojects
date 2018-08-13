<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	String userName = request.getParameter("userName");
	
	FERService ferService = new FERServiceImpl();
	
	boolean isUsernameAvailabl = ferService.isUsernameAvailable(userName);
	
	out.println(isUsernameAvailabl ? 'Y' : 'N');
%>


