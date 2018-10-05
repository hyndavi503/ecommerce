
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<title></title>

</style>
</head>
<body>



	<div class="bg">
	
		<div class="container-fluid bg">
		
			<div class="row" style="padding-left:450px;padding-top:100px;">
			<div id="para">
<h3>Everything starts with the CUSTOMER :)</h3>
</div>
				<form action="customer/customerloginprocess" method="post">
					
					<div class="form-group">
					<!-- <i class="fas fa-at"></i> -->
					
						<i class="fas fa-at"></i><label for="email">Email Id:</label>
						<div class="inputdiv">
							<input type="email" name="email" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<i class="fas fa-unlock"></i> <label for="pwd">Password:</label>
						<input type="password" name="password" class="form-control"/>
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox">Remember me

						</label>

					</div>
					<button type="submit" class="btn btn-success btn-block">login</button>
				</form>
			</div>
		</div>
	</div> 
	
	
	
   
	
</body>
</html>
<style>
.bg {
	/* The image used */
	background-image:
		url("https://www.pixelstalk.net/wp-content/uploads/2016/10/Smoke-patterns-lines-colorful-1920x1080-620x349.jpg");
	/* Full height */
	width: 100%;
	height: 100vh;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
 .form-container{border:0px solid #fff; padding:100px;padding-top:50px;
           -webkit-box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);
-moz-box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);
box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);


       } 
form {

	padding-left: 500px;
	padding-top: 50px;
}

text {
	color:#fff;
}
body,form,div,label
{
	text-color:white;
}
.para
{

padding-right:200px;
}
