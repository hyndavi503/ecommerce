
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
Welcome to Edit Page
<springform:form action="update" method="POST" modelAttribute="vendor">
<table>
 <tr>
<td>id</td>
<td><springform:input path="id" value="${vendor.id}" type="hidden"/></td>
</tr> 
<tr>
<td>name</td>
<td><springform:input path="name" value="${vendor.name}"/></td>
</tr> 
<tr>
<td>email</td>
<td><springform:input path="email" value="${vendor.email}"/></td>
</tr>
<tr>
<td>password</td>
<td><springform:input path="password" value="${vendor.password}" type="hidden"/></td>
</tr> 
<tr>
<td>mobile</td>
<td><springform:input path="mobile" value="${vendor.mobile}"/></td>
</tr>
<tr>
<td>companyname</td>
<td><springform:input path="companyname" value="${vendor.companyname}"/></td>
</tr>
</table>
<tr>
<td><input type="submit" value="Update"></td>
</tr>
</springform:form>
</body>
</html>
