<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>


<%
	FERService ferService = new FERServiceImpl();
	String username = request.getSession().getAttribute("username").toString();
	String currentPassword = request.getParameter("currentPassword");

	String newPassword = request.getParameter("newPassword");
	String confromPassword = request.getParameter("confirmPassword");

	boolean isResetPassword = ferService.resetPassword(username, currentPassword, newPassword);

	
%>


<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
out.println(isResetPassword ? "password changed successfully" : "password changed failed");

%>
<jsp:include page="Footer.jsp" />