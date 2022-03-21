<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center my-3">
			<div class="col-7">
				<h3 style="color: darkorange;"><c:out value="${book.title}"/></h3>
			</div>
			<div class="col-3">
				<h5 style="vertical-align: middle;">
					<a href="/books" style="text-decoration: none;">Back to the shelves</a>
				</h5>
			</div>
		</div>
	</div>	
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-10">
				<c:if test="${book.postedBy.id == currentUser.id}">
					<h4>
						You read <span style="color: purple;"><c:out value="${book.title}"/></span> by
						<span style="color: green;"><c:out value="${book.author}"/></span>.
					</h4>
					<h4 class="my-2">
						Here are Your thoughts:
					</h4>
				</c:if>
				<c:if test="${book.postedBy.id != currentUser.id}">
					<h4>
						<span style="color: red;"><c:out value="${book.postedBy.userName}"/></span> read
						<span style="color: purple;"><c:out value="${book.title}"/></span> by
						<span style="color: green;"><c:out value="${book.author}"/></span>.
					</h4>
					<h4 class="my-2">
						Here are <c:out value="${book.postedBy.userName}"/>'s thoughts:
					</h4>
				</c:if>
				<p><c:out value="${book.thoughts}"/></p>
				<c:if test="${book.postedBy.id == currentUser.id}">
					<h5 style="vertical-align: middle;" class="text-align-end">
						<a href="/books/${book.id}/edit" class="btn btn-success">Edit</a>
					</h5>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>


