<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<h3 style="color: orange;">Register Yourself :-</h3>
	<form action="regisForm" method="post">

		Name : <input type="text" name="name" placeholder="Enter your full name" /> <br> <br> 
		Email ID :<input type="text" name="email" placeholder="Enter your email id" /><br> <br> 
		Password : <input type="password" name="password"placeholder="Create your password" /> <br> <br> 
		Gender : <input type="radio" name="gender" value="Male" /> Male <input type="radio" name="gender" value="Female" /> Female <br> <br> 
			
		City : <select name="city">
				<option>Select city</option>
				<option>Kolkata</option>
				<option>Mumbai</option>
				<option>Chennai</option>
				<option>Delhi</option>
				<option>Banglore</option>
			</select> <br> <br> 
			
			<input type="submit" value="Register" />
	</form>
	
	<h3>Click here to login</h3>
<a href="login.jsp">Click here</a>
</body>
</html>