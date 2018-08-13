/*package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void displayHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>FER_Dashboard</title>");
		out.println("<script>");
		out.println("function submitFrom(action)");
		out.println(" var from=document.DashboardFrom;");
		out.println("from.action = action");
		out.println("from.submit()");

		out.println("</script>");

		out.println("</head>");
		out.println("<body>");
		out.println("<form name='DashboardFrom'>");

		out.println("<table align='center' border='1' height='600px' width='800px'>");
		out.println("<tr height='100px'>");
		out.println("	<td colspan='2' align='center'>Family Expense Report User:" + username + "</td>");

		out.println("</tr>");

		out.println("<td height='200px'><a href='AddExpense.html'>Add Expense</a><br>");
		out.println("	<br> <a href='EditExpenseDropbox.html'>Edit Expense</a><br>");
		out.println("<br> <a href='DeleteExpenseDropbox.html'>Delete Expense</a><br>");
		out.println("<br> <a href='ExpenseReport.html'>Expense Report</a><br> <br>");
		out.println("	<a href='ResetPassword.html'>Reset Password</a><br> <br>");
		out.println("		 <a href='Updatepersonal.html'>Update Personal</a><br> <br></td>");
		out.println("		<td align='center'>Welcome To The User:" + username + "</td>");

		out.println("	</tr>");

	}

	public static void displayFooter(PrintWriter out) {
		out.println("</td>");

		out.println("</tr>");

		out.println("<tr height='100px'>");
		out.println("	<td colspan='2' align='center'>Footer</td>");
		out.println("	</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}*/

package com.rs.fer.util;

import java.io.PrintWriter;

public class HTMLUtil {

	public static void displayHeaderAndLeftFrame(PrintWriter out, String username) {
		out.println("<html>");
		out.println("<head>");

		out.println("<title>FER_Dashboard</title>");
		out.println("<script>");
		out.println("function submitForm(action) {");
		out.println("var form=document.DashboardForm;");
		out.println("form.action=action;");
		out.println("form.submit();");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form name='DashboardForm'>");
		out.println("<table align ='center' border='1' height='600px'width='800px'>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'> Family Expense report User:" + username + "</td>");
		//out.println(" User:" + username + "</td>");

		out.println("</tr>");

		out.println("<tr>");
		out.println("<td height='100px''width='100px'>");
		out.println("<a href=\"javascript:submitForm('DisplayAddExpenseServlet')\">Add Expense</a><br><br>");
		out.println("<a href=\"javascript:submitForm('displayEditExpenseServletDropBox')\">EditExpense</a><br><br>");
		out.println("<a href=\"javascript:submitForm('DisplayDeleteExpenseServlet')\">DeleteExpense</a><br><br>");
		out.println("<a href=\"javascript:submitForm('displayExpenseReport')\">Expense Report</a><br><br>");
		out.println("<a href=\"javascript:submitForm('resetPasswordDisplay')\">ResetPassword</a><br><br>");
		out.println("<a href=\"javascript:submitForm('DisplayUpdatePersonalinfo')\">Personalinfo</a><br><br><br>");

		out.println("</td>");
		out.println("<td align = 'center'>");

	}

	public static void displayFooter(PrintWriter out) {
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr height='100px'>");
		out.println("<td colspan='2' align='center'><Footer</td>");
		out.println("<h3>Footer</h3>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</body>");
		out.println("</form>");
		out.println("</html>");

	}

}
