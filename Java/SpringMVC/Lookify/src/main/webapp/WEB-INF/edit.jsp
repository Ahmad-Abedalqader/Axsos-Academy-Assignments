<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Song</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-sm-4">
				<h3 style="color: green;">Edit Song:</h3>
			</div>
			<div class="col-sm-2 d-flex mt-2">
				<form action="/songs/${song.id}" method="post">
					<input type="hidden" name="_method" value="delete"> 
					<h5>
						<a href="#" onclick="$(this).closest('form').submit()" style="text-decoration: none;
						color: red;">Delete </a>
					</h5>
				</form>
				<h5 style="vertical-align: middle;" class="ms-3">
					<a href="/dashboard" style="text-decoration: none;">Dashboard</a>
				</h5>
			</div>
		</div>
	</div>

	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<form:form action="/songs/${song.id}" method="post"
					class="border p-4" modelAttribute="song"
					style="box-shadow: 2px 2px 2px silver;">
					<input type="hidden" name="_method" value="put">
					<div class="row mb-3">
						<form:label path="title" class="col-sm-3 col-form-label">Title: </form:label>
						<div class="col-sm-9">
							<form:errors path="title" style="color:red;" />
							<form:input class="form-control" path="title"/>
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="artist" class="col-sm-3 col-form-label">Artist: </form:label>
						<div class="col-sm-9">
							<form:errors path="artist" style="color:red;" />
							<form:input class="form-control" path="artist" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="rating" class="col-sm-3 col-form-label">Rating: </form:label>
						<div class="col-sm-9">
							<form:errors path="rating" style="color:red;" />
							<form:input class="form-control" path="rating" />
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-3">
							<button type="submit" class="btn btn-success btn-sm ms-4">Edit Song</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>