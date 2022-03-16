<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container my-4">
		<div class="row justify-content-center">
			<div class="col-5">
				<h2 style="color: green;">Language Details</h2>
			</div>
			<div class="col-1 mt-2">
				<h5>
					<a href="/languages" style="text-decoration: none; vertical-align: middle; font-size: 19px;">Dashboard</a>
				</h5>
			</div>
		</div>
	</div>
	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<p>
					<strong>Language Name: </strong>
					<c:out value="${language.name}"></c:out>
				</p>
				<p>
					<strong>Creator: </strong>
					<c:out value="${language.creator}"></c:out>
				</p>
				<p>
					<strong>Version: </strong>
					<c:out value="${language.version}"></c:out>
				</p>
			</div>
			<div class="row justify-content-center">
			<div class="col-6 d-flex mt-2">
				<h5 style="vertical-align: middle;" class="me-4">
					<a href="/languages/${language.id}/edit" style="text-decoration: none; color: green;">Edit</a>
				</h5>
				<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete"> 
					<h5>
						<a href="#" onclick="$(this).closest('form').submit()" style="text-decoration: none;
						color: red;">Delete </a>
					</h5>
				</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>