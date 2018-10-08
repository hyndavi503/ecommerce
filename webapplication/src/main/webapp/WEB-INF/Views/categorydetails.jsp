<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="bg">
<form action="subcategory" method="post">
<nav class="navbar navbar-expand-sm-bg-danger navbar-danger">
<div class="form-group">
<label for="items">Categories</label>

<select class="form-control" id="items" name="cid">
<c:forEach items="${categorylist}" var="category">
<option value="${category.cid}">${category.cname}</option>

</c:forEach>
</select>
</div>
</nav>
<input type="submit" value="go">

</form>
</div>
</body>
</html>


<style>
.bg { 
    	    background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROejhNVgMlc0SWjx6U9Xl8IidYR9uzoNgYWvVTXQGEAlHC11Ww");
    	    width: 100%; 
    	    height: 100vh;

    	    /* Center and scale the image nicely */
    	    background-position: center;
    	    background-repeat: no-repeat;
    	    background-size: cover;
    	}
    	form{
    		padding-left: 550px;
    		padding-top: 70px;
    	}

</style>



