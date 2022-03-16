<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mb-2">
		<div class="row justify-content-center">
			<div class="col-6">
				<h2 style="color: blue;">Languages</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<table class="table table-hover table-bordered table-striped" style="box-shadow: 2px 2px 2px silver;">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Creator</th>
							<th scope="col">Version</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="language" items="${allLanguages}">

							<tr>
								<td><a href="/languages/${language.id}" style="text-decoration: none;"><c:out value="${language.name}" /></a></td>
								<td><c:out value="${language.creator}" /></td>
								<td><c:out value="${language.version}" /></td>
								<td class="d-flex">
									<a href="/languages/${language.id}/edit" class="btn btn-success btn-sm me-2">Edit</a>
									<form action="/languages/${language.id}" method="post">
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
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-6">
				<h3 style="color: blue;">Add a Language:</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-6">
				<form:form action="/languages" method="post" class="border p-4"
					modelAttribute="language" style="box-shadow: 2px 2px 2px silver;">
					<div class="row mb-3">
						<form:label path="name" class="col-sm-3 col-form-label">Name: </form:label>
						<div class="col-sm-9">
							<form:errors path="name" style="color:red;" />
							<form:input class="form-control" path="name" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="creator" class="col-sm-3 col-form-label">Creator: </form:label>
						<div class="col-sm-9">
							<form:errors path="creator" style="color:red;" />
							<form:input class="form-control" path="creator" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="version" class="col-sm-3 col-form-label">Version: </form:label>
						<div class="col-sm-9">
							<form:errors path="version" style="color:red;" />
							<form:input class="form-control" path="version" />
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