<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${question.questionText}</h1>
<p>
<c:forEach items="${question.tags}" var="tag">
${tag.subject},
</c:forEach>
</p>

<hr />

<h1>Answers</h1>

<c:forEach items="${question.answers}" var="answers">
<p>${answer.answerText}</p>
</c:forEach>


<hr />

<form:form method="POST" action="/addAnswer" modelAttribute="answer">

<form:label path="quest">Answer: </form:label>
<form:input path="quest" type="text"/>
<form:errors path="quest" />

<form:hidden path="quest" value="${question.id}" />

<input type="submit" value="add"/>

</form:form>


</body>
</html>