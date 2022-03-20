<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-5">
				<h3 style="color: blue;">New Ninja</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form:form action="/ninjas/new" method="post" class="border p-4"
					modelAttribute="ninja" style="box-shadow: 2px 2px 2px silver;">
					<div class="row mb-3">
						<form:label path="dojo" class="col-sm-3 col-form-label">Dojo: </form:label>
						<div class="col-sm-9">
							<form:select path= "dojo">
								<c:forEach var="dojo" items="${allDojos}">
									<form:option value="${dojo.id}">
										<c:out value="${dojo.name}"/>
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="firstName" class="col-sm-3 col-form-label">First Name: </form:label>
						<div class="col-sm-9">
							<form:errors path="firstName" style="color:red;" />
							<form:input class="form-control" path="firstName" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="lastName" class="col-sm-3 col-form-label">last Name: </form:label>
						<div class="col-sm-9">
							<form:errors path="lastName" style="color:red;" />
							<form:input class="form-control" path="lastName" />
						</div>
					</div>
					<div class="row mb-3">
						<form:label path="age" class="col-sm-3 col-form-label">Age: </form:label>
						<div class="col-sm-9">
							<form:errors path="age" style="color:red;" />
							<form:input class="form-control" path="age" />
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