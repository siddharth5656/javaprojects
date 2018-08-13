
<html>
<head>
<title>FER-Registration</title>
<script>
	function validateForm() {
		var form = document.RegistrationForm;
		var errorMessage = "";
		if (form.firstname.value == '') {
			errorMessage += "Please enter First Name.<br>";
		}
		//alert('2:' + errorMessage);
		if (form.lastName.value == '') {
			errorMessage += "Please enter Last Name.<br>";
		}
		//alert('3:' + errorMessage);
		if (form.email.value == '') {
			errorMessage += "Please enter Email Id.<br>";
		}
		//alert('4:' + errorMessage);
		if (form.userName.value == '') {
			errorMessage += "Please enter User Name.<br>";
		}
		//alert('5:' + errorMessage);
		if (form.password.value == '') {
			errorMessage += "Please enter Password.<br>";
		}
		//alert('6:' + errorMessage);
		if (form.mobileNo.value == '') {
			errorMessage += "Please enter a valid Mobile Number.<br>";
		} /* else {
			checkMobileNumberInput();
			alert("Must input numbers");
		} */

		//alert('7:' + errorMessage);
		var errorTrId = document.getElementById('errorTrId');
		if (errorMessage != '') {
			//alert(errorMessage);
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.innerHTML = errorMessage;
			errorTdId.style.color = 'red';
			errorTrId.style.display = '';
		} else {

			errorTrId.style.display = 'none';

			form.submit('RegistrationPost.jsp');
		}

	}
	var request;
	function validateUsername() {
		var form = document.RegistrationForm;
		var userName = form.userName.value;
		var url = "FER_AJAX.jsp?userName=" + userName;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getResponse;
			request.open("GET", url, true);
			request.send();

		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	var another_request;
	function validateMobileNumber() {
		var form = document.RegistrationForm;
		var mobileNo = form.mobileNo.value;
		var url = "Ajax_mobileNumber.jsp?mobileNo=" + mobileNo;

		if (window.XMLHttpRequest) {
			another_request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			another_request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			another_request.onreadystatechange = getAnotherResponse;
			another_request.open("GET", url, true);
			another_request.send();

		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	function checkMobileNumberInput() {
		var x = form.mobileNo.value;
		if (isNaN(x)) {
			alert("Must input numbers");
			return false;
		}
	}

	function getResponse() {
		if (request.readyState == 4) {
			var response = request.responseText;
			var registrationButtonId = document
					.getElementById('registrationButtonId');
			if (response.trim() == 'N') {
				alert('Username is not available...')
				registrationButtonId.disabled = true;
			} else {
				registrationButtonId.disabled = false;
			}

		}
	}
	function getAnotherResponse() {
		if (another_request.readyState == 4) {
			var anotherResponse = another_request.responseText;
			var registrationButtonId = document
					.getElementById('registrationButtonId');

			if (anotherResponse.trim() == 'N') {
				alert('Mobile number is not available...')
				registrationButtonId.disabled = true;
			} else {
				registrationButtonId.disabled = false;
			}

		}
	}
</script>
</head>
<body>
	<form name="RegistrationForm" action='RegistrationPost.jsp'>
		<table align='center' border="1">
			<tr>
				<td colspan="2" align='center'>Registration</td>
			</tr>
			<tr id="errorTrId" style='display: none;'>
				<td colspan="2" align='center' id="errorTdId" style='color: red'></td>
			</tr>
			<tr>
				<td>FirstName : <font color="red">*</font>
				</td>
				<td><input type='text' name='firstname'></td>
			</tr>
			<tr>
				<td>MiddleName :</td>
				<td><input type='text' name='middleName'></td>
			</tr>
			<tr>
				<td>LastName : <font color="red">*</font>
				</td>
				<td><input type='text' name='lastName'></td>
			</tr>
			<tr>
				<td>Email Id :<font color="red">*</font>
				</td>
				<td><input type='text' name='email'></td>
			</tr>
			<tr>
				<td>UserName : <font color="red">*</font>
				</td>
				<td><input type='text' name='userName'
					onchange="validateUsername()"></td>
			</tr>
			<tr>
				<td>Password : <font color="red">*</font>
				</td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td>Mobile Number : <font color="red">*</font>
				</td>
				<td><input type='text' name='mobileNo'
					onchange="validateMobileNumber()"></td>
			</tr>
			<tr>
				<td colspan="2" align='center'><input type='button'
					value='Registration' onclick="validateForm();"
					id='registrationButtonId'>
			</tr>

		</table>
	</form>
</body>
</html>















<!-- <!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>FER_Registration</title>

<script>
	function validateForm() {
		var form = document.RegistrationForm;

		var errorMessage = "";
		if (form.firstName.value == '') {
			errorMessage += "Please enter First Name.<BR>";
			//document.getElementById('firstNameTdId').style.color='red';
			//document.getElementById('firstNameTdId').bgcolor='red';
		}
		//alert('1:' + errorMessage);
		if (form.lastName.value == '') {
			errorMessage += "Please enter Last Name.<BR>";
		}
		//alert('2:'+errorMessage);
		if (form.userName.value == '') {
			errorMessage += "Please enter Username.<BR>";
		} /* else if (form.isUsernameAvailable.value == 'N'){
				errorMessage += "Username is not Available.<BR>"; 

		}*/
		//alert('3:'+errorMessage);
		if (form.password.value == '') {
			errorMessage += "Please enter Password.<BR>";
		}
		//alert('4:'+errorMessage);
		if (form.mobileNo.value == '') {
			errorMessage += "Please enter Mobile Number.<BR>";
		}
		//alert('5:'+errorMessage);
		var errorTrId = document.getElementById('errorTrId');

		if (errorMessage != '') {
			//alert(errorMessage);
			var errorTdId = document.getElementById('errorTdId');
			errorTdId.innerHTML = errorMessage;
			errorTdId.style.color = 'red';

			errorTrId.style.display = '';
		} else {
			errorTrId.style.display = 'none';
			form.submit('RegistrationPost.jsp');
		}

		var request;
		function validateUser() {
			var form = document.RegistrationForm;
			var userName = form.userName.value;

			var url = "FER_AJAX.jsp?userName=" + userName;

			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}

			try {
				request.onreadystatechange = getResponse;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}
		}

		function getResponse() {
			if (request.readyState == 4) {
				var response = request.responseText.trim();
				//alert("." + response + ".");
				//document.getElementById('amit').innerHTML=val;  
				var registrationButtonId = document
						.getElementById('registrationButtonId');
				//var tdMessageId = document.getElementById('tdMessageId');

				//var message = "";
				if (response.trim() == 'N') {
					message = "Username is not available";
					//tdMessageId.style.color = 'red';
				} else {
					message = "Username is available";
					//tdMessageId.style.color = 'green';

				}
				//tdMessageId.innerHTML = message;

				//document.getElementById('trMessageId').style.display = '';
				//document.getElementById("isUsernameAvailable").value = response.trim();
			}
		}
	}
</script>
</head>
<body>
	<form name="RegistrationForm" action='RegistrationPost.jsp'>

		<table align='center' border="1">
			<tr>
				<td colspan="2" align='center'>Registration</td>
			</tr>
			<tr id="errorTrId" style='display: none;'>
				<td colspan="2" align='center' id="errorTdId" style='color: red'></td>
			</tr>
			<tr>
				<td>First Name <font color='red'>*</font></td>
				<td><input type='text' name='firstName'></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type='text' name='middleName'></td>
			</tr>
			<tr>
				<td>Last Name <font color='red'>*</font></td>
				<td><input type='text' name='lastName'></td>
			</tr>

			<tr>
				<td>UserName <font color='red'>*</font></td>
				<td><input type='text' name='userName'
					onchange="validateUser()"></td>
			</tr>
			<tr id='trMessageId' style='display: none;'>
				<td colspan='2' id='tdMessageId'></td>
			</tr>
			<tr>
				<td>Password <font color='red'>*</font></td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td>Mobile Number <font color='red'>*</font></td>
				<td><input type='text' name="mobileNo"></td>
			</tr>

			<tr>
				<td colspan="2" align='center'><input type="button"
					value='Registration' onclick="validateForm();"
					id='registrationButtonId'></td>
			</tr>
		</table>
		<input type="hidden" name="isUsernameAvailable"
			id="isUsernameAvailable">
	</form>
</body>
</html>
 -->