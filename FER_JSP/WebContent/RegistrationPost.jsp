
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<%
	FERService ferService = new FERServiceImpl();

	User user = new User();

	user.setFirstName(request.getParameter("firstName"));
	user.setMiddleName(request.getParameter("middleName"));
	user.setLastName(request.getParameter("lastName"));
	user.setUserName(request.getParameter("username"));
	user.setPassword(request.getParameter("password"));
	user.setMobileNo(request.getParameter("mobileNo"));
	
	boolean isValid = ferService.registration(user);
	
	if(isValid) {
		out.println("Registration is done successfully. Please try login");
	} else {
		out.println("Registration failed. Please try again.");
	}
	
	String forwordPage = isValid ? "Login.jsp" : "Registration.jsp";
%>

<jsp:include page="<%=forwordPage%>" />