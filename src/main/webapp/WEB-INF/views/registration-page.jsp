<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div>
		<h1>Register</h1>
		<form:form modelAttribute="user" action="processRegistration" method="POST">
		
			<label>Username</label> <br/>
			<form:input path="userName" id="name"/><br/>
			
			<label>Email</label> <br/>
			<form:input path="email" id="email"/><br/>
			
			<label>Gender</label><br>
			<form:select path="gender">
				<form:option value="male">Male</form:option>
				<form:option value="female">Female</form:option>
			</form:select><br/>
			
			<label>Address </label><br>
			<form:textarea rows="5" cols="40" path="address" id="address"/><br>
			
			<label>Password </label><br>
			<form:password path="password" id="password"/><br>
			
			<input type="submit" value="Submit" id="submit">
		</form:form>
		<br>
		Already have an Account? <a href="login">Login</a> 
	</div>
</body>
</html>