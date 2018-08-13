<
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AddExpense</title>

<script>
	function validateForm() {
		var form = document.AddExpenseForm;
		var errorMessage = "";

		if (form.expenseType.value == '') {
			errorMessage += "Please enter ExpenseType.<BR>";
			//document.getElementById('ExpenseTypeTdId').style.color='red';
			//document.getElementById('firstNameTdId').bgcolor='red';
		}
		if (form.date.value == '') {
			errorMessage += "Please enter Date.<BR>";
		}
		if (form.price.value == '') {
			errorMessage += "Please enter Price.<BR>";
		}
		if (form.noOfItems.value == '') {
			errorMessage = errorMessage + "Please enter noOfItems.<BR>";
		}
		if (form.total.value == '') {
			errorMessage += "Please enter total Account.<BR>";
		}
		if (form.byWhom.value == '') {
			errorMessage += "Please enter ByWhom.<BR>";
		}

		var errorTrId = document.getElementById('errorTrId');

		if (errorMessage != '') {
			//alert(errorMessage);
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.innerHTML = errorMessage;
			errorTdId.style.color = 'red';

			errorTrId.style.display = '';
		} else {
			errorTrId.style.display = 'none';
			form.submit("AddExpensePost.jsp");
		}

	}
</script>
</head>
<body>
	<form name="AddExpenseForm" action="AddExpensePost.jsp">
		<jsp:include page="Header.jsp" />
		<jsp:include page="LeftFrame.jsp" />

		<table align='center' border='1'>
			<tr>
				<td colspan='2' align='center'>Add Expense</td>
			</tr>

			<tr id="errorTrId" style='display: none;'>
				<td colspan="2" align='center' id="errorTdId"></td>
			</tr>
			<tr>
				<td>ExpenseType<font color='red'>*</font></td>
				<td><input type='text' name='expenseType'></td>
			</tr>
			<tr>
				<td>Date<font color='red'>*</font>
				</td>
				<td><input type='text' name='date'></td>
			</tr>
			<tr>
				<td>Price<font color='red'>*</font></td>
				<td><input type='text' name='price'></td>
			</tr>
			<tr>
				<td>No Of Items<font color='red'>*</font></td>
				<td><input type='text' name='noOfItems'></td>
			</tr>
			<tr>
				<td>total A/c<font color='red'>*</font></td>
				<td><input type='text' name='total'></td>
			</tr>
			<tr>
				<td>By Whom<font color='red'>*</font></td>
				<td><input type='text' name='byWhom'></td>
			</tr>

			<tr>
				<td colspan='2' align='center'><input type='button'
					value='AddExpense' onclick="validateForm();"></td>
				<a href="javascript:submitForm('AddExpensePost.jsp')"></a>

			</tr>
		</table>
	</form>
</body>
<jsp:include page="Footer.jsp" />
</html>