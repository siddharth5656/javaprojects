
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	String mobileNo = request.getParameter("mobileNo");

	FERService ferservice = new FERServiceImpl();
	boolean isValidMobileNumber = ferservice.isMobileNumberAvailable(mobileNo);
	out.println(isValidMobileNumber ? 'Y' : 'N');
%>

