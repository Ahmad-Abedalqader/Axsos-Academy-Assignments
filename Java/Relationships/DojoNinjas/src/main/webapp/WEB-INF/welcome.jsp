<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-7">
			<h1 style="text-align: center">Welcome, lets add new Dojo or Ninja</h1>
			<h4 class="mt-5" style="text-align: center">
			<a href="/dojos/new" style="text-decoration: none; margin-right: 50px;"> New Dojo</a>
			<a href="/ninjas/new" style="text-decoration: none;"> New Ninja</a>
			</h4>
			</div>
		</div>
	</div>
</body>
</html>