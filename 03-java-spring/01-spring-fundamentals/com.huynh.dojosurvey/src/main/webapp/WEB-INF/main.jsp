<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
<link rel="stylesheet" href="style.css">

<style>
	:root {
		--color-white: #fff;
		--color-light: #bdbdbd;
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
	.form {
		width: 280px;
		height: 280px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: stretch;
		margin: auto;

	}
	.form__label:not(:first-of-type) {
		margin-top: 1vh;
		}
	.form__label {
		position: relative;
		color: var(--color-white)
		}
	.form__label::after {
		content:"*";
		font-size: 10px;
		position: absolute;
		color: var(--color-white)
		}
	.form__input, .form__select {
		outline: none;
		margin-top: 1vh;
		border: .5px solid var(--color-dark);
		border-opacity: 0.3;
		background-color: var(--color-light);
		}
	.form__textarea {
		margin-top: 1vh;
		}
	.btn {
		margin-top: 1vh;
	}
</style>

</head>
<body>


<div class="container">
	<form class="form" action="/infos" method="POST">
		<label class="form__label" for="name">Name: </label>
		<input class="form__input" type="text" name="name" required/>
		
		<label class="form__label" for="location">Location: </label>
		<select class="form__select" name="location" required>
			<option value=""></option>
			<option value="Seattle">Seattle</option>
			<option value="San-Jose">San-Jose</option>
			<option value="Burbank">Burbank</option>
		</select>
		
		<label class="form__label" for="language" required>Language: </label>
		<select class="form__select" name="language">
			<option value=""></option>
			<option value="Python">Python</option>
			<option value="JavaScripts">JavaScripts</option>
			<option value="Java">Java</option>
		</select>
		<textarea class="form__textarea" name="message" rows="5" cols="30" required></textarea>
		<input class="btn" type="submit" value="Submit"/>
	</form>
</div>


</body>
</html>