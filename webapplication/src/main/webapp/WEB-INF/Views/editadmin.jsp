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
Welcome to EditAdmin Page
<springform:form action="updateadmin" method="POST" modelAttribute="admin">
<table>
 <tr>
<td>id</td>
<td><springform:input path="id" type="hidden"/></td>
</tr> 
<tr>
<td>name</td>
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
</table>
<tr>
<td><input type="submit" value="UpdateAdmin"></td>
</tr>
</springform:form>
</body>
</html>
