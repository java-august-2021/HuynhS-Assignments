<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>


<h1>Products Page</h1>

<a href="/">Return</a>


<form action="/addProduct" method="POST">
<div>
<label for="name">Product Name: </label>
<input type="text" name="name"/>
</div>

<div>
<label for="description">Produce Description: </label>
<input type="text" name="description"/>
</div>

<div>
<label for="price">Produce Price: </label>
<input type="number" name="price" step="0.01"/>
</div>

<input value="Add Product" type="submit"/>

</form>

<hr />

<h1>All Products</h1>

<c:forEach items="${products}" var="product">
<p><a href="/product/${product.id}">${product.name}</a></p>
</c:forEach>



</body>
</html>