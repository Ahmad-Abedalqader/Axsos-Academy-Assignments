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
	<div class="container mb-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<h2 style="color: blue;">Save Travels</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<table class="table table-hover"
					style="border: 2px solid black;">
					<thead>
						<tr>
							<th scope="col">Expense</th>
							<th scope="col">Vendor</th>
							<th scope="col">Amount</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="expense" items="${allExpenses}">

							<tr>
								<td><c:out value="${expense.getExpenseName()}" /></td>
								<td><c:out value="${expense.getVendor()}" /></td>
								<td> $<c:out value="${expense.getAmount()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6">
				<h3 style="color: blue;">Add an expense:</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<form:form action="/expenses" method="post" class="border p-4"
					modelAttribute="expense" style="box-shadow: 2px 2px 2px silver;">
					<div class="row mb-3">
						<form:label path="expenseName" class="col-sm-3 col-form-label">Expense name: </form:label>
						<div class="col-sm-9">
							<form:errors path="expenseName" style="color:red;" />
							<form:input class="form-control" path="expenseName" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="vendor" class="col-sm-3 col-form-label">Vendor: </form:label>
						<div class="col-sm-9">
							<form:errors path="vendor" style="color:red;" />
							<form:input class="form-control" path="vendor" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="amount" class="col-sm-3 col-form-label">Amount: </form:label>
						<div class="col-sm-9">
							<form:errors path="amount" style="color:red;" />
							<form:input class="form-control" path="amount" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="description" class="col-sm-3 col-form-label">Description: </form:label>
						<div class="col-sm-9">
							<form:errors path="description" style="color:red;" />
							<form:textarea class="form-control" path="description"></form:textarea>
						</div>
					</div>
					<div class="row justify-content-end">
						<div class="col-sm-2">
							<button type="submit" class="btn btn-success btn-sm offset">Submit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>