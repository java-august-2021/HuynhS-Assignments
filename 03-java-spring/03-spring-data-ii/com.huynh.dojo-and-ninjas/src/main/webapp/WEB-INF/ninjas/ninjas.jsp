<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>

<h1>Add Ninja</h1>
<form:form action="/ninjas/create" method="POST" modelAttribute="ninjas">
<div>
<form:label path="firstName">First Name: </form:label>
<form:input path="firstName"/>
<form:errors path="firstName" />
</div>

<div>
<form:label path="lastName">Last Name: </form:label>
<form:input path="lastName" />
<form:errors path="lastName" />
</div>

<div>
<form:label path="age">Age: </form:label>
<form:input path="age" />
<form:errors path="age"/>
</div>

<div>
<label>School: </label>
<form:select path="dojo"> 
<option value=""></option>
<c:forEach items="${allDojos}" var="dojo">
<option value="${dojo.id}">${dojo.name}</option>
</c:forEach>
</form:select>
</div>

<input type="submit" value="Add Ninja"/>
</form:form>



</body>
</html>