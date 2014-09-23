<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="includeHome.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Job Portal Welcome Employer <sec:authentication
		property="principal.username" /></title>
<style type="text/css">
	table {
		width: 100%;
	}
	
	thead, tbody, tr, td, th {
		display: block;
	}
	
	tr:after {
		content: ' ';
		display: block;
		visibility: hidden;
		clear: both;
	}
	
	thead th {
		height: 30px;
	
		/*text-align: left;*/
	}
	
	tbody {
		height: 120px;
		overflow-y: auto;
	}
	
	thead {
		/* fallback */
		
	}
	
	tbody td, thead th {
		width: 19.2%;
		float: left;
	}
</style>
</head>
<body>
	<br/>
	<h4>
		Welcome Employer user
		<sec:authentication property="principal.username" />
	</h4>
	<h4><a class="btn btn-default" href="<c:url value="/addVacancy"/>" role="button">Add Vacancy &raquo;</a></h4>
	<div class="container">
	<h3>Current Vacancies created..</h3>
	<hr />
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Category</th>
					<th>Title</th>
					<th>Description</th>
					<th>Applications Received</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${vaccancyList}" var="vaccancy">
						<tr>
							<td><c:out value="${vaccancy.title}" /></td>
							<td><c:out value="${category.description}" /></td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>