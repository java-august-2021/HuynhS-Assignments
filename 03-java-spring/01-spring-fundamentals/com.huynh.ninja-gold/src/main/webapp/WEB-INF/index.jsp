<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css"/>
<title>Ninja Gold </title>
</head>
<body>
		<h1>Gold: <c:out value="${ totalGold }" /></h1>

<div class="building">
		<form method="POST" action="/getGold" class="form">
		<input type="hidden" name="building" value="farm"/>
		<h2>Farm</h2>
		<p>Earn 10-20 Gold</p>
		<input class="btn" value="Find Gold" type="Submit"/>
	</form>
	
		<form method="POST" action="/getGold" class="form">
		<input type="hidden" name="building" value="cave"/>
		<h2>Cave</h2>
		<p>Earn 5-10 Gold</p>
		<input class="btn" value="Farm" type="Submit"/>
	</form>
	
		<form method="POST" action="/getGold" class="form">
		<input type="hidden" name="building" value="house"/>
		<h2>House</h2>
		<p>Earn 2-5 Gold</p>
		<input class="btn" value="Farm" type="Submit"/>
	</form>
	
		<form method="POST" action="/getGold" class="form">
		<input type="hidden" name="building" value="casino"/>
		<h2>Casino</h2>
		<p>Earn/takes 0-50 Gold</p>
		<input class="btn" value="Farm" type="Submit"/>
	</form>
</div>


<h1>Activities:</h1>
<div class="activities">
<c:forEach items="${ activities }" var="act">
	<p class='${ act.contains("OUCH!") ? "red" : "green" }'><c:out value="${ act }" /></p>
</c:forEach>
</div>

</body>
</html>