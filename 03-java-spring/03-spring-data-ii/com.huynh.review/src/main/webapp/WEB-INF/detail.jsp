<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<link rel="stylesheet" href="/css/events.css" />
<t:template>

<h1>${e.name}</h1>
<p>Host: ${e.planner.firstName} ${e.planner.lastName}</p>
<p>Date: In progress </p>
<p>Location: ${e.location}, ${e.state}</p>
<p>People who are attending this event: ${e.joinners.size() }</p>

<table class="table">
<thead class="table_head">
<tr class="table_head_row">
<th class="table_head_title">Name</th>
<th class="table_head_title">Location</th>
</tr>
</thead>
<tbody class="table_body">
<c:forEach items="${e.joinners}" var="e">
<tr  class="table_body_row">
<td class="table_body_data">${e.firstName} ${e.lastName}</td>
<td class="table_body_data">${e.location}</td>
</tr>
</c:forEach>
</tbody>
</table>


<h1>Message Wall</h1>
<div class="message_detail">
<c:forEach items="${e.allMesagesFromEvent}" var="m">
<p><span class="user_message_from_event">${m.oneUser.firstName}</span>  says: ${m.eventMsg}</p>
</c:forEach>


</div>




<p>${error }</p>
<form action="/message/${e.id}" method="POST" class="message_form">

<textarea name="eventMsg" required placeholder="Leave a message" rows="15" cols="80"></textarea>

<input type="submit" value="Send" class="msg_submit"/>
</form>


</t:template>
