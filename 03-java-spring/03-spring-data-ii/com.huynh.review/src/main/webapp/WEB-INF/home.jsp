<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/home.css" />
<title>Belt Review</title>
</head>
<body>
	<div class="home_page">

	<div class="form_container">
		<h1 >Registration</h1>

		<form:form action="/register" method="POST" modelAttribute="user">
		
		<div class="form_wrapper">
		<form:input class="form_input" type="text" path="firstName" placeholder="First Name"/>
		<form:errors class="form_errors" path="firstName" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="text" path="lastName" placeholder="Last Name"/>
		<form:errors class="form_errors" path="lastName" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="email" path="email" placeholder="Email"/>
		<form:errors class="form_errors" path="email" />
		</div>
		
		
		<div class="form_wrapper">
		<form:input class="form_input" type="text" path="location" placeholder="Location"/>
		<form:errors class="form_errors" path="location" />
		</div>
		
		<!--  
		<div class="form_wrapper">
		<form:errors class="form_errors" path="state" />
		<form:select class="form_input" path="state">

			<c:forEach items="${states}" var="state">

				<option value="${ state }">${ state }</option>
				
			</c:forEach>
		</form:select>
		</div>
		-->
		<div class="form_wrapper">
		<select class="form_input" name="state" id="">
				<option value="CA">CA</option>
				<option value="WA">WA</option>
				<option value="NV">NV</option>
				<option value="NY">NY</option>
				<option value="FL">FL</option>
		</select>
		</div>

		


		<div class="form_wrapper">
		<form:input class="form_input" type="password" path="password" placeholder="Password"/>
		<form:errors class="form_errors" path="password" />
		</div>
		
		<div class="form_wrapper">
		<form:input class="form_input" type="password" path="confirmPassword" placeholder="Confirm Password"/>
		<form:errors class="form_errors" path="confirmPassword" />
		</div>
		
		<div class="form_wrapper">
		<input class="form_submit" type="submit" value="Register" />
		</div>
	</form:form>
	</div>
	
	
		<div class="form_container">
		<h1>Login</h1>

		<form method="POST" action="/login">
			<div class="form_wrapper">
				<input class="form_input" type="email" name="email" placeholder="Email"/>
			</div>
			<div class="form_wrapper">
				<input  class="form_input" type="password" name="password" placeholder="Password"/>
			</div>
			<div class="form_wrapper">
				<input class="form_submit" type="submit" value="Login"/>
			</div>
		</form>
		<span class="login_errors">${error}</span>
		
		</div>
	
	
	</div>


</body>
</html>
