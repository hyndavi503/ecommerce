<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>numberOfProducts</td>
<td>${laptop.numberOfProducts}</td>
</tr>

<tr>
<td>ram</td>
<td>${laptop.ram}</td>
</tr>
<tr>
<td>rom</td>
<td>${laptop.rom}</td>
</tr>
<tr>
<td>processor</td>
<td>${laptop.processor}</td>
</tr>
<tr>
<td>os</td>
<td>${laptop.os}</td>
</tr>
<tr>
<td>price</td>
<td>${laptop.price}</td>
</tr>
</table>
<input type="button" value="editlaptop"/>
</body>
</html>
