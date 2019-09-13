<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Grades</title>
</head>
<body>

<h3>List of Grades</h3>
	<table>
		<tr>
			<th>Level</th>
			<th>Branch</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach items="${gradeList}" var="grade">
			<tr>
				<c:url var="updateGrade" value="/grade/updateGradeForm">
					<c:param name="gradeId" value="${grade.id}"></c:param>
				</c:url>
				<c:url var="deleteGrade" value="/grade/deleteGrade">
					<c:param name="gradeId" value="${grade.id}"></c:param>
				</c:url>
				<td>${grade.level}</td>
				<td>${grade.branch.name}</td>
				<td><a href="${updateGrade}">Edit</a></td>
				<td><a href="${deleteGrade}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url value="/grade/addGradeForm" var="addGrade"></c:url>
	<a href="${addGrade}">Add Grade</a>


</body>
</html>