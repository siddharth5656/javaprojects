<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>
	/* var request;
	function isUsernameAvailable() {
		var username = document.loginForm.username.value;
		var url = "FER_AJAX.jsp?username=" + username;

		//alert('url: '+url);
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
			//alert('XMLHTTPRequest');
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
			//alert('ActiveXObject');
		}

		try {
			request.onreadystatechange = displayStatus;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function displayStatus() {
		if (request.readyState == 4) {
			var response = request.responseText;
			//alert('Response:'+response+"...");
			//alert('Response:'+response.trim()+"...");
			//var statusTdIdObj = document.getElementById('statusId');
			if (response.trim() == 'N') {
				//var str = "Username is available...";
				//var result = str.fontcolor("green");
				//statusTdIdObj.innerHTML = result;
			} else {
				//var str = "Username is not available...";
				//var result = str.fontcolor("red");
				//statusTdIdObj.innerHTML = result;
			}

			//document.getElementById('statusTrId').style.display = '';
		}
	}

 */	function validateForm() {
		var form = document.loginForm;

		var errorMessage = "";
		if (form.username.value == '') {
			errorMessage += "Please enter Username.<BR>";
			//document.getElementById('UsernameTdId').style.color = 'red';
			//document.getElementById('firstNameTdId').bgcolor='red';
		}
		if (form.password.value == '') {
			errorMessage += "Please enter Password.<BR>";
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
			form.submit();
		}

	}
</script>
</head>
<body>
	<form name='loginForm' action='LoginPost.jsp' method="post">
		<h1>please login</h1>
		<table align='center' border="1">
			<tr>
				<td colspan="2" align='center'>login</td>
			</tr>
			<tr id="errorTrId" style='display: none;'>
				<td colspan="2" align='center' id="errorTdId"></td>
			</tr>

			<tr>
				<td>Username<font color='red'>*</font></td>
				<td><input type="text" name="username" onchange="isUsernameAvailable();"></td>
			</tr>
			 <tr id="statusTrId" style='display: none;'>
				<td colspan="2"><span id="statusId"> </span></td>
			</tr>


			<tr>
				<td>Password<font color='red'>*</font></td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td colspan="2" align='center'><input type='button'
					value='login' onclick="validateForm();">&nbsp;&nbsp; <a
					href='Registration.jsp'>Register</a></td>
			</tr>
		</table>

	</form>
</body>
</html>
