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
<h1>Customer Name: <c:out value="${name}"></c:out></h1>
<h3>Item name: <c:out value="${item}"></c:out></h3>
<h3>Price: $<c:out value="${price}"></c:out></h3>
<h3>Description: <c:out value="${desc}"></c:out></h3>
<h3>Vendor: <c:out value="${vendor}"></c:out></h3>

</body>
</html>