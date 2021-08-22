<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counting!</title>
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
		height: 200x;
		margin: 20vh auto;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		box-shadow: 0 2px 10px #e0e0e0;
		animation: boxAnimation 5000ms alternate infinite;
	}
	h1 {
		margin-top: 2vh;
		color: var(--color-secondary);
		letter-spacing: 5px;
	}
	@keyframes boxAnimation {
		0% {
			transform: translateX(0px);
		}
		
		50% {
			transform: translateX(300px)
		}
		100% {
			transform: translateX(-300px);
		}
	}
	
	input {
		margin-bottom: 2vh;
		color: var(--color-secondary);
		margin-top: 5vh;
		border: none;
		cursor: pointer;
		padding: 10px 20px;
		border-radius: 100px;
		background-color: var(--color-primary);
		box-shadow: 0 0 15px #ffa726;
		transition: all 500ms;
	}
	input:hover {
		transform: scale(0.9);
		box-shadow: 0 0 7px #ff6d00;
	}
</style>
</head>
<body>
	<div>
		<h1>Welcome User!</h1>
		<form action="/getResult" method="POST">
			<input type="submit" value="Get Result"/>
		</form>
	</div>

</body>
</html>