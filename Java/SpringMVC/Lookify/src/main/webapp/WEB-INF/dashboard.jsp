<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon" style="color: black;"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
					<ul class="navbar-nav mb-2 mb-lg-0">
						<li class="nav-item mx-3">
							<h5>
								<a href="/songs/new" style="text-decoration: none; color: darkorange;">Add song</a>
							</h5>
						</li>
						<li class="nav-item mx-3">
							<h5>
								<a href="/search/topTen" style="text-decoration: none; color: darkorange;">Top songs</a>
							</h5>
						</li>
						<li class="nav-item mx-3">
						<form class="d-flex" action="/search" method="post">
							<input class="form-control mr-sm-2 mx-2" type="search" placeholder="Search" aria-label="Search" name="artist" style="height: 30px;">
							<button class="btn btn-outline-warning my-2 my-sm-0 btn-sm" type="submit" style="color: black;">Search</button>
						</form>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="container mb-2">
		<div class="row justify-content-center">
			<div class="col-8">
				<h3>All Songs</h3>
			</div>
		</div>
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
						<c:forEach var="song" items="${allsongs}">

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