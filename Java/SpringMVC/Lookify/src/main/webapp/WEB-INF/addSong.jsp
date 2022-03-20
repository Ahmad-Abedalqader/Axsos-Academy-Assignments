<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-6">
				<h3 style="color: darkorange;">Add a Song:</h3>
			</div>
			<div class="col-1">
				<h5 style="vertical-align: middle;">
					<a href="/dashboard" style="text-decoration: none;"> Dashboard</a>
				</h5>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-7">
				<form:form action="/songs/new" method="post" class="border p-4"
					modelAttribute="song" style="box-shadow: 2px 2px 2px silver;">
					<div class="row mb-4">
						<form:label path="title" class="col-sm-4 col-form-label">Title: </form:label>
						<div class="col-sm-8">
							<form:errors path="title" style="color:red;" />
							<form:input class="form-control" path="title" />
						</div>
					</div>
					<div class="row mb-4">
						<form:label path="artist" class="col-sm-4 col-form-label">Artist: </form:label>
						<div class="col-sm-8">
							<form:errors path="artist" style="color:red;" />
							<form:input class="form-control" path="artist" />
						</div>
					</div>
					<div class="row mb-4">
						<form:label path="rating" class="col-sm-4 col-form-label">Rating(1-10): </form:label>
						<div class="col-sm-8">
							<form:errors path="rating" style="color:red;" />
							<form:input class="form-control" path="rating" />
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-3">
							<button type="submit" class="btn btn-warning btn-sm ms-5">Add Song</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>


