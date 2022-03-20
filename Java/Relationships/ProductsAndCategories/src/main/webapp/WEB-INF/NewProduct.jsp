<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-5">
				<h3 style="color: blue;">New Product</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form:form action="/products/new" method="post" class="border p-4"
					modelAttribute="product" style="box-shadow: 2px 2px 2px silver;">
					<div class="row mb-3">
						<form:label path="name" class="col-sm-3 col-form-label">Name: </form:label>
						<div class="col-sm-9">
							<form:errors path="name" style="color:red;" />
							<form:input class="form-control" path="name" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="description" class="col-sm-3 col-form-label">Description: </form:label>
						<div class="col-sm-9">
							<form:errors path="description" style="color:red;" />
							<form:textarea class="form-control" path="description" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="price" class="col-sm-3 col-form-label">Price: </form:label>
						<div class="col-sm-9">
							<form:errors path="price" style="color:red;" />
							<form:input class="form-control" path="price" />
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-2 me-4">
							<button type="submit" class="btn btn-success">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>