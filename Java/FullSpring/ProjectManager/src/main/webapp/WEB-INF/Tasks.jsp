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
<title>Project Tasks</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body style="background-color: #d5a6bd;">

	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-sm-7">
				<h3>Project: <c:out value="${project.title}"/></h3>
			</div>
			<div class="col-sm-3">
				<h5 style="vertical-align: middle;" class="ms-4">
					<a href="/dashboard" style="text-decoration: none;">Back to Dashboard</a>
				</h5>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-sm-10">
				<h5>Project Lead: <c:out value="${project.teamLead.firstName} ${project.teamLead.lastName}"/></h5>
			</div>
		</div>
	</div>	
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-sm-10">
			
				<form action="/projects/${project.id}/tasks" method="post">
					<label for="task" style="font-size: 18px;">Add a task ticket for this team:</label>
					<textarea name="task" class="form-control" id="task" rows="4"></textarea>
					<button type="submit" class="btn btn-success mt-3">Add Task</button>
				</form>			
			</div>
		</div>
	</div>
	<div class="container mt-3">
		<div class="row justify-content-center">
			<div class="col-sm-10">
				<c:forEach var="task" items="${project.tasks}">
					<h5 class="me-3 mt-3">
						Added by <c:out value="${task.addedBy.firstName}"/> at <fmt:formatDate pattern = "hh:mma MMM dd" value = "${task.createdAt}"/>
					</h5>
					<p><c:out value="${task.task}"/></p>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>


