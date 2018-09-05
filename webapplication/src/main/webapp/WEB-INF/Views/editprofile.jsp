<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to Edit Page
<springform:form action="update" method="POST" modelAttribute="user">
<table>
<tr>
<td>id</td>
<td><springform:input path="id" type="hidden"/></td>
</tr> 
<tr>
<td>username</td>
<td><springform:input path="name"/></td>
</tr>
<tr>
<td>email</td>
<td><springform:input path="email"/></td>
</tr>
<tr>
<td>password</td>
<td><springform:input path="password" type="hidden"/></td>
</tr> 
<tr>
<td>mobile</td>
<td><springform:input path="mobile"/></td>
</tr>
<tr>
<td>role</td>
<td><springform:input path="role"/></td>
</tr>
</table>
<tr>
<td><input type="submit" value="Update"></td>
</tr>
</springform:form>
</body>
</html>

