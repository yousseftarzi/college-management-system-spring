<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Edit Comment</title>
</head>

<body>

<form:form action="update" modelAttribute="comment" method="POST">

			<!-- need to associate this data with post id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<form:hidden path="post.id" />
					<tr>
						<td><label>Content:</label></td>
						<td><form:input path="content" /></td>
					</tr>

					<!-- 
					
							<tr>
						<td><label>creation date(chouf updatedAt tetzed walle):</label></td>
						<td><form:input path="createdAt" /></td>
					</tr>
					 -->
			

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>


</body>
</html>
