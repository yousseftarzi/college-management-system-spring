<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<title>Posts list</title>
</head>

<body>

	<input type="button" value="Add Post"
		onclick="window.location.href='addForm'; return false;" />
		
		<input type="button" value="My Posts"
		onclick="window.location.href='myPosts'; return false;" />

	<h2>Posts list</h2>

	<table>
		<tr>
			<th>title</th>
			<th>content</th>
			<th>Creation date</th>
			<th>picture name</th>
			<th>author id</th>
		</tr>

		<c:forEach var="tempPost" items="${posts}">
			<c:url var="showPostLink" value="/post/show/${tempPost.id}"></c:url>

			<tr>
				<td><a href="${showPostLink}"> ${tempPost.title} </a></td>
				<td>${tempPost.content}</td>
				<td>${tempPost.createdAt}</td>
				<td>${tempPost.picture}</td>
				<td>${tempPost.author.firstName}</td>
			</tr>
		</c:forEach>

	</table>


</body>

</html>