 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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

<body>


<div class="bg">
		<div class="container-fluid bg">
			<div class="row">
<springform:form  action="signup" method="post" modelAttribute="vendor">
<!-- <center>
<i class="fas fa-users"></i>
</center> -->
<h2>Sign Up</h2>
<div class="form-group">
<springform:errors path="name"></springform:errors>
<label for="name">Name:</label>
<springform:input path="name" class="form-control" id="name"/>
</div>
<div class="form-group">
<springform:errors path="email"></springform:errors>
<label for="email">Email:</label>
<springform:input path="email" class="form-control" id="email" placeholder="@email"/>
</div>
<div class="form-group">
<springform:errors path="mobile"></springform:errors>
<label for="mobile">Mobile:</label>
<springform:input path="mobile" class="form-control" id="mobile"/>
</div>
<div class="form-group">
<springform:errors path="password"></springform:errors>
<label for="password">password:</label>
<springform:input type="password" path="password" class="form-control" id="password"/>
</div>
<div class="form-group">
<springform:errors path="companyname"></springform:errors>
<label for="companyname">companyname:</label>
<springform:input path="companyname" class="form-control" id="companyname"/>
</div>
 
<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox">Remember me
</label>
</div>
<button type="submit" class="btn btn-success btn-block">Sign Up</button>

</springform:form>
</body>
</html> 

<style>

.bg { 
    	    /* The image used */
    	    background-image: url("http://lh4.ggpht.com/-MhNrLp6NYs4/U1sK0EXcqKI/AAAAAAAAS-Y/fCnJdHXmClQ/s1024/main-background.jpg");
    	    /* Full height */
    	    width: 100%; 
    	    height: 100vh;

    	    /* Center and scale the image nicely */
    	    background-position: center;
    	    background-repeat: no-repeat;
    	    background-size: cover;
    	}
    	/*.form-container{border:0px solid #fff; padding: 30px 60px;
    		margin-top: 40vh;
    		-webkit-box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);
-moz-box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);
box-shadow: 22px 20px 25px 9px rgba(0,0,0,0.75);
    	}*/
    	form{
    		padding-left: 550px;
    		padding-top: 70px;
    	}

</style>

  