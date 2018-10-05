<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<%@include file="contextpaths.jsp" %>
<div class="container">
<div class="row">
<c:forEach items="${productList}" var="product">
<div class="thumbail">

<a href="#"> 
<img src="<spring:url  value="/resources/images/products/${product.pid}.jpg"></spring:url>"
		 alt="${product.price}" style="width:100%">
		 </a>
<a href="${contextPath}/productspecifications/${product.pid }"><button class="btn btn-success">view</button></a>
									
</div>
</c:forEach>

</div>
</div>


</body>
</html>
