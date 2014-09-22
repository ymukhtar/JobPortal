<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="<c:url value="/resources/jQuery.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<label class="navbar-brand"><strong>Welcome to
					Employers Registration Form</strong></label>
		</div>
	</div>
	<div class="container">
		
		<form:form class="form-horizontal" role="form" commandName="employer" action="registerEmployer" method="post">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">User Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"  path="user.userName" name="userName" placeholder="User Name"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="user.userName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-7">
					<form:input type="password" cssClass="form-control" id="password" path="user.password" placeholder="password"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="user.password" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="name" path="name" placeholder="Employer Name"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="description" path="description" placeholder="Employer Description"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="description" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="website" class="col-sm-2 control-label">URL:</label>
				<div class="col-sm-7">
					<form:input type="url" cssClass="form-control" id="website" path="website" placeholder="URL"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="website" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="phoneNumber" class="col-sm-2 control-label">Phone Number:</label>
				<div class="col-sm-7">
					<form:input type="tel" cssClass="form-control" id="phoneNumber" path="phoneNumber" placeholder="Phone Number"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="phoneNumber" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="streetNo" class="col-sm-2 control-label">Street Address:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="streetNo" path="address.streetNo" placeholder="Street Address"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.streetNo" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="col-sm-2 control-label">City:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="city" path="address.city" placeholder="City"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.city" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="state" class="col-sm-2 control-label">State:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="state" path="address.state" placeholder="State"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="address.state" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="zip" class="col-sm-2 control-label">ZIP Code:</label>
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