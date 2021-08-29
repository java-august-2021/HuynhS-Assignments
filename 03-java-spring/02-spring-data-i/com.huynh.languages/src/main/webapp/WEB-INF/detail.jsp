<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
	<h1>Detail</h1>
	<h4><c:out value="${lang.name}" /></h4>
	<p><c:out value="${lang.creator}"/></p>
	<p><c:out value="${lang.version}" /></p>
	
	<form action="/deleteLanguage/${language.id}" method="POST">
		<input type="submit" value="delete" />
	</form>
	<a href="/updatePage/${lang.id}">Edit</a>
</body>
</html>