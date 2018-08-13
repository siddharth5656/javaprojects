<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<%
	FERService service = new FERServiceImpl();
	String username = session.getAttribute("username").toString();

	PersonalInfo personalinfo = service.getPersonalInfo(username);
	session.setAttribute("personalinfo", personalinfo);
%>
<table align='center' border='1'>
	<tr>
		<td colspan='2' align='center'>Name Info</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type='text' name='FirstName'
			value=<%=personalinfo.getUser().getFirstName()%>></td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><input type='name' name='MiddleName'
			value=<%=personalinfo.getUser().getMiddleName()%>></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type='name' name='LastName'
			value=<%=personalinfo.getUser().getLastName()%>></td>
	</tr>

	<tr>
		<td colspan='2' align='center'><a
			href="javascript:submitForm('PersonalContactInfo.jsp')">Next</a></td>
		
		<!-- <td colspan='2' align='center'><input type='button' value='Next'
			onclick='javascript:submitForm()'></td> -->
	</tr>

</table>
<jsp:include page="Footer.jsp" />