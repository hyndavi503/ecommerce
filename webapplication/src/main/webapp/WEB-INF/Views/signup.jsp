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
<springform:form  action="signup" method="post" modelAttribute="user">
    <table>
      <tr>
      <td><springform:label path="name">Name:</springform:label></td>
      <td><springform:input path="name"/></td>
      </tr>
      
        <tr>
      <td><springform:label path="email">Email:</springform:label></td>
      <td> <springform:input path="email"/></td>
      </tr>
     
        <tr>
      <td><springform:label path="mobile">Mobile:</springform:label></td>
      <td>    <springform:input path="mobile"/></td>
      </tr>
     
       <tr>
      <td><springform:label path="password">Password:</springform:label></td>
      <td>   <springform:input type="password" path="password"/></td>
      </tr>
               <td><springform:label path = "role">Role</springform:label></td>
               <td>
                  <ul>
            <springform:select path="role">
                <springform:option value="vendor">Vendor</springform:option>
                <springform:option value="customer">Customer</springform:option>
                <springform:option value="admin">Admin</springform:option>
            </springform:select>
        </ul>
               </td>
            </tr>
    <tr><td><input type="submit" value="signup"/></td></tr>
   </table>
</springform:form>
</body>
</html> 


 <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
	

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<title></title>
</head>
<body>
<springform:form  action="signup" method="post" modelAttribute="user">
	<div class="bg">
<div class="container-fluid bg">
	<div class="row">
		<div class="col-md-4 col-sm-4 col-xs-12"></div>
		<div class="col-md-4 col-sm-4 col-xs-12"></div>
		<div class="col-md-4 col-sm-4 col-xs-12"></div>

<center><form class="form-container" justify-content-center>
	<h1>Sign Up Here!!!</h1>
<div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" id="name">
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email">
  </div>
<div class="form-group">
    <label for="mobile">Mobile:</label>
    <input type="mobile" class="form-control" id="mobile">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
<div class="form-group">
      <label for="role">Role:</label>
<input type="radio" name="customer">Customer
    </div>
    <div class="radio">
      <label><input type="radio" name="vendor">Vendor</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="admin" >Admin</label>
    </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>

  <button type="submit" class="btn btn-success btn-block">Submit</button>
</form>
</center>
</springform:form>
</div>
</body>
</html> --%>