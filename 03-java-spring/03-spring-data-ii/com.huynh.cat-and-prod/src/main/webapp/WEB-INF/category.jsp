<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<a href="/">Return</a>
<h1>This is ${category.name} category</h1>

<hr />

<form method="POST" action="/addProductToCategory/${category.id}">
 <select name="product" id="">
 <c:forEach items="${notInCategories}" var="product">
 <option value="${product.id}">${product.name}</option>
 </c:forEach>
 </select>
 
 <input type="submit" value="Add Product"/>
</form>

<hr />

<c:forEach items="${category.products}" var="product">
<p>${product.name}</p>
</c:forEach>

</body>
</html>