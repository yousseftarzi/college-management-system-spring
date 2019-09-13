<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Branches</title>
</head>
<body>

<h3>List of Branches</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>


		<c:forEach items="${branchList}" var="branch">
			<tr>
				<c:url var="updateBranch" value="/branch/updateBranchForm">
					<c:param name="branchId" value="${branch.id}"></c:param>
				</c:url>
				<c:url var="deleteBranch" value="/branch/deleteBranch">
					<c:param name="branchId" value="${branch.id}"></c:param>
				</c:url>
				<td>${branch.name}</td>
				<td>${branch.description}</td>
				<td>${branch.picture}</td>
				<td><a href="${updateBranch}">Edit</a></td>
				<td><a href="${deleteBranch}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url value="/branch/addBranchForm" var="addBranch"></c:url>
	<a href="${addBranch}">Add Branch</a>


</body>
</html>