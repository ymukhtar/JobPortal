<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includeHome.jsp">
	<jsp:param value="a" name="a"/>
</jsp:include>
<title>Job Portal Welcome <sec:authentication property="principal.username" /></title>
</head>
<body>
	<h3>Welcome Administrator user <sec:authentication property="principal.username" /></h3>
	<ul class="nav nav-tabs" role="tablist">
	  <li class="active"><a href="#">Home</a></li>
	  <li><a href="<c:url value="/Categories"/>">Categories</a></li>
	  <li><a href="#">Messages</a></li>
	</ul>
</body>
</html>