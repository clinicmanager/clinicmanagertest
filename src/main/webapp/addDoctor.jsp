<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
</head>
<body>

Add the Dr:
<form action="/doctor" method="post">
	Enter the name: <input type="text" name="drname"><br>
	Enter the username: <input type="text" name="username"><br>
	Enter the password: <input type="text" name="password"><br>
	Enter the phone no: <input type="text" name="phoneno"><br>
	<input type="submit">
</form>

Find the Drs:
<a href="/doctors">Click Here</a>

<form action="/doctor" method="get">
	Enter the id : <input type="text" name="drid">
	<input type="submit">
</form>

</body>
</html>