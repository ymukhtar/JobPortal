<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Welcome to JobPortal</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jobPortal.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jQuery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<label class="navbar-brand"><strong>Job applied Successfully</strong></label>
		</div>
	</div>
	<div class="container">
	<c:if test="${not empty message}">
	 	<p>Message:<strong>${message}</strong>
		</p>
		<p>Click <a href="<c:url value="/home"/>">here</a> to visit home page and login</p>
	</c:if>
	</div>
</body>
</html>