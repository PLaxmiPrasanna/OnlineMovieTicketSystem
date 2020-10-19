<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<%--.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 28px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.active {
	background-color: #a89e8a;
	color: white;
}--%>
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
body {
background: url(bg.jpg);
font-size:50px;
}
.container {
width:900px;
height:900px;
margin:auto;
background: url(bg.jpg);
}
.container1{
positon:auto;
width:90%;
height:22%;
background: url(bg.jpg);
}
.box1 {
width:40%;
height:85%;
margin-left:99px;
margin-top:25px;
float:left;
opacity:0.95;
background: url(gradient.jpg);
background-size: 500px 170px;
border-radius: 35px;
}
.box2 {
width:40%;
height:85%;
float:right;
margin-top:25px;
margin-right:1px;
background: url(gradient.jpg);
opacity:0.95;
background-size: 500px 170px;
border-radius: 35px;
}
.box3 {
width:40%;
height:85%;
margin: 0 auto;
padding: 10px;
left:5%;
position: relative;
background: url(gradient.jpg);
opacity:0.95;
background-size: 700px 190px;
border-radius: 35px;
}
#txt1 {
text-align:center;
font-size:45px;
}
a:link {
color:white;
}
a:visited {
color:white;
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


  
<div class="header">

		<ul>
		    <li><a href="index.jsp">Go Back</a></li>
			<li><a class="logo"><b>T-CKT</b></a></li>
			<div class="header-right">
				<li><form  action="./LogoutServlet" method="post">
      <input class="button" type="submit" value="Logout">
</form></li>
			</div>
		</ul>


	</div>

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
            %><%= session.getAttribute("username")%> <%    
         }
      } 
%>
<center><h1>Welcome Admin</h1></center>
<div class="container">
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addTheatre.jsp">Add Theater</a></p></div>
<div class ="box2"><p id="txt1"><a style="text-decoration:none" href="deleteTheatre.jsp">Remove Theater</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1" ><a style="text-decoration:none" href="addMovie.jsp">Add Movie</a></p></div>
<div class="box2"><p id="txt1" ><a style="text-decoration:none" href="deleteMovies.jsp">Remove Movie</a></p></div>
</div>
<div class="container1">
<div class="box3"><p id="txt1" ><a style="text-decoration:none" href="addMovieToTheatre.jsp">Add Movie To Theatre</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addShow.jsp">Add Show</a></p></div>
<div class="box2"><p id="txt1"><a style="text-decoration:none" href="deleteShows.jsp">Remove Show</a></p></div>
</div>
<div class="container1">
<div class="box1"><p id="txt1"><a style="text-decoration:none" href="addScreen.jsp">Add Screen</a></p></div>
<div class="box2"><p id="txt1"><a style="text-decoration:none" href="deleteScreen.jsp">Remove Screen</a></p></div>
</div>
</div>
<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>