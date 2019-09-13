<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty grade.id}">
		<h1>Add Grade</h1>
	</c:if>



	<form:form action="saveGrade" modelAttribute="grade" method="POST">
		<table>
			<tbody>
				<c:if test="${not empty grade.id}">
					<h1>Edit Grade</h1>
					<tr>
						<td><form:hidden path="id" />
						<td />
					</tr>
				</c:if>
				<tr>
					<td><label>Level:</label></td>
					<td><form:input path="level" /></td>
				</tr>

				<tr>
					<td><label>Branch:</label></td>

					<td><form:select path="branch.id">
						<form:options items="${branchList}" itemValue="id" itemLabel="name"/>	
						</form:select>
					</td>

				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" /></td>
				</tr>


			</tbody>
		</table>

	</form:form>
</body>
</html>