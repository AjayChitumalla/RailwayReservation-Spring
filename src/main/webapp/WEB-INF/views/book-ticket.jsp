<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.org.bean.Train" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<a href="home" style="margin-left: 10%">Go to Home</a>
	<a href="logout" style="float: right;margin-right: 10%">Logout</a>
	
	<h1 style="margin-left: 35%">Fill Your Details</h1>
	
	<% if(request.getAttribute("info")!=null){ %>
		<div style="margin-left: 30%"><%= request.getAttribute("info") %></div>
	<%} %>
	
	<% Train train = (Train)(session.getAttribute("selectedTrain")); %>
	<form style="border: 1px solid red;max-width: 35%;max-height: 300px;margin-left: 35%" action="bookTicket" method="post">
		<%= train.getTrainNumber() %>
		<span style="float: right"><b><%=train.getTrainName() %></b></span><br>
		<span style="margin-left: 25%"><b><%=train.getSourcePoint() %> ---> <%=train.getDestinationPoint() %></b></span><span style="float: right">Date : <%=train.getDate() %></span><br>
		<span>Starts at : <%=train.getStartTime() %> </span><span style="float: right">Reaches at : <%=train.getReachTime() %></span>
		<div style="margin-left: 25%">Available seats : <%=train.getAvailableSeats() %> </div>
		<span style="margin-left: 30%">Fare : Rs.<b><%=train.getFare() %>.00</b></span><br>
		<label>Number of seats : </label>
		<input type="number" name="numberOfSeats" style="width:80px" ><br>
		<label>Select the class   : </label>
		<select name="ticketClass" style="width:90px">
			<option value="-">-</option>
			<option value="First class">First class</option>
			<option value="Economy">Economy</option>
			<option value="Sleeper">Sleeper</option>
		</select><br>
		<input type="hidden" name="trainNumber" value=<%= train.getTrainNumber() %>>
		<input type="hidden" name="trainFare" value=<%= train.getFare() %>>
		<button style="float: right">Book Ticket</button>
	</form><br>
</body>
</html>