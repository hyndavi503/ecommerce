<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-sm bg-grey navbar-dark ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">
		<ul class="navbar-nav">

            <li class="nav-item"><a class="nav-link text-primary" href="/">Home</a></li>
            
			<!-- Dropdown -->  
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-primary" href="#" id="navbardrop"
				data-toggle="dropdown">Electronics</a>
				
				<div class="dropdown-menu">
				<c:forEach  items="${electronics}" var="electronic">
					<a class="dropdown-item"
							href="${contextPath}/products/${electronics.sid}">${electronics.subCategoryname}</a>
		        </c:forEach>
		        </div>
				
				</li>
				
			
</ul>
	</div>
</nav>