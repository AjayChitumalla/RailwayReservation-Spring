<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-left:25%">
		<h1 style="margin-left: 20%">Home Page</h1>
		<a href="logout" style="float: right;margin-right: 10%">Logout</a>
		<ul style="list-style-type: none;">
			<br>
			<li><a href="chooseSrcDstn">Book a ticket</a></li><br>
			<li><a href="showTickets">My tickets</a></li><br>
			<li><a href="cancelTicket">Cancel a ticket</a></li><br>
		</ul>
	</div>
</body>
</html>