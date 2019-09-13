<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Courses</title>
</head>
<body>

<h3>List of Courses</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Description</th>
			<th>Credit Points</th>
			<th>Picture</th>
			<th>Branch</th>									
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach items="${courseList}" var="course">
			<tr>
				<c:url var="updateCourse" value="/course/updateCourseForm">
					<c:param name="courseId" value="${course.id}"></c:param>
				</c:url>
				<c:url var="deleteCourse" value="/course/deleteCourse">
					<c:param name="courseId" value="${course.id}"></c:param>
				</c:url>
				<td>${course.name}</td>
				<td>${course.grade.level}</td>
				<td>${course.description}</td>
				<td>${course.creditPoints}</td>
				<td>${course.picture}</td>
				<td>${course.grade.branch.name}</td>
				<td><a href="${updateCourse}">Edit</a></td>
				<td><a href="${deleteCourse}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url value="/course/addCourseForm" var="addCourse"></c:url>
	<a href="${addCourse}">Add Course</a>


</body>
</html>