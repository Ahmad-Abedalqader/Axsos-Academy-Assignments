<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-sm mt-2">
		<div class="row justify-content-center">
			<div class="col-md-7">
				<h2>Welcome <c:out value="${currentUser.userName}"/></h2>
			</div>
			<div class="col-md-1">
				<h5>
					<a href="/logout" style="text-decoration: none;">Logout</a>
				</h5>
			</div>
		</div>
			<div class="row justify-content-center mt-4">
			<div class="col-md-3 me-5">
				<p class="ms-4">Books from everyone's shelves:</p>
			</div>
			<div class="col-md-3">
				<h5 class="ms-4">
					<a href="/books/new" style="text-decoration: none;">+Add a book to my shelf</a>
				</h5>
			</div>
			<div class="col-md-2 ">
				<h5>
					<a href="/bookmarket" style="text-decoration: none;">Book Market</a>
				</h5>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-8">
				<table class="table table-hover border">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Title</th>
							<th scope="col">Author Name</th>
							<th scope="col">Owner</th>
							<c:forEach var="book" items="${allBooks}">
								<c:if test="${book.postedBy.id == currentUser.id}">
									<th scope="col">Actions</th>
								</c:if>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${allBooks}">

							<tr>
								<td><c:out value="${book.id}" /></td>
								<td><a href="/books/<c:out value="${book.id}"/>"
									style="text-decoration: none;"><c:out
											value="${book.title}" /></a></td>
								<td><c:out value="${book.author}" /></td>
								<td><c:out value="${book.postedBy.userName}" /></td>
								<td>
									<c:if test="${book.postedBy.id == currentUser.id}">
										<div class="col d-flex">
											<h5 style="vertical-align: middle;" class="me-2">
												<a href="/books/${book.id}/edit" class="btn btn-success btn-sm me-2">Edit</a>
											</h5>
											<form action="/books/${book.id}" method="post">
												<input type="hidden" name="_method" value="delete"> 
												<h5>
													<button type="submit" class="btn btn-danger btn-sm">Delete</button>
												</h5>
											</form>
										</div>
									</c:if>
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