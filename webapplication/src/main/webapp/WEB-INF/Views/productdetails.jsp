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
		
		
		<div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-4">
					<div class="thumbnail">
						<img
							src="<spring:url  value="/resources/images/products/${product.pid}.jpg"></spring:url>"
							alt="${product.price }" style="width: 100%" />

						<div class="caption">

						
						<a href="laptopdetails/${product.pid }"><button
									class="btn btn-primary">view</button></a> <a
								href="editproducts/${product.pid }"><button
									class="btn btn-success">Edit</button></a>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</body>
</html>