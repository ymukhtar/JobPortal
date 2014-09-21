<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="<c:url value="/resources/css/jumbotron.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/jQuery.min.js"/>"></script>
<script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<label class="navbar-brand"><strong>Welcome to
					Employers Registration Form</strong></label>
		</div>
	</div>
	<div class="container">
		<br/>
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">User Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userName" name="userName" placeholder="User Name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="password" name="password" placeholder="password"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" placeholder="Employer Name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="description" name="description" placeholder="Employer Description"/>
				</div>
			</div>
			<div class="form-group">
				<label for="website" class="col-sm-2 control-label">URL:</label>
				<div class="col-sm-10">
					<input type="url" class="form-control" id="website" name="website" placeholder="URL"/>
				</div>
			</div>
			<div class="form-group">
				<label for="phoneNumber" class="col-sm-2 control-label">Phone Number:</label>
				<div class="col-sm-10">
					<input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone Number"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="streetNo" class="col-sm-2 control-label">Street Address:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="streetNo" name="streetNo" placeholder="Street Address"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="col-sm-2 control-label">City:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="city" name="city" placeholder="City"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="state" class="col-sm-2 control-label">State:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="state" name="state" placeholder="State"/>
				</div>
			</div>
			<div class="form-group">
				<label for="zip" class="col-sm-2 control-label">ZIP Code:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="zip" name="zip" placeholder="Zip Code"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
		</form>
		<footer>
			<p>&copy; Job Portal 2014</p>
		</footer>
	</div>

	
</body>
</html>