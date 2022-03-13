<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- YOUR own local JS -->
<script type="text/javascript" src="js/app.js"></script>

</head>
<body>
	<div class="container">
	<div class="row justify-content-center">
	<div class= "col-9">
	<h1 style="text-align: center; color: blue;"><c:out value="${date}"></c:out></h1>
	</div>
	</div>
	</div>
</body>
</html>