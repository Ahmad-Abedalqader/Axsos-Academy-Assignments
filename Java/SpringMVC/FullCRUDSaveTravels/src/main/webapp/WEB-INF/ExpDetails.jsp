<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-5">
				<h2 style="color: green;">Expense Details</h2>
			</div>
			<div class="col-1">
				<h5>
					<a href="/expenses"
						style="text-decoration: none; vertical-align: middle;">Go back</a>
				</h5>
			</div>
		</div>
	</div>
	<div class="container mt-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<p>
					<strong>Expense Name: </strong>
					<c:out value="${expense.expenseName}"></c:out>
				</p>
				<p>
					<strong>Expense Description: </strong>
					<c:out value="${expense.description}"></c:out>
				</p>
				<p>
					<strong>Vendor: </strong>
					<c:out value="${expense.vendor}"></c:out>
				</p>
				<p>
					<strong>Amount Spent: </strong> 
					$<c:out value="${expense.amount}"></c:out>
				</p>
			</div>
		</div>
	</div>

</body>
</html>