<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Classes</title>
</head>
<body>

	<h3>List of Classes</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Capacity</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${schoolClassList}" var="schoolClass">
			<tr>
				<c:url var="updateSchoolClass"
					value="/schoolClass/updateSchoolClassForm">
					<c:param name="schoolClassId" value="${schoolClass.id}"></c:param>
				</c:url>
				<c:url var="deleteSchoolClass"
					value="/schoolClass/deleteSchoolClass">
					<c:param name="schoolClassId" value="${schoolClass.id}"></c:param>
				</c:url>
				<c:url var="assignTimetable" value="/schoolClass/assignTimetableForm">
					<c:param name="schoolClassId" value="${schoolClass.id}"></c:param>
				</c:url>
				<td>${schoolClass.name}</td>
				<td>${schoolClass.capacity}</td>
				<td><a href="${updateSchoolClass}">Edit</a></td>
				<td><a href="${deleteSchoolClass}">Delete</a></td>
				<td><a href="${assignTimetable}">Assign Timetable</a></td>
			</tr>
		</c:forEach>
	</table>

	<c:url value="/schoolClass/addSchoolClassForm" var="addSchoolClass"></c:url>
	<a href="${addSchoolClass}">Add Class</a>

</body>
</html>