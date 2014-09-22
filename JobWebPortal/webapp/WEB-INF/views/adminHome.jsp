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
	<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">All Categories</div>
  <div class="panel-body">
    <p>
    
    </p>
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