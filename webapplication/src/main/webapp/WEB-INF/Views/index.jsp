<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url value="/resources/images" var="images"></spring:url>
<!--  <link rel="stylesheet" href="edit.css"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<title>project</title>
</head>
<body>
   <div class="container-fluid">
      <nav class="navbar navbar-expand bg-danger navbar-dark justify-content-end">
        <ul class="navbar-nav">
          <li class="nav-item">
          
            <a class="nav-link" href="signup">SignUp</a>
        </li>
    <li class="nav-item">
       <a class="nav-link" href="login">Login</a>
   </li>
   <li class="nav-item">
       <a class="nav-link" href="customersignup">Customer Signup</a>
   </li>
   <li class="nav-item">
       <a class="nav-link" href="customerlogin">Customer Login</a>
   </li>
   <li class="nav-item">
   <a class="nav-link" href="adminlogin">Admin Login</a>
<hr>
<hr>
</div>
</nav>
      <div class="container">
        <nav class="navbar navbar-expand bg-white navbar-dark">
          <h1><code>Best Store</code></h1>
            <ul class="navbar-nav">
              <li class="nav-item"></li>
                


<!-- <ul class="nav navbar-nav"> -->
<li class="page"><a href="Home">Home</a></li>


<li class="page"><a href="Home">Short Codes</a></li>

<li class="page"><a href="Mail us">Mail Us</a></li>

</ul>
</div>
</nav>
<%-- <img src="${images}/images.png"> --%>
<div id="demo" class="carousel slide" data-ride="carousel">

 
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>


  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${images}/images.png" alt="Los Angeles">
    </div>
    <div class="carousel-item">
      <img src="${images}/phone.jpg" alt="Chicago">
    </div>
    <!-- <div class="carousel-item">
      <img src="laptop.jpg" alt="New York">
    </div> -->
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
 <%@include file="footer.jsp"%> 
 </body>
</html>
<style>
 body,div,nav,ul,li,a
{
	padding-right: 10px;
} 
img
{
	width:100%;
	height:100%;
}
</style>