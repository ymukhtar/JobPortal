<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    		<form:form class="form-horizontal" role="form" commandName="category" action="saveCategory" method="post">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">Title:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control" id="title" path="title" placeholder="Title"/>
					</div>
					<div class="col-sm-3">
						<form:errors path="title" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Description:</label>
					<div class="col-sm-7">
						<form:input type="text" cssClass="form-control" id="description" path="description" placeholder="Description"/>
					</div>
					<div class="col-sm-3">
						<form:errors path="description" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
			</form:form>
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