<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
	<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.print(message);
	%>
	<form method = "post" action = "GetTheatreDetails" align = "center">
	
	Select Theatre City : 
		<select name = "theatreCity">
			<option value = "Hyderabad">Hyderabad</option>
			<option value = "Warangal">Warangal</option>
			<option value = "Adilabad">Adilabad</option>
			<option value = "Nizamabad">Nizamabad</option>
			<option value = "Khammam">Khammam</option>
		</select>
		<input type = "submit" value = "Submit">
	</form>
		
	</body>
</html>