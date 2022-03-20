<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-10 mb-2">
				<h2 style="color: blue;">
					<c:out value="${category.name}" /> Category
				</h2>
			</div>
		</div>
		<div class="row justify-content-center">
		<div class="col-4">
			<h3 class="mb-4">Products:</h3>
			<ul>
				<c:forEach var="categ" items="${category.products}">
					<li class="h5">
						<c:out value="${categ.name}" />
					</li>
				</c:forEach>
			</ul>
		
		</div>
		<div class="col-6">
			<form action="/categories/${category.id}" method="post" class="p-4">
				<div class="row mb-3">
					<label class="col-sm-3 col-form-label">Add Product:</label>
					<div class="col-sm-9">
						<select class="form-select" name="myProd_id">
							<c:forEach var="prod" items="${nonOwnedProd}">
								<option value="${prod.id}">
									<c:out value="${prod.name}"/>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row justify-content-end">
					<div class="col-sm-2">
						<button type="submit" class="btn btn-success">Add</button>
					</div>
				</div>
			</form>
			</div>
			</div>
		</div>
</body>
</html>