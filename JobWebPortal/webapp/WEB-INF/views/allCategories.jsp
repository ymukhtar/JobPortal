<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View All Categories</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/jumbotron.css"/>" rel="stylesheet">
	<script src="<c:url value="/resources/js/jQuery.min.js"/>"></script>
   	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">All Categories</div>
  <div class="panel-body">
    <p>...</p>
  </div>

  <!-- Table -->
  <table class="table">
  	<thead>
  		<tr>
  			<th>Category</th>
  			<th>Description</th>
  		</tr>
  	</thead>
	  	<tbody>
	    <c:forEach items = "${catList}" var="category">
	    	<tr>
	            <td><c:out value="${category.title}"/></td>
	           <td> <c:out value="${category.description}"/></td>
	         </tr>
	     </c:forEach>
	     </tbody>
  </table>
</div>
</body>
</html>