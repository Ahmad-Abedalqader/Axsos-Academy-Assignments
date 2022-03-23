<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Market</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-sm mt-2">
		<div class="row justify-content-center">
			<div class="col-md-7">
				<h3>Welcome <c:out value="${currentUser.firstName}" /> <c:out value="${currentUser.lastName}" /></h3>
			</div>
			<div class="col-md-1">
				<h5>
					<a href="/logout" style="text-decoration: none;">Logout</a>
				</h5>
			</div>
		</div>
			<div class="row justify-content-center mt-4">
			<div class="col-md-6">
				<p class="h5">All projects:</p>
			</div>
			<div class="col-2 ">
				<a href="/projects/new" class="btn btn-sm btn-primary ms-5">+ New Project</a>
			</div>
		</div>
	</div>
	<div class="container mb-4 mt-2">
		<div class="row justify-content-center">
			<div class="col-8">
				<table class="table table-hover border">
					<thead>
						<tr>
							<th scope="col">Project</th>
							<th scope="col">Team Lead</th>
							<th scope="col">Due Date</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="project" items="${unInvolvedProjects}">

							<tr>
								<td>
									<a href="/projects/<c:out value="${project.id}"/>"
									style="text-decoration: none;"><c:out value="${project.title}" /></a>
								</td>
								
								<td><c:out value="${project.teamLead.firstName} ${project.teamLead.lastName}" /></td>
								
								<td>
									<fmt:formatDate pattern = "MMM dd" value = "${project.dueDate}" />
								</td>
								
								<td>
									<a href="/projects/${project.id}/join" class="btn btn-primary btn-sm me-3">Join Team</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container mb-4">
		<div class="row justify-content-center mt-4">
			<div class="col-md-8">
				<p class="h5">Your Projects:</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-8">
				<table class="table table-hover border">
					<thead>
						<tr>
							<th scope="col">Project</th>
							<th scope="col">Team Lead</th>
							<th scope="col">Due Date</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="project" items="${currentUser.projects}">
							<tr>
								<td><a href="/projects/${project.id}" style="text-decoration: none;"><c:out value="${project.title}" /></a></td>
								<td><c:out value="${project.teamLead.firstName} ${project.teamLead.lastName}" /></td>
								<td>
									<fmt:formatDate pattern = "MMM dd" value = "${project.dueDate}" />
								</td>
								<td>
								<c:if test="${project.teamLead.id == currentUser.id}">
									<a href="/projects/${project.id}/edit" class="btn btn-success btn-sm me-3">Edit</a>
								</c:if>
								<c:if test="${project.teamLead.id != currentUser.id}">
									<a href="/projects/${project.id}/leave" class="btn btn-danger btn-sm">Leave Team</a>
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>