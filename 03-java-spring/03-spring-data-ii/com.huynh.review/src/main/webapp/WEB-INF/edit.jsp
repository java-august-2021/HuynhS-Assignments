<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/css/events.css" />

<t:template>



<div class="form_container">

<h1>Edit ${event.name} Event</h1>

<form:form action="/editEvent/${event.id}" method="POST" modelAttribute="event">

<form:hidden path="planner" value="${loggedInUser.id}"/>


<div class="form_wrapper">
<form:errors class="form_errors" path="name" />
<form:input class="form_input" type="text" path="name" placeholder="Name"/>

</div>


<div>
<form:errors class="form_errors" path="location" />
<form:input class="form_input" type="text" path="location" placeholder="Location"/>
</div>


<div>
<form:errors class="form_errors" path="state" />
<form:input class="form_input" type="text" path="state" placeholder="State"/>
</div>


<input class="form_submit" type="submit" value="Edit Event"/>

</form:form>

</div>

</t:template>