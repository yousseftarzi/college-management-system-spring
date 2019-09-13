<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<title>Posts list</title>
</head>

<body>

	<input type="button" value="Add Assignment"
		onclick="window.location.href='addForm'; return false;" />

	<h2>Assignments list</h2>

	<table>
		<tr>
			<th>Category</th>
			<th>Percent</th>
			<th>Points possible</th>
		</tr>

		<c:forEach var="tempAssignment" items="${assignments}">
			<c:url var="editAssignmentLink" value="/assignment/edit">
				<c:param name="assignmentId" value="${tempAssignment.id}" />
			</c:url>

			<c:url var="deleteAssignmentLink" value="/assignment/delete">
				<c:param name="assignmentId" value="${tempAssignment.id}" />
			</c:url>

			<tr>
				<td>${tempAssignment.Category}</td>
				<td>${tempAssignment.percent}</td>
				<td>${tempAssignment.pointsPossible}</td>
				<td><a href="${editAssignmentLink}">Edit</a></td>
				<td><a href="${deleteAssignmentLink}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>

</html>