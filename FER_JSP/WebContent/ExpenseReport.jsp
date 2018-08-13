<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />

<script>
	function validateForm() {
		var form = document.DashboardForm;
		var errorMessage = "";
		if (form.expenseType.value == '') {
			errorMessage += "Please enter ExpenseType.<BR>";
		}
		if (form.fromDate.value == '') {
			errorMessage += "Please enter FromDate.<BR>";
		}
		if (form.toDate.value == '') {
			errorMessage += "Please enter ToDate.<BR>";
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
			form.submit("ExpenseReportPost.jsp");
		}
	}
</script>
<table align='center' border='1'>
	<tr>
		<td colspan='2' align='center'>Expense Report</td>
	</tr>
	<tr id="errorTrId" style='display: none;'>
				<td colspan="2" align='center' id="errorTdId"></td>
			</tr>
	<tr>
		<td>Expense Type<font color='red'>*</font></td>
		<td><input type='text' name='expenseType'></td>
	</tr>
	<tr>
		<td>From Date<font color='red'>*</font></td>
		<td><input type='text' name='fromDate'></td>
	</tr>
	<tr>
		<td>To Date<font color='red'>*</font></td>
		<td><input type='text' name='toDate'></td>
	</tr>

	<tr>
		<td colspan='2' align='center'><input type="button"
			value="GetReport" onclick="validateForm();">
	</tr>
</table>
<jsp:include page="Footer.jsp" />
