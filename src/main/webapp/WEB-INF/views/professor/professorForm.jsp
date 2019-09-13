<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Professor</title>
</head>
<body>

	<c:if test="${empty professor.id}">
		<h1>Add Professor</h1>
	</c:if>



	<form:form action="saveProfessor" modelAttribute="professor" method="POST">



		<table>
			<tbody>
				<c:if test="${not empty professor.id}">
					<h1>Edit Professor</h1>
			<tr>
				<td><form:hidden path="id"/><td/>
			</tr>
				</c:if>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
				</tr>
				
				<tr>
					<td><label>Phone Number</label></td>
					<td><form:input path="phoneNumber" /></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Add" /></td>
				</tr>


			</tbody>
		</table>

	</form:form>
</body>
</html>