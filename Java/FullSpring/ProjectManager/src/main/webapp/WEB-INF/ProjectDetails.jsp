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
<title>Project Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-7">
				<h2>Project Details</h2>
			</div>
			<div class="col-3">
				<h5 style="vertical-align: middle;" class="ms-5">
					<a href="/dashboard" style="text-decoration: none;">Back to Dashboard</a>
				</h5>
			</div>
		</div>
	</div>	
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-10">
				<p>
					<span class="h5 me-5">Project:</span>
					<span><c:out value="${project.title}"/></span>
				</p>
				<p>
					<span class="h5 me-5">Description:</span>
					<span><c:out value="${project.description}"/></span>
				</p>				
				<p>
					<span class="h5 me-5">Due date:</span>
					<span><fmt:formatDate pattern = "d/M/yyyy" value = "${project.dueDate}"/></span>
				</p>
				<c:if test="${currentUser.projects.contains(project)}">
				<h5 style="vertical-align: middle;" class="mt-4">
					<a href="/projects/2/tasks" style="text-decoration: none;">See Tasks!</a>
				</h5>
				</c:if>
				
				<c:if test="${project.teamLead.id == currentUser.id}">
					<div class="row justify-content-end">
						<div class="col-1">
							<a href="/projects/${project.id}/edit" class="btn btn-success me-3">Edit</a>
						</div>
						<div class="col-2">
						<form action="/projects/${project.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<h5>
								<button type="submit" class="btn btn-danger">Delete Project</button>
							</h5>
						</form>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>


