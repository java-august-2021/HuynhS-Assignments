<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration/Login</title>
<link rel="stylesheet" href="css/index.css" />
</head>
<body>

<div class="home_page">

<div>
<h1>Register</h1>
<form:form class="form register" action="/register" method="POST" modelAttribute="user">

<div class="form_wrapper">

<form:errors class="form_errors" path="firstName" />
<form:input class="form_input" path="firstName" type="text" placeholder="First Name"/>

</div>

<div class="form_wrapper">
<form:errors class="form_errors" path="lastName" />
<form:input class="form_input" path="lastName" type="text" placeholder="Last Name"/>
</div>

<div class="form_wrapper">
<form:errors class="form_errors" path="email" />
<form:input class="form_input" path="email" type="text" placeholder="Email"/>
</div>

<div class="form_wrapper">
<form:errors class="form_errors" path="password" />
<form:input class="form_input" path="password" type="password" placeholder="Password"/>

</div>

<div class="form_wrapper">
<form:errors class="form_errors" path="confirmPassword" />
<form:input class="form_input" path="confirmPassword" type="password" placeholder="Confirm Password"/>

</div>

<input class="form_submit" type="submit" value="Register"/>
</form:form>
</div>



<div class="form_wrapper">
<h1>Login</h1>
<form class="form" action="/login" method="POST">
<span class="login_error" >${error}</span>
<div>
<input class="form_input" type="email" name="email"/>
</div>

<div>
<input class="form_input" type="password" name="password"/>
</div>

<input class="form_submit" type="submit" value="Login"/>
</form>

</div>

</div>

</body>
</html>