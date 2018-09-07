<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:url value="/resources/images" var="images"></spring:url>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<body>
 <h1>Welcome to Admin Page</h1>
 <nav class="navbar navbar-expand-sm bg-dark">
 	<ul class="navbar-nav">
 	<li class="nav-item">
 	<a class="nav-link" href="profile">Profile</a>
 	</li>
 	<li class="nav-item">
 	<a class="nav-link" href="editprofile">Edit Profile</a>
 	</li>
 	<li class="nav-item">
      <a class="nav-link" href="userdetails">Users</a>
    </li>
 	</ul> 
</nav>
<div class="container">
<img src="${images}/adminlogin.jpg">
</div>
</body>
</html>
<style>
h1
{
padding-bottom:50px;
}
img
{
padding-top:90px;
padding-left:500px;
}
</style>