<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- <link rel="stylesheet" href="/css/main.css"/> -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row mb-2 justify-content-center">
			<div class="col-5">
				<h2>Here's Your Omikuji!</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5 mb-5"
				style="border: 2px solid black; background-color: #9fc5f8; padding: 20px;">
				<p>
					<strong> in <span><c:out value="${num}"></c:out> </span> years,
						you will live in <span><c:out value="${city}"></c:out></span> with
						<span><c:out value="${person}"></c:out></span> as your roommate, <span><c:out
								value="${hobby}"></c:out></span> for a living. The next time you see a
						<span><c:out value="${creature}"></c:out></span>, you will have
						good luck. Also, <span><c:out value="${saysomething}"></c:out></span>.
					</strong>
				</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<h5>
					<a href="/omikuji">Go Back</a>
				</h5>
			</div>
		</div>
	</div>
</body>
</html>