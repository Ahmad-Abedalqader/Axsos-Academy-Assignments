<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- <link rel="stylesheet" href="/css/main.css"/> -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<div class="row justify-conten-center">
<div class="col">
<h2>You have visited <a href="/">counter.dojo.com </a> <c:out value=" ${count}"></c:out> times. </h2>
<h2><a href="/">Test another visit?</a></h2>
</div>
</div>
</div>
</body>
</html>