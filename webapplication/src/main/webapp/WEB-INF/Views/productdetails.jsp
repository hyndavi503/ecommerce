<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

<%-- <c:forEach items="${productList}" var="products">
    <c:out value="${products.price}"></c:out>

</c:forEach>--%>


<%-- <div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="#"> <img src="<spring:url  value="/resources/images/products/${product.pid}.jpg"></spring:url>" alt="${product.price }"
							style="width: 100%">
						</a>
						<div class="caption">

							<a href="laptopdetails/${product.pid}"><button
									class="btn btn-primary">view</button></a>
									<!-- <input type="button" value="edit"> -->
						</div>
					</div>
				</div>
			</c:forEach>
		</div> --%>
		
		<%@include file="contextpaths.jsp" %>
		<div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-4">
					<div class="thumbnail">
						<img
							src="<spring:url  value="/resources/images/products/${product.pid}.jpg"></spring:url>"
							alt="${product.price}" style="width: 100%" />

						<div class="caption">

						
						<a href="${contextPath}/vendor/viewproductdetails/${product.pid }"><button
									class="btn btn-success">view</button></a> <a
								href="editproducts/${product.pid}"><button
									class="btn btn-success">Edit</button></a>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</body>
</html>