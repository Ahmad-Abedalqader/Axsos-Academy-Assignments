<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-sm-4">
				<h2 style="color: green;">Edit Language:</h2>
			</div>
			<div class="col-sm-2 d-flex mt-2">
				<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete"> 
					<h5>
						<a href="#" onclick="$(this).closest('form').submit()" style="text-decoration: none;
						color: red;">Delete </a>
					</h5>
				</form>
				<h5 style="vertical-align: middle;" class="ms-3">
					<a href="/languages" style="text-decoration: none;"> Dashboard</a>
				</h5>
			</div>
		</div>
	</div>

	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<form:form action="/languages/${language.id}" method="post"
					class="border p-4" modelAttribute="language"
					style="box-shadow: 2px 2px 2px silver;">
					<input type="hidden" name="_method" value="put">
					<div class="row mb-3">
						<form:label path="name" class="col-sm-3 col-form-label">Language: </form:label>
						<div class="col-sm-9">
							<form:errors path="name" style="color:red;" />
							<form:input class="form-control" path="name"/>
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="creator" class="col-sm-3 col-form-label">Creator: </form:label>
						<div class="col-sm-9">
							<form:errors path="creator" style="color:red;" />
							<form:input class="form-control" path="creator" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="version" class="col-sm-3 col-form-label">Version: </form:label>
						<div class="col-sm-9">
							<form:errors path="version" style="color:red;" />
							<form:input class="form-control" path="version" />
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-2">
							<button type="submit" class="btn btn-success btn-sm">Submit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>