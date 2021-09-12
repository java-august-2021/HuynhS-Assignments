<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>

<h1>Categories Page</h1>

<a href="/">Return</a>

<form action="/addCategory" method="POST">

<label for="category">Category Name: </label>
<input type="text" name="category"/>

<input type="submit" value="Add Cateogry" />

</form>

<hr />

<c:forEach items="${categories}" var="cat">

<p><a href="/category/${cat.id}">${cat.name}</a></p>
</c:forEach>


</body>
</html>