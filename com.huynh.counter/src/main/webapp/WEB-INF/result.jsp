<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	:root {
		--color-primary: #bf360c;
		--color-secondary: #fff;
		--color-light-grey: #eeeeee;
		--color-dark: #263238;
	}
	*{
		margin: 0;
		widht: 0;
		box-sizing: border-box;
	}
	
	body  {
		background-color: var(--color-dark)
	}
	
	div {
		border: .5px solid #eeeeee;
		width: 300px;
		height: 250px;
		margin: 20vh auto;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		box-shadow: 0 2px 10px #e0e0e0;
	}
	h1 {
		margin-top: 2vh;
		color: var(--color-secondary);
		letter-spacing: 5px;
	}
	
	a {
		color: white;
		list-style: none;
	}
	
	form {
		margin-top: 2vh;
	}
	
	input {
		margin-bottom: 2vh;
		color: var(--color-secondary);
		margin-top: 5vh;
		border: none;
		cursor: pointer;
		padding: 20px 45px;
		border-radius: 100px;
		background-color: var(--color-primary);
		box-shadow: 0 0 15px #ffa726;
		transition: all 500ms;
	}
	input:hover {
		transform: scale(1.3) translateY(-5px)
	}
	

</style>
</head>
<body>
	<div>
		<h1>Visited: <c:out value="${ sessionScope.count }" /></h1>
		<a href="/">Return</a>
		<form action="/reset" method="POST">
			<input type="submit" value="Reset"/>
		</form>
	</div>

	
</body>
</html>