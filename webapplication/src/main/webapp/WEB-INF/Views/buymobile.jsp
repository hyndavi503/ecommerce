<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="contextpaths.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<%@include file="contextpaths.jsp" %>
<div style="flex: 2">
		<img src='<spring:url value="/resources/images/products/${mobile.pid }.jpg"></spring:url>'>
	</div>
	<table>
<tr>
<td>Ram:</td>
<td>${mobile.ram}</td>
</tr>
<tr>
<td>Rom:</td>
<td>${mobile.rom}</td>
</tr>
<tr>
<td>Processor:</td>
<td>${mobile.processor}</td>
</tr>
<tr>
<td>OS:</td>
<td>${mobile.os}</td>
</tr>
<tr>
<td>Brand Name:</td>
<td>${mobile.brandname}</td>
</tr>
<tr>
<td>Price:</td>
<td>${mobile.price}</td>
</tr>
<tr>
<td>No. of Products:</td>
<td>${mobile.numberOfProducts}</td>
</tr>
</table>
<form action="${contextPath}/customer/addtocart" method="get">
			<table>
					<tr>
						<td>Product Id</td>
						<td><input type="hidden" name="pid"
							value="${mobile.pid }" /></td>
					</tr>
					<tr>
						<td>Enter number of products</td>
						<td><input type="number" name="noOfProducts"></td>
					</tr>

					<tr>
						<td><input type="submit" value="Buy now"></td>
					</tr>
			</table>
		</form>
</body>
</html>