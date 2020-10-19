<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Theatre</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
li {
	float: left;
}
<%--li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	width: 200px;
	font-size: 60%;
}--%>
/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #a89e8a;
}
.active {
	background-color: #a89e8a;
}
.header {
	overflow: hidden;
	background-color: #a89e8a;
	padding: 20px 10px;
	opacity: 0.8;
}
.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	line-height: 5px;
	border-radius: 4px;
}

.header a.active {
	background-color: #a89e8a;
	color: white;
}
.header-right {
	float: right;
}
@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}
.button {
 background-color: #4CAF50;
  float:right;
  border: none;
  color: white;
  padding: 14px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 17px;
  cursor: pointer;
}

body {
margin:0px;
}
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #a89e8a;
	margin-top: 100%;
	width: 100%;
	height: 5%;
	font-size: 200%;
	text-align: center;
	opacity: 0.7;
}
</style>
</head>
<body>

<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");

  %> 

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      } 
%>
<div class="header">

		<ul>
			<li><a class="logo"><b><h2>T-CKT</h2></b></a></li>
			<div class="header-right">
				<li><form  action="./LogoutServlet" method="post">
      <input class="button" type="submit" value="Logout">
</form></li>
			</div>
		</ul>


	</div>
<%-- <form action="./LogoutServlet" method="post">
      <input type="submit" value="Logout">
</form>--%>
<h1>
<% if(request.getAttribute("message")!=null) { %>
<%=request.getAttribute("message") %>
<%} %>
</h1>
<h1> Enter Theatre Details to Register </h1>
<br>
<form method="post" action="./AddTheatreController">
Enter Theater id : <input type="text" name = "theatreId" pattern="[2]{1}[0-9]{3}" title="Theatre Id should start with number 2 and of only 4 digits" required>
<br>
<br>
Enter Theater name :  <input type="text" name="theatreName" pattern= "[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Theater city: <input type="text" name = "theatreCity" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Manager name: <input type="text" name="managerName" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
<br>
<br>
Enter Manager contact: <input type="text" name="managerContact" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit phone number" required>
<br>
<br>
<input type="submit" value = "Register Theatre">
</form>
<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>

</body>
</html>