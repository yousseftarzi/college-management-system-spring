<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
	<title>My Posts</title>
</head>

<body>

<input type="button" value="Add Post"
				   onclick="window.location.href='addForm'; return false;"
			/>

<h2>Posts list</h2>

<table>
	<tr>
		<th> title </th>
		<th> content </th>
		<th> Creation date </th>
		<th> picture name</th>
		<th> author id</th>
		<th> </th>
	</tr>
	<c:forEach var="tempMyPost" items="${myPosts}">
	<c:url var="editFormLink" value="/post/editForm">
						<c:param name="postId" value="${tempMyPost.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/post/delete">
						<c:param name="postId" value="${tempMyPost.id}" />
					</c:url>		
		<tr>
		<td> ${tempMyPost.title}</td>
		<td> ${tempMyPost.content}</td>
		<td> ${tempMyPost.createdAt}</td>
		<td> ${tempMyPost.picture}</td>
		<td> ${tempMyPost.author.firstName} </td>
		<td>
							<!-- display the update link -->
							<a href="${editFormLink}">Edit</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">Delete</a>
						</td>
		</tr>
	</c:forEach>	
	
</table>


</body>

</html>