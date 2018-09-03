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
This is update page
 <springform:form action="update" method="POST" modelAttribute="update">
 <table>
 <tr>
 <td><springform:label path="id">id:</springform:label></td>
 <td><springform:input path="id" value="${vendor.getId() }"/></td>
 </tr>
 <tr>
 <td><springform:label path="username">username:</springform:label></td>
 <td><springform:input path="username" value="${vendor.getUsername() }"/></td>
 </tr>
 <tr>
 <td><springform:label path="email">email:</springform:label></td>
 <td><springform:input path="email" value="${vendor.getEmail() }"/></td>
 </tr>
 <tr>
 <td><springform:label path="mobile">mobile:</springform:label></td>
 <td><springform:input path="mobile" value="${vendor.getMobile() }"/></td>
 </tr>
 <tr>
 <td><springform:label path="password">password:</springform:label></td>
 <td><springform:input path="password" value="${vendor.getPassword() }"/></td>
 </tr>
 <tr>
 <td><springform:label path="companyName">companyName:</springform:label></td>
 <td><springform:input path="companyName" value="${vendor.getCompanyName() }"/></td>
 </tr>
 <input type="submit" value="update"/>
 </table>
 </springform:form>
</body>
</html>

