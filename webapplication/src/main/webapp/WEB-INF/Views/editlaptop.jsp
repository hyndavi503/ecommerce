<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<div class="bg">
 <div class="container-fluid bg">
		<div class="row justify-content-center">
				<springform:form class="form-container" action="${contextPath}/laptop"
					method="post" modelAttribute="laptop" enctype="multipart/form-data">
					<h2>Add Laptop</h2>
					<div class="form-group">
						<label path="subCategory.sid">SubCategoryId</label>
						<springform:input path="subCategory.sid" class="form-control"  type="hidden" value="${sid }"/>
					</div>
					<div class="form-group">
						<label path="vendor.id">VendorId</label>
						<springform:input path="vendor.id" class="form-control" type="hidden" value="${id}"/>
					</div>
					<div class="form-group">
						<label path="numberOfProducts">numberOfProducts</label>
						<springform:input type="text" path="numberOfProducts" class="form-control" value="${laptop.numberOfProducts}"/>
					</div>
					<div class="form-group">
						<label path="ram">Ram</label>
						<springform:input type="text" path="ram" class="form-control" value="${laptop.ram}"/>
					</div>
					<div class="form-group">
						<label path="rom">Rom</label>
						<springform:input type="text"  path="rom" class="form-control" value="${laptop.rom}" />
					</div>

					<div class="form-group">
						<label path="processor">Processor</label>
						<springform:input type="text" class="form-control" path="processor"  value="${laptop.processor}"/>
					</div>
					<div class="form-group">
						<label path="os">os</label>
						<springform:input type="text" class="form-control" path="os" value="${laptop.os}" />
					</div>
					
					
					<div class="form-group">
					<label path="price">Price</label>
					<springform:input path="price" type="text" class="form-control" value="${laptop.price}"/>
					</div>
					
<div class="form-group">
<label path="image">Image</label>
<springform:input path="image" type="file" class="form-group"/>
</div>
					<button type="submit" class="btn btn-success btn-block">update laptop</button>
				</springform:form>
			</div>
		</div>
	</div>
	
</div>


</body>
</html>