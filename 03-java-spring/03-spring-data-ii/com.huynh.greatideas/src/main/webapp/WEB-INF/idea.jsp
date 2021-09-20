<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" />
<title>Idea</title>
<style>
.name{
outline: 1px solid black;
padding: 0.5rem 1rem;
width: 300px;
text-align: center;
}

a{
	text-decoration:none;
	font-size: 1.2rem;
}


</style>
</head>
<body>

<div>

</div>
<h1>${idea.content}</h1>
<p>Created By: ${user.firstName} ${user.lastName }</p>

<h3>Users who liked your idea:</h3>
<table class="table">
<thead>
<tr>
<th class="name">Name</th>
</tr>
</thead>

<tbody>
<c:forEach items="${idea.usersWhoLiked}" var="u">
<tr >
<td class="name">${u.firstName } ${u.lastName}</td>
</tr>
</c:forEach>
</tbody>
</table>

<div>
<c:choose>
<c:when test="${idea.user.id == user.id }">
<div>
<a href="/ideas/${idea.id}/edit">Edit</a>
<a href="/ideas">Cancel</a>
</div>

</c:when>
<c:otherwise>
<a href="/ideas">Return</a>
</c:otherwise>
</c:choose>
</div>



</body>
</html>