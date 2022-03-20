<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo's Ninjas</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mb-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<h2 style="color: blue;"><c:out value="${dojo.name}"/> Location Ninjas</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<table class="table table-hover table-bordered table-striped" style="box-shadow: 2px 2px 2px silver;">
					<thead>
						<tr>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Age</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ninja" items="${dojo.ninjas}">
							<tr>
								<td><c:out value="${ninja.firstName}"/></td>
								<td><c:out value="${ninja.lastName}"/></td>
								<td><c:out value="${ninja.age}"/></td>
							</tr>
						</c:forEach>
					</tbody> 
				</table>
			</div>
		</div>
	</div>
</body>
</html>