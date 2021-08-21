<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Final Result</title>
<link rel="stylesheet" href="css/style.css">

<style>
	:root {
		--color-white: #fff;
		--color-dark: #212121;
	}
	*, *::before, *::after {
		padding: 0;
		margin: 0;
		}
	html {
		box-sizing: border-box;
	}
	.container {
		width: 300px;
		margin: 10vh auto;
		box-shadow: 0px 0px 3rem rgba(0,0,0,.3);
		background-color: var(--color-dark);
	}
	.infos {
		width: 280px;
		height: 280px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: stretch;
		margin: auto;
		text-align: center;
	}
	.info__font {
		color: var(--color-white)
	}

	}
</style>
</head>
<body>
	<div class="container">
		<div class="infos">
			<h1 class="info__font"><c:out value="${ name }"/></h1>
			<p class="info__font" >Location: <c:out value="${ location }" /></p>
			<p class="info__font" >Language: <c:out value="${ language }" /></p>
			<p class="info__font" >Message: <c:out value="${ message }" /></p>
		</div>

	</div>

</body>
</html>