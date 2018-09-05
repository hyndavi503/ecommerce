<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<%-- <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:uri=value="/resources/images" var="images"/> --%>
 <link rel="stylesheet" href="edit.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<title>project</title>
</head>
<body>
   <div class="container">
      <nav class="navbar navbar-expand bg-danger navbar-dark justify-content-end">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="signup.html">SignUp</a>
        </li>
    <li class="nav-item">
       <a class="nav-link" href="login.html">Login</a>
   </li>
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

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="footwear">footwear
  <span class="caret"></span>
</a>
  <ul class="dropdown-menu">
<li><a href="shoes">shoes</a></li>
<li><a href="shoes">loafers</a></li>
<li><a href="shoes">flipflops</a></li>
</li>
</ul>


<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="electronics">electronics
<span class="caret"></span></a>
<ul class="dropdown-menu">
  <li><a href="mobiles">mobiles</a></li>
  <li><a href="laptops">laptops</a></li>
  <li><a href="cameras">cameras</a></li>
</li>
</ul>


<li class="page"><a href="Home">Short Codes</a></li>

<li class="page"><a href="Home">Mail Us</a></li>

</ul>
</div>
</nav>
<img src=images.png>
 </body>
</html>
<style>
body,div,nav,ul,li,a
{
	padding-right: 10px;
}
</style>