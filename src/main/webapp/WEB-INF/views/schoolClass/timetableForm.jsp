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
		<h1>Assign Timetable - ${assignTimetableForm.schoolClass.name}</h1>
	<form:form action="assignTimetable" modelAttribute="assignTimetableForm"
		method="GET" enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<td><label>Timetable:</label></td>
					<td><input type="file" name="file"/>  
					<td />
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