<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>

<h1 class="welcome">Welcome ${loggedInUser.firstName } ${loggedInUser.lastName }</h1>
<div class="table_container">

<h2 class="instates_text">Here are some of the events in your state: </h2>

<table class="table">
<thead class="table_head">
<tr class="table_head_row">
<th class="table_head_title">Name</th>
<th class="table_head_title">Date</th>
<th class="table_head_title">Location</th>
<th class="table_head_title">State</th>
<th class="table_head_title">Host</th>
<th class="table_head_title">Actions/Status</th>
</tr>
</thead>

<tbody class="table_body">
<c:forEach items="${instates}" var="e">
<tr class="table_body_row">
<td class="table_body_data"><a class="table_body_data_name_link" href="/events/${e.id}">${e.name}</a></td>
<td class="table_body_data">On Progress</td>
<td class="table_body_data">${e.location}</td>
<td class="table_body_data">${e.state}</td>
<td class="table_body_data">${e.planner.firstName}</td>
<td class="table_body_data_actions">



<c:choose>
<c:when test="${e.planner.id == user }">
<a class="table_body_data_actions_link" href="/events/deletePage/${e.id}">Delete</a>
<a class="table_body_data_actions_link" href="/events/editPage/${e.id}">Edit</a>
</c:when>
<c:otherwise>
	<c:choose>
	<c:when test="${ e.joinners.contains(loggedInUser) }">
		<a class="table_body_data_actions_link" href="">Cancel</a>
	</c:when>
	
	<c:otherwise>
		<a class="table_body_data_actions_link" href="/userJoinEvent/${e.id}">Join</a>
	</c:otherwise>
	</c:choose>
</c:otherwise>

</c:choose>
</td>



</tr>
</c:forEach>

</tbody>
</table>

</div>


<div class="table_container">

<h2>Here are some of the events out of the states: </h2>

<table class="table">
<thead class="table_head">
<tr class="table_head_row">
<th class="table_head_title">Name</th>
<th class="table_head_title">Date</th>
<th class="table_head_title">Location</th>
<th class="table_head_title">State</th>
<th class="table_head_title">Host</th>
<th class="table_head_title">Actions/Status</th>
</tr>
</thead>

<tbody class="table_body">
<c:forEach items="${outOfStates}" var="e">
<tr class="table_body_row">
<td class="table_body_data"><a class="table_body_data_name_link" href="/events/${e.id}">${e.name}</a></td>
<td class="table_body_data">On Progress</td>
<td class="table_body_data">${e.location}</td>
<td class="table_body_data">${e.state}</td>
<td class="table_body_data">${e.planner.firstName}</td>
<td class="table_body_data_actions">

<c:choose>

	<c:when test="${e.planner.id == user}">
	<a class="table_body_data_actions_link" href="/events/deletePage/${e.id}">Delete</a>
	<a class="table_body_data_actions_link" href="/events/editPage/${e.id}">Edit</a>
	</c:when>

<c:otherwise>

	<c:choose>
		<c:when test="${ e.joinners.contains(loggedInUser) }">
			<a class="table_body_data_actions_link" href="/userLeaveEvent/${e.id}">Cancel</a>
		</c:when>
	
		<c:otherwise>
			<a class="table_body_data_actions_link" href="/userJoinEvent/${e.id}">Join</a>
		</c:otherwise>
	</c:choose>
	
	
</c:otherwise>


</c:choose>


</td>
</tr>
</c:forEach>

</tbody>
</table>

</div>

<div class="form_container">

<h1>Create Event</h1>

<form:form action="/addEvent" method="POST" modelAttribute="event">

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
<form:errors class="form_errors" path="date"/>
<form:input class="form_input" type="date" path="date" />
</div>

<div>
<form:errors class="form_errors" path="state" />
<form:select class="form_input" path="state">
	<c:forEach items="${states}" var="state">
		<option value="${state }">${state }</option>
	</c:forEach>
</form:select>
</div>


<input class="form_submit" type="submit" value="Add Event"/>

</form:form>

</div>






</t:template>