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

	<c:if test="${empty schoolClass.id}">
		<h1>Add SchoolClass</h1>
	</c:if>
	<h1>${schoolClass.id}</h1>


	<form:form action="saveSchoolClass" modelAttribute="schoolClass"
		method="POST">
		<table>
			<tbody>
				<c:if test="${not empty schoolClass.id}">
					<h1>Edit SchoolClass</h1>
					<tr>
						<td><form:hidden path="id" />
						<td />
					</tr>
				</c:if>
				<tr>
					<td><label>Level:</label></td>
					<td><form:input path="grade.level"
							readonly="${schoolClass.id!=0}" />
					<td />
				</tr>
					<c:if test="${schoolClass.id!=0}">
						<tr>
							<td><label>Branch Name:</label></td>
							<td><form:input path="grade.branch.name" readonly="${schoolClass.id!=0}"/>
							<td/>
						</tr>
					</c:if>
					<c:if test="${schoolClass.id==0}">
						<tr>
							<td><label>Branch Name:</label></td>
							<td><form:select path="grade.branch.name">
									<form:options items="${branchList}" itemValue="name"
										itemLabel="name" />
								</form:select></td>
						</tr>
					</c:if>
				<tr>
					<td><label>Capacity:</label></td>
					<td><form:input path="capacity" /></td>
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