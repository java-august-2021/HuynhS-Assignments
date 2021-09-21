<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<link rel="stylesheet" href="/css/events.css" />
<t:template>

<h3>You are about to delete "${event.name}" event. Do you wish to continue?</h3>

<form action="/delete/${event.id}" method="POST">

<button>Delete</button>

</form>

<a href="/events">Return</a>




</t:template>