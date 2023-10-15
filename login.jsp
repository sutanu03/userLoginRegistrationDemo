<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<h3 style='color:orange'>Login</h3>

<form action="logForm" method="post">

Email ID : <input type="text" name="email1" placeholder="Enter your registered email id"/> <br><br>
Password : <input type="password" name="password1" placeholder="Enter your password"/> <br><br>
<input type="submit" value="Login"/>

</form>


<h3>Click here to register</h3>
<a href="registration.jsp">Click here</a>

</body>
</html>