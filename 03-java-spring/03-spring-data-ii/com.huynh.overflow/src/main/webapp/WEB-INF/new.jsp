<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>

<form:form method="POST" action="/newQuestion" modelAttribute="question">

<form:label path="questionText">Question Text: </form:label>
<form:textarea type="text" path="questionText"/>
<form:errors path="questionText" />


<form:label path="tagsFromFrontEnd">Tags: </form:label>
<form:textarea type="text" path="tagsFromFrontEnd"/>
<form:errors path="tagsFromFrontEnd" />


<button>Submit Question</button>


</form:form>




</body>
</html>