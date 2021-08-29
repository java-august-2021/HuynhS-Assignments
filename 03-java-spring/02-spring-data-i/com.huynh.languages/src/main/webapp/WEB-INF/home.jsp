<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
	<div class=container"">

	<h1 class="languages">Languages</h1>
	
		<table>
		<thead>
			<tr>
				<th>Language</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody class="table__body">
			<c:forEach items="${ languages }" var="language">
			<tr>
				<td><a class="table-link" href="/detail/${language.id}">${ language.name }</a></td>
				<td>${ language.creator }</td>
				<td>${ language.version }</td>
				<td>

				<form action="/deleteLanguage/${language.id}" method="POST">
					<input class="table-input"type="submit" value="delete" />
				</form>

					<a class="table-edit" href="/updatePage/${language.id}">Edit</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	
	<a class="add_page" href="/addpage">Add a Language</a>
	</div>

	
	
	
</body>
</html>