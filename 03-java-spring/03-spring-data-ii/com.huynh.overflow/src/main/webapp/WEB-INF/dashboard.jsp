<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
</head>
<body>

<c:forEach items="${allQuestions }" var="q">
<h4><a href="/show/${q.id}">Questions: ${q.questionText}</a> </h4>
<c:forEach items="${q.tags}" var="t">
<p>${t.subject}</p>
</c:forEach>

</c:forEach>
</body>
</html>