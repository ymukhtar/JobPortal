<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script type="text/javascript" langauge="javascript">
	jQuery(document).ready(function(){
			jQuery('#userName').val('');
			jQuery('#password').val('');
	});
</script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value="/home"/>">Job Portal Home</a>
			<label class="navbar-brand"><strong>Add New Vacancy</strong></label>
		</div>
	</div>
	<div class="container">
		
			
		<form:form class="form-horizontal" role="form" commandName="vacancy" action="addVacancy" method="post">
			<div class="form-group">
				<label for="categoryID" class="col-sm-3 control-label">Category:</label>
				<div class="col-sm-7">
					<form:select path="category.categoryId" id="categoryID" cssClass="form-control">
						<c:forEach items="${catList}" var="category">
							<form:option value="${category.categoryId}">${category.title}</form:option>
						</c:forEach>
					</form:select>	
				</div>
				<div class="col-sm-2">
					<form:errors path="category.categoryId" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-3 control-label">Title:</label>
				<div class="col-sm-7">
					<form:input path="title" cssClass="form-control"/>
				</div>
				<div class="col-sm-2">
					<form:errors path="title" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-3 control-label">Salary Range:</label>
					<div class="col-sm-5">
						<form:input path="salaryRange" cssClass="form-control"/>
					</div>
					<div class="col-sm-2">
						<form:errors path="salaryRange" cssClass="error" />
					</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-3 control-label">Expiry Date(mm/dd/yyyy):</label>
					<div class="col-sm-7">
						<form:input path="salaryRange" type="text" cssClass="form-control"/>
					</div>
					<div class="col-sm-2">
						<form:errors path="salaryRange" cssClass="error" />
					</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-3 control-label">Description:</label>
				<div class="col-sm-7">
					<form:textarea path="description" cssClass="form-control"/>
				</div>
				<div class="col-sm-2">
					<form:errors path="category.categoryId" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="streetNo" class="col-sm-3 control-label">Street Address:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="streetNo" path="address.streetNo" placeholder="Street Address"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.streetNo" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="col-sm-3 control-label">City:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="city" path="address.city" placeholder="City"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.city" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="state" class="col-sm-3 control-label">State:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="state" path="address.state" placeholder="State"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.state" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="zip" class="col-sm-3 control-label">ZIP Code:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="zip" path="address.zip" placeholder="Zip Code"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.zip" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Job Portal 2014</p>
		</footer>
	</div>

	
</body>
</html>