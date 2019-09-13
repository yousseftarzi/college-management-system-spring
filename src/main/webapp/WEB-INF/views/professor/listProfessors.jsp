<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Professors</title>
</head>
<body>

<h3>List of Professors</h3>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach items="${professorList}" var="professor">
			<tr>
				<c:url var="updateProfessor" value="/professor/updateProfessorForm">
					<c:param name="professorId" value="${professor.id}"></c:param>
				</c:url>
				<c:url var="deleteProfessor" value="/professor/deleteProfessor">
					<c:param name="professorId" value="${professor.id}"></c:param>
				</c:url>
				<c:url var="manageCourse" value="/professor/manageCourseForm">
					<c:param name="professorId" value="${professor.id}"></c:param>
				</c:url>
				<c:url var="manageSchoolClass" value="/professor/manageSchoolClassForm">
					<c:param name="professorId" value="${professor.id}"></c:param>
				</c:url>
				<td>${professor.firstName}</td>
				<td>${professor.lastName}</td>
				<td>${professor.email}</td>
				<td>${professor.phoneNumber}</td>
				<td><a href="${updateProfessor}">Edit</a></td>
				<td><a href="${deleteProfessor}">Delete</a></td>
				<td><a href="${manageCourse}">Manage Courses</a></td>
				<td><a href="${manageSchoolClass}">Manage Classes</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url value="/professor/addProfessorForm" var="addProfessor"></c:url>
	<a href="${addProfessor}">Add Professor</a>


</body>
</html>