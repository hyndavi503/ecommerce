<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is profile page
<spring:form>
<table>
<tr>
<td>username:</td>
<td>${user.name}</td>
</tr>
<tr>
<td>email:</td>
<td>${user.email}</td>
</tr>
<tr>
<td>mobile:</td>
<td>${user.mobile}</td>
</tr>
<tr>
<td>password:</td>
<td>${user.password}</td>
</tr>
<tr>
<td>role:</td>
<td>${user.role}</td>
</tr>
</table>
<a href="editprofile">editprofile</a>
</spring:form>
</body>
</html>


