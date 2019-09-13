<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Class</title>
</head>
<body>

	<h3>Assign Class</h3>
	<c:if test="${not empty manageSchoolClassForm.professor.schoolClasses}">

		<ul>
			<c:forEach items="${manageSchoolClassForm.professor.schoolClasses}" var="schoolClass">
				<c:url var="unassignSchoolClass" value="/professor/unassignSchoolClass">
					<c:param name="professorId" value="${manageSchoolClassForm.professor.id}"></c:param>
					<c:param name="schoolClassId" value="${schoolClass.id}"></c:param>
				</c:url>
				<li>${schoolClass.name} - ${schoolClass.grade.level} - ${schoolClass.grade.branch.name}
				</li>
				<td><a href="${unassignSchoolClass}">Unassign SchoolClass</a></td>
			</c:forEach>
		</ul>
	</c:if>
	<form:form action="assignSchoolClass" modelAttribute="manageSchoolClassForm" method="POST" >
		<form:hidden path="professor.id" />
		<form:select path="schoolClass.id">
			<form:options items="${schoolClassList}" itemValue="id" itemLabel="name"></form:options>
		</form:select>
		<input type="submit" value="Save" />
	</form:form>

</body>
</html>