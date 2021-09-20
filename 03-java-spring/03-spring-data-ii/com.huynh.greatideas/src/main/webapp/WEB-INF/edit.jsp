<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Idea</title>
</head>
<body>
<h3>Create a new idea</h3>

<form:form action="/ideas/${idea.id}/update" method="POST" modelAttribute="idea">
<form:label path="content">Content: </form:label>
<form:input path="content" type="text"/>
<form:errors path="content" />

<form:hidden path="user" value="${user.id}" />


<input type="submit" value="Edit"/>
</form:form>

<a href="/ideas/${idea.id}/delete">Delete</a>

<a href="/ideas">Return</a>

</body>
</html>