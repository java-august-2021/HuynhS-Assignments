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
	<h1>Add a Language</h1>
	<form:form action="/addNewLanguage" method="POST" modelAttribute="language">
		<div>
			<form:label path="name">Language: </form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="creator">Creator: </form:label>
			<form:input path="creator" />
			<form:errors path="creator" />
		</div>
		<div>
			<form:label path="version">Version: </form:label>
			<form:input path="version" />
			<form:errors path="version"/>
		</div>
		<input type="submit" value="Add"/>
		</form:form>	
</body>
</html>