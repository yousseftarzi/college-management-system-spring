<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<title>Edit Assignment</title>
</head>

<body>

	<form:form action="update" modelAttribute="assignment" method="POST">

		<!-- need to associate this data with assignment id -->
		<form:hidden path="id" />

		<table>
			<tbody>

				<tr>
					<td><label>Percent:</label></td>
					<td><form:input path="percent" /></td>
				</tr>
				
				<tr>
					<td><label>Points Possible:</label></td>
					<td><form:input path="pointsPossible" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Save" /></td>
				</tr>


			</tbody>
		</table>


	</form:form>


</body>
</html>
