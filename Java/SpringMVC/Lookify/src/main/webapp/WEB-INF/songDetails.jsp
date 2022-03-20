<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container my-4">
		<div class="row justify-content-center">
			<div class="col-3">
				<h3 style="color: green;">Song Details:</h3>
			</div>
			<div class="col-1 mt-2">
				<h5>
					<a href="/dashboard"
						style="text-decoration: none; vertical-align: middle; font-size: 19px;">Dashboard</a>
				</h5>
			</div>
		</div>
	</div>
	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-4">
				<div class="row">
					<div class="col">
						<p>
							<strong>Song: </strong>
						</p>
					</div>
					<div class="col">
						<p>
							<c:out value="${song.title}"></c:out>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<p>
							<strong>Artist: </strong>
						</p>
					</div>
					<div class="col">
						<p>
							<c:out value="${song.artist}"></c:out>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<p>
							<strong>Rating: </strong>
						</p>
					</div>
					<div class="col">
						<p>
							<c:out value="${song.rating}"></c:out>
						</p>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-4 d-flex mt-2">
					<h5 style="vertical-align: middle;" class="me-4">
						<a href="/songs/${song.id}/edit"
							style="text-decoration: none; color: green;">Edit</a>
					</h5>
					<form action="/songs/${song.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<h5>
							<a href="#" onclick="$(this).closest('form').submit()"
								style="text-decoration: none; color: red;">Delete </a>
						</h5>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>