<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo and Ninjas</title>
</head>
<body>
	<h1>New Dojo</h1>
	
	<a href="/ninjas">Add Ninjas</a> | <a href="/dashboard">Dashboard</a>
	
	<form:form action="/newDojo" method="POST" modelAttribute="dojo">
		<form:label path="name">Name: </form:label>
		<form:input path="name" />
		<form:errors path="name" />
		
		<input type="submit" value="Create" />
	</form:form>
	
	
</body>
</html>