
<%@page import="com.rs.fer.bean.PersonalInfo"%>
<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<% 

String username = session.getAttribute("username").toString();
PersonalInfo personalinfo = (PersonalInfo) session.getAttribute("personalinfo");
personalinfo.getUser().setMobileNo(request.getParameter("MobileNo"));

%>
<table border='1' align='center'>
<tr>
<td colspan='2' align='center'>AddressInfo</td>
</tr>
<tr>
<td>AddressLine1</td>
<td><input type='text' name='addressLine1' value=<%=personalinfo.getAddress().getAddressLine1()
%>></td>
</tr>
<tr>
<td>AddressLine2</td>
<td><input type='text' name='addressLine2' value=<%=personalinfo.getAddress().getAddressLine2()
%>></td>
</tr>

<tr>
<td>City</td>
<td><input type='text' name='city' value=<%=personalinfo.getAddress().getCity() %>></td>
</tr>

<tr>
<td>State</td>
<td><input type='text' name='state'  value=<%= personalinfo.getAddress().getState()%>></td>

</tr>
<tr>
<td>Zip</td>
<td><input type='text' name='zip' value=<%= personalinfo.getAddress().getZip() %>></td>

</tr>
<tr>
<td>Country</td>
<td><input type='text' name='country' value=<%=personalinfo.getAddress().getCountry()%>></td>

</tr>
<tr>

<tr>

		<td colspan='2' align='center'><a href="javascript:submitForm('PersonalReview.jsp')">Next</a></td>
</tr>
</table>


