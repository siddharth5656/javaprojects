<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<% 
			FERService service=new FERServiceImpl();
			PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
			
			personalinfo.getAddress().setAddressLine1(request.getParameter("addressLine1"));
			personalinfo.getAddress().setAddressLine2(request.getParameter("addressLine2"));
			personalinfo.getAddress().setCity(request.getParameter("city"));
			personalinfo.getAddress().setState(request.getParameter("state"));
			personalinfo.getAddress().setZip(request.getParameter("zip"));
			personalinfo.getAddress().setCountry(request.getParameter("country"));
			%>
			<table border='1' align='center'>
			<tr>
			<td>First Name</td>
			<td><%=personalinfo.getUser().getFirstName()  %></td>
			</tr>

			<tr>
			<td>Middle Name</td>
			<td><%= personalinfo.getUser().getMiddleName() %></td>
			</tr>

			<tr>
			<td>Last Name</td>
			<td><%=personalinfo.getUser().getLastName()  %></td>
			</tr>

			<tr>
			<td>userName Id</td>
			<td><%=personalinfo.getUser().getUserName() %></td>
			</tr>

			<tr>
			<td>Mobile No</td>
			<td><%=personalinfo.getUser().getMobileNo()  %></td>
			</tr>
			
			
			<tr>
			<td>AddressLine1</td>
			<td><%= personalinfo.getAddress().getAddressLine1() %></td>
			</tr>

			<tr>
			<td>AddressLine2</td>
			<td><%= personalinfo.getAddress().getAddressLine2() %></td>
			</tr>

			<tr>
			<td>City</td>
			<td><%= personalinfo.getAddress().getCity() %></td>
			</tr>

			<tr>
			<td>State</td>
			<td><%= personalinfo.getAddress().getState() %></td>
			</tr>

		
			<tr>
			<td>Country</td>
			<td><%=personalinfo.getAddress().getCountry() %></td>
			</tr>
			
			<tr>
			<td colspan='2' align='center'>
			<a
			href="javascript:submitForm('UpdatePersonalInfoPost.jsp')">Update</a></td>
			</tr>
			</table>
			