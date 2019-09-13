<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
<title>Add Assignment</title>
</head>

<body>

	<form:form action="save" modelAttribute="assignment" method="POST">
		<table>
			<tbody>

				<tr>
					<td><label>Class:</label></td>

					<form:select path="schoolClass.id">
						<form:options items="${schoolClasses}" itemValue="id"
							itemLabel="name"></form:options>
					</form:select>
				</tr>

				<tr>
					<td><label>category:</label></td>

					<form:select path="category">
						<form:options items="${categories}" itemValue="category"
							itemLabel="category"></form:options>
					</form:select>
				</tr>
				
				<tr> 
				<td><label>Submission Date:</label> </td>
				<td><fmt:formatDate value="${assignment.submissionDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td> 
				</tr>

				<tr>
					<td><label>percent:</label></td>
					<td><form:select path="percent">
							<c:forEach var="i" begin="1" end="100">
								<option value="${i}">${i}</option>
							</c:forEach>
						</form:select></td>
				</tr>

				<tr>
					<td><label>points possible:</label></td>

					<td><form:select path="pointsPossible">
							<option value="5">5</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</form:select></td>
				</tr>

				<tr>
					<td><input type="submit" value="Save" /></td>
				</tr>


			</tbody>
		</table>

	</form:form>



</body>

</html>

