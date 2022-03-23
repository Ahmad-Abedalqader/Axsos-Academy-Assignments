<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a project</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-8">
				<h3>Edit Project</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-8">
				<form:form action="/projects/${project.id}" method="post" class="border p-4"
					modelAttribute="project" style="box-shadow: 2px 2px 2px silver;">
					<input type="hidden" name="_method" value="put">
					<div class="row mb-4">
						<form:label path="title" class="col-sm-4 col-form-label">Project Title: </form:label>
						<div class="col-sm-8">
							<form:errors path="title" style="color:red;" />
							<form:input class="form-control" path="title" />
						</div>
					</div>
					<div class="row mb-4">
						<form:label path="description" class="col-sm-4 col-form-label">Project Description: </form:label>
						<div class="col-sm-8">
							<form:errors path="description" style="color:red;" />
							<form:textarea class="form-control" path="description" />
							
						</div>
					</div>
					<div class="row mb-4">
						<form:label path="dueDate" class="col-sm-4 col-form-label">Due Date: </form:label>
						<div class="col-sm-8">
							<form:errors path="dueDate" style="color:red;" />
							<form:input path="dueDate" class="form-control" type="date" />
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-1">
							<a href="/dashboard" class="btn btn-danger">Cancel</a>
						</div>
						<div class="col-sm-2">
							<button type="submit" class="btn btn-warning ms-5">Edit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>


