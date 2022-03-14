<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<header>
        <p>Your Gold:</p>
        <p class="gold"><c:out value="${gold}"></c:out></p>
    </header>
    <main>
        <div>
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="/Gold/formProcess" method="post" >
                <input type="hidden" name="which" value="farm">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="/Gold/formProcess" method="post">
                <input type="hidden" name="which" value="cave">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="/Gold/formProcess" method="post">
                <input type="hidden" name="which" value="house">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>Quest</h2>
            <p>(earns/loose 0-50 golds)</p>
            <form action="/Gold/formProcess" method="post">
                <input type="hidden" name="which" value="quest">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
    </main>
    <footer>
        <p>Activities:</p>
        <section>
        	<c:forEach var="act" items="${activity}">
	        	<c:if test="${act.contains('Earned')}">
	    			<p style="color: #55a000;"><c:out value="${act}"/></p>
	    		</c:if>
	    		<c:if test="${act.contains('Lost')}">
	    			<p style="color: red;"><c:out value="${act}"/></p>
	    		</c:if>
		    </c:forEach>
        </section>
    </footer>
	
</body>
</html>