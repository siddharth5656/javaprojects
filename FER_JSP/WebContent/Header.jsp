<html>
<head>

<title>FER_Dashboard</title>
<script>
		function submitForm(action) {
		var form=document.DashboardForm;
		form.action=action;
		form.submit();
		}
		</script>
</head>
<body>
	<form name='DashboardForm'>
		<table align='center' border='1' height='600px' width='800px'>
			<tr height='100px'>
				<td colspan='2' align='center'>Family Expense report User:
					${username}</td>
			</tr>