<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Availability</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<a href="home" style="margin-left: 10%">Go to Home</a>
	<a href="logout" style="float: right;margin-right: 10%">Logout</a>
	<div style="margin-left: 35%">
		<% if(request.getAttribute("info")!=null){ %>
			<%= request.getAttribute("info") %>
		<%} %>
		<h2>Check Train Availability</h2>
		<form action="checkAvailability">
			<label>Select Source &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<select name="source" style="width: 90px">
				<option>-</option>
				<% 	TreeSet<String> sources = (TreeSet)session.getAttribute("sourcePoints");
					Iterator iterator = sources.iterator();
					while(iterator.hasNext()){ 
					String source = (String)iterator.next(); %>
					<option><%=source %></option>
				<%} %>
			</select><br><br>
			<label>Select Destination</label>
			<select name="destination" style="width: 90px">
				<option>-</option>
				<% 	TreeSet<String> destinations = (TreeSet)session.getAttribute("destinationPoints");
					Iterator iterator1 = destinations.iterator();
					while(iterator1.hasNext()){ 
					String destination = (String)iterator1.next(); %>
					<option><%= destination %></option>
				<%} %>
			</select><br><br>
			<button>Submit</button>
		</form>
	</div>
</body>
</html>