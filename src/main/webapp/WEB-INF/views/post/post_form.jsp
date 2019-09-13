<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>save post</title>
</head>

<body>

<form:form action="save" modelAttribute="post" method="POST">

			<!-- need to associate this data with post id yomken zeyda -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Title :</label></td>
						<td><form:input path="title" /></td>
					</tr>
				
					<tr>
						<td><label>Content:</label></td>
						<td><form:input path="content" /></td>
					</tr>

					<tr>
						<td><label>picture path:</label></td>
						<td><form:input path="picture" /></td>
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
