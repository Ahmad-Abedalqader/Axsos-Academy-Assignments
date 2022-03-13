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
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<style type="text/css">
	.col {
	justify-content: center;
	}
</style>
<body>
<div class="container">
<div class="row justify-content-center">
<div class="col-5">
<h2 class="justify-content-center">Send an Omikuji!</h2>
<form action="/omikuji/formProcess" method="post" class="border" style="padding: 10px;">
	<div class="row mb-2">
	<div class="col-sm-10">
	<select class="form-select" aria-label="Default select" name="num">
	<option selected="">Pick any number from 5 to 25</option>
	    <% for(int i = 5; i < 26; i++) { %>
        	<option value=<%= i %>><%= i %></option>
    	<% } %>
	</select>
	</div>
	</div>
  <div class="row mb-3">
    <label for="city">Enter the name of any city.</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="city" name="city">
    </div>
  </div>
  <div class="row mb-3">
    <label for="person">Enter the name of a real person</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="person" name="person">
    </div>
  </div>
  <div class="row mb-3">
    <label for="hobby">Enter professional endeavor or hobby</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="hobby" name="hobby">
    </div>
  </div>
  <div class="row mb-3">
    <label for="creature">Enter any type of living thing.</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="creature" name="creature">
    </div>
  </div>
  <div class="row mb-3">
    <label for="textarea">Enter any type of living thing.</label>
    <div class="col-sm-10">
      <textarea class="form-control" id="textarea" name="saysomething"></textarea>
    </div>
  </div>
  <div class="row mb-3">
    <div class="col-sm-10">
     	<p>Send and show a friend</p>
    </div>
  </div>
  <button type="submit" class="btn btn-success btn-sm">Send</button>
</form>
</div>
</div>
</div>
</body>
</html>