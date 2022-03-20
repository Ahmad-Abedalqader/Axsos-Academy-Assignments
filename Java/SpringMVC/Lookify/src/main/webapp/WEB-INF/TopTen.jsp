<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top ten</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-7">
				<h3 style="color: darkorange;">Top Ten Songs:</h3>
			</div>
			<div class="col-1">
				<h5 style="vertical-align: middle;">
					<a href="/dashboard" style="text-decoration: none;"> Dashboard</a>
				</h5>
			</div>
		</div>
	</div>
	<div class="container my-3">
		<div class="row justify-content-center">
			<div class="col-8">
				<table class="table table-hover table-bordered table-striped table-warning"
					style="box-shadow: 2px 2px 2px silver;">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Rating</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${topSongs}">

							<tr>
								<td><a href="/songs/${song.id}"
									style="text-decoration: none;"><c:out value="${song.title}" /></a></td>
								<td><c:out value="${song.rating}" /></td>
								<td class="d-flex"><a href="/songs/${song.id}/edit" class="btn btn-success btn-sm me-2">Edit</a>
									<form action="/songs/${song.id}" method="post">
										<input type="hidden" name="_method" value="delete">
										<button type="submit" class="btn btn-danger btn-sm offset">Delete</button>
									</form>
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