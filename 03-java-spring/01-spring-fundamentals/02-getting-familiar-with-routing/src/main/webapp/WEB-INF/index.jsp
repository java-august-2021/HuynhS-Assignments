<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring project demo</title>
</head>
<body>

<h1>Joke</h1>
<hr>

	<form method="POST" action="/tellJoke">
		<label for="name">Name: </label>
		<input name="name" type="text"/>
		<label for="joke">Joke:  </label>
		<input name="joke" type="text"/>
		<button type="submit">Joke</button>
	</form>
	


</body>
</html>