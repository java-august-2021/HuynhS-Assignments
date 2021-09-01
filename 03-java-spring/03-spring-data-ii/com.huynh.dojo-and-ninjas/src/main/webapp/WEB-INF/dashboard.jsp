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

<h1>All Dojos</h1>

<table>
<thead>
<tr>
<td>Location</td>

</tr>
</thead>
<tbody>
<c:forEach items="${dojos}" var="dojo">


<tr>
	<td><a href="/getInfos/${dojo.id}">${dojo.name}</a></td>
</tr>
</c:forEach>

</tbody>
</table>

<hr>

<h1>Ninjas</h1>

<table>
<thead>
<tr>
<td>Location</td>
</tr>
</thead>
<tbody>
<c:forEach items="${ninjas}" var="ninja">
<tr>
	<td><a href="">${ninja.firstName}</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>

<a href="/">Return</a>
</html>