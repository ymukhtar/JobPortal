<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html lang="en">
	<head>
		<jsp:include page="includeHome.jsp">
			<jsp:param value="a" name="a"/>
		</jsp:include>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Job Portal Welcome <sec:authentication property="principal.username" /></title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/jumbotron.css"/>" rel="stylesheet">
		<script src="<c:url value="/resources/js/jQuery.min.js"/>"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	</head>
	<body>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<h3>Welcome <sec:authentication property="principal.username" /> as Job Seeker</h3>
				<p>Search from Millions of Jobs</p>
			</div>
			<div class="row">
				<form class="form-horizontal" role="form" method="POST"  action="<c:url value='/searchJobs'/>">
					<div class="form-group form-group-lg">	
						<input type="text" name="searchType" placeholder="Job Title, Keywords or Company Name" class="form-control">
					</div>
					<div class="form-group form-group-lg">
						<input name="searchAddress" type="text" placeholder="City and State or Zip Code" class="form-control">
					</div>
					<div class="form-group form-group-lg">
						<a class="btn btn-default" role="button"><span class="glyphicon glyphicon-search"></span>&nbsp;Find Jobs</a>
						</div>
				</form>
			</div>
		</div>
	</div>
		<footer>
			<p>&copy; Company 2014 Developed By Yasir Mukhtar & Awais Tariq</p>
		</footer>
	</div>
</body>
</html>
