<jsp:include page="Header.jsp" />
<jsp:include page="LeftFrame.jsp" />
<script>
		function validateForm() {
			var form = document.DashboardForm;
			
			var errorMessage = "";
			if(form.currentPassword.value == '') {
				errorMessage += "Please enter currentPassword.<BR>";
				//document.getElementById('currentPasswordTdId').style.color='red';
				//document.getElementById('firstNameTdId').bgcolor='red';
			}
			if(form.newPassword.value == '') {
				errorMessage += "Please enter newPassword.<BR>";
			}
			if(form.confirmPassword.value == '') {
				errorMessage += "Please enter confirmPassword.<BR>";
			}
			
			
			var errorTrId = document.getElementById('errorTrId');
			
			if(errorMessage != '')	{
				//alert(errorMessage);
				var errorTdId = document.getElementById('errorTdId');
				errorTdId.innerHTML = errorMessage;
				errorTdId.style.color = 'red';
				
				errorTrId.style.display='';
			} else {
				errorTrId.style.display='none';
				form.submit("ResetPasswordPost.jsp");
			}
			
		}
</script>




<table align='center' border='1'>
		<tr>
		<td colspan='2' align='center'>ResetPassword</td>
		</tr>
		<tr id="errorTrId" style='display:none;'>
		<td colspan="2" align='center'  id="errorTdId">
		</td>
		</tr>
		<tr>
		<td>CurrentPassword<font color='red'>*</font></td>
		<td><input type='text' name='currentPassword'></td>
		</tr>
		<tr>
		<td>NewPassword<font color='red'>*</font></td>
		<td><input type='password' name='newPassword'></td>
		</tr>
		<tr>
		<td>ConfirmPassword<font color='red'>*</font></td>
		<td><input type='password' name='confirmPassword'></td>
		</tr>

		<tr>
		<td colspan='2' align='center'><input type='button'
		value='ResetPassword' onclick= "validateForm();">
		<!-- <a href="javascript:submitForm('ResetPasswordPost.jsp')"></a> -->
		</tr>

		</table>
		
		
<jsp:include page="Footer.jsp" />

		