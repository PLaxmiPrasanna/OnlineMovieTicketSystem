<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-10 offset=md-1">
			<div class="row">
				<div class="col-md-5 register-left">
					<img src="icon.png">
					<h3>JOIN US</h3>
					<p>Be a part of T-CKT family to know more</p>
					<button type="button" class="btn btn-primary">About Us</button>
				</div>

				<div class="col-md-7 register-right">
					<h2>Register Here</h2>
					<form method="post" action="./RegServlet" >
					<div class="register-form">
					
						<div class="form-group">
							<input type="text" class="form-control" placeholder="UserName" name="name">
							
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="UserID" name="custid">
							
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="password" name="pass">
							
						</div>
						<div class="form-group">
							<input type="date" class="form-control" placeholder="Date" name="custdob">
							
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Contact Number" name="contact">
							
						</div>
						
						<button type="submit" class="btn btn-primary">Register</button>
					</form>
					</div>
				
					
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>