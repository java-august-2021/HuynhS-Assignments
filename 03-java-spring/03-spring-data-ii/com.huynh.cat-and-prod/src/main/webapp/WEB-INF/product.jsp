<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>

<h2>This is ${product.name} Product</h2>
<a href="/">Return</a>

<p>${product.description} || ${product.price}</p>


<hr />



<hr />

<form method="POST" action="/addCategoryToProduct/${product.id}">

<select name="category" id="">
<c:forEach items="${notInProducts}" var="cat">
<option value="${cat.id}">${cat.name}</option>
</c:forEach>

</select>
<input type="submit" value="Add Category"/>
</form>

<hr />

<c:forEach items="${product.cats}" var="cat">
<p>${cat.name}</p>
</c:forEach>

</body>
</html>