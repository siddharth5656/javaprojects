
<%@page import="com.rs.fer.util.HTMLUtil"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	boolean isValidUser = ferService.login(username, password);

	if (isValidUser) {
		session.setAttribute("username", username);
%>		
		<jsp:include page="Header.jsp" />
		<jsp:include page="LeftFrame.jsp" />
		Welcome to the User ${username}
		<jsp:include page="Footer.jsp" />
<%
	} else {
		out.println("password is invalid");
%>		
		<jsp:include page="Login.jsp" />
<%
	}
%>