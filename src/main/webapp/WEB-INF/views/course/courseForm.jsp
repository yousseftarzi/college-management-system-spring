<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
</head>
<body>

	<c:if test="${empty course.id}">
		<h1>Add Course</h1>
	</c:if>



	<form:form action="saveCourse" modelAttribute="course" method="POST">

		<table>
			<tbody>
				<c:if test="${not empty course.id}">
					<h1>Edit Course</h1>
					<tr>
						<td><form:hidden path="id" />
						<td />
					</tr>
				</c:if>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><label>Description:</label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><label>Credit Points:</label></td>
					<td><form:input path="creditPoints" /></td>
				</tr>
				<tr>
					<td><label>Picture:</label></td>
					<td><form:input path="picture" /></td>
				</tr>
				<tr>
					<td><label>Grade</label></td>
					<td><form:select path="grade.id">
							<c:forEach items="${gradeList}" var="grade">
								<form:option value="${grade.id}">${grade.level} - ${grade.branch.name}</form:option>
							</c:forEach>
						</form:select></td>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</tbody>
		</table>

	</form:form>
</body>
</html>