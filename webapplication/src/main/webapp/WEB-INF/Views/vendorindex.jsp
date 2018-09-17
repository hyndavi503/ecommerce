
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
<div class="bg">
 <h1>Welcome to Vendor Page</h1>
 <%@include file="navbar.jsp"%>
 <nav class="navbar navbar-expand-sm bg-dark">
 	<ul class="navbar-nav">
 	<li class="nav-item">
 	<a class="nav-link" href="profile">Profile</a>
 	</li>
 	<li class="nav-item">
 	<a class="nav-link" href="editprofile">Edit Profile</a>
 	</li>
 	<li class="nav-item">
 	<a class="nav-link" href="vendordetails">Vendor details</a>
 	</li>
 	<li class="nav-item">
 	<a class="nav-link" href="categorydetails">Add Products</a>
 	</li>
 	 <li class="nav-item">
 	<a class="nav-link" href="productdetails">View Products</a>
 	</li> 
 	</ul> 
</nav>
</div>
<%-- <%@include file="navbar.jsp"%> --%>
</body>
</html>
<style>
h1
{
padding-bottom:50px;
}
.bg
{
background-image: url("https://png.pngtree.com/thumb_back/fw800/back_pic/00/01/80/73560a545c6ae6b.jpg");
width:100%;
height:100vh;
background-position: center;
background-repeat: no-repeat;
background-size: cover;
}
form
{
padding-left: 600px;
padding-top: 150px;
}
</style>