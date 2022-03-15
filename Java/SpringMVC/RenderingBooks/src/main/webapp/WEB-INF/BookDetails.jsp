<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Receipt</title>
</head>
<body>
<h1><c:out value="${title}"></c:out></h1>
<h3>Description: <c:out value="${desc}"></c:out></h3>
<h3>Language: <c:out value="${lang}"></c:out></h3>
<h3>Number of pages: <c:out value="${pages}"></c:out></h3>

</body>
</html>