<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-6">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col"># Pages</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${allBooks}">
    
    <tr>
      <td><c:out value="${book.getId()}"/></td>
      <td><a href="/books/<c:out value="${book.getId()}"/>" style="text-decoration: none;"><c:out value="${book.getTitle()}"/></a></td>
      <td><c:out value="${book.getLanguage()}"/></td>
      <td><c:out value="${book.getNumberOfPages()}"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>
</div>
</div>
</body>
</html>