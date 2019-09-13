<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<title>Single Post</title>
</head>

<body>

	<h2>Single Post</h2>

	<table>
		<tr>
			<th>title</th>
			<th>content</th>
			<th>Creation date</th>
			<th>picture name</th>
			<th>author first name</th>
			<th></th>
		</tr>
		<tr>
			<td>${post.title}</td>
			<td>${post.content}</td>
			<td>${post.createdAt}</td>
			<td>${post.picture}</td>
			<td>${post.author.firstName}</td>
		</tr>
	</table>

	<form:form action="/SpringHibernate/comment/save"
		modelAttribute="comment" method="POST">

		<form:input path="content" />
		<form:hidden path="post.id" />
		<input type="submit" value="Add Comment">
	</form:form>


	<table>
		<tr>
			<th>content</th>
			<th>Creation date</th>
			<th>author name</th>
		</tr>

		<c:forEach var="tempComment" items="${post.comments}">

			<tr>
				<td>${tempComment.content}</td>
				<td>${tempComment.createdAt}</td>
				<td>${tempComment.author.firstName}</td>



				<c:set var="authorId" value="${tempComment.author.id}" scope="page" />
				<c:set var="currentUserId" value="1" scope="page" />


				<c:if test="${authorId eq currentUserId}">
					<c:out value="d5alt lel if" />

					<c:url var="editCommentLink" value="/comment/edit">
						<c:param name="commentId" value="${tempComment.id}" />
					</c:url>

					<c:url var="deleteCommentLink" value="/comment/delete">
						<c:param name="commentId" value="${tempComment.id}" />
					</c:url>

					<td>test edit</td>
					<td>test delete</td>

					<td><a href="${editCommentLink}">Edit</a></td>
					<td><a href="${deleteCommentLink}">Delete</a></td>

				</c:if>
			</tr>
		</c:forEach>

	</table>


</body>

</html>