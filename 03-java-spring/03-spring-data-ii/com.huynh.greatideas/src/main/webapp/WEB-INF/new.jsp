<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Idea</title>

<style>
.create{
width: 30%;
display: flex;
flex-direction: column;
align-items: flex-start;
}
.errors{
color: red;
font-size: 10px;
}
.submit{
margin-top: .5rem}
</style>
</head>
<body>


<h3>Create a new idea</h3>

<div>

<form:form class="create" action="/ideas/create" method="POST" modelAttribute="idea">
<form:errors class="errors" path="content" />
<form:input path="content" type="text" placeholder="Create New Idea"/>

<form:hidden path="user" value="${user.id}" />


<input class="submit" type="submit" value="Create"/>

</form:form>
</div>

</body>
</html>