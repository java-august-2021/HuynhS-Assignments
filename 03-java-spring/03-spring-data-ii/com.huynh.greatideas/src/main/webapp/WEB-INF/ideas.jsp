<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Ideas</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>

<div class="ideas_container">


<form action="/logout" method="POST">
<button class="logout" type="submit">Logout</button>
</form>

<h1>Welcome ${userWhoLiked.firstName}</h1>

<table class="table">
<thead class="table_head">
<tr class="table_head_row">
<th class="table_head_title">Ideas</th>
<th class="table_head_title">Created By</th>
<th class="table_head_title">Likes</th>
<th class="table_head_title">Action</th>

</tr>
</thead>

<tbody class="table_body">
<c:forEach items="${ideas}" var="i">
<tr class="table_body_row">
<td class="table_body_data"><a class="table_body_data_name_link" href="/ideas/${i.id}">${i.content}</a></td>
<td class="table_body_data">${i.user.firstName} ${i.user.lastName}</td>
<td class="table_body_data">${i.usersWhoLiked.size()}</td>

<td class="table_body_data_actions">



<c:choose>
<c:when test="${i.usersWhoLiked.contains(userWhoLiked)}">
	<a class="links" href="/ideas/${i.id}/unlike">Unlike</a>
</c:when>
<c:otherwise>
	<a class="links" href="/ideas/${i.id}/like">Like</a>
</c:otherwise>

</c:choose>
</td>

</tr>
</c:forEach>
</tbody>
</table>
<div>
<a  class="create_ideas" href="/ideas/new">Create An Idea</a>
</div>


</div>


</body>
</html>