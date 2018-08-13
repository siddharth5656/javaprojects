<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<%
       FERService service = new FERServiceImpl();
		String username = session.getAttribute("username").toString();
		PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");

		personalinfo.getUser().setFirstName(request.getParameter("FirstName"));
		personalinfo.getUser().setMiddleName(request.getParameter("MiddleName"));
		personalinfo.getUser().setLastName(request.getParameter("LastName"));

		 %>
		<table border='1' align='center'>
		<tr>
		<td colspan='2' align='center'>ContactInfo</td>
		</tr>
		<tr>
		<td>Mobile</td>
		<td><input type='text' name='MobileNo' value=<%= personalinfo.getUser().getMobileNo() %>></td>

		</tr>

		<tr>
		
				<td colspan='2' align='center'><a href="javascript:submitForm('PersonalAddressinfo.jsp')">Next</a></td>
		</tr>
		</table>
		