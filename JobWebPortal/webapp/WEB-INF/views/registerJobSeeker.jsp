<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					JobSeeker Registration Form</strong></label>
		</div>
	</div>
	<div class="container">
		
		<form:form class="form-horizontal" enctype="multipart/form-data" role="form" commandName="jobSeeker" action="saveJobSeeker" method="post">
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
				<label for="firstName" class="col-sm-2 control-label">First Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="firstName" path="firstName" placeholder="First Name"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="firstName" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="lastName" class="col-sm-2 control-label">Last Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="lastName" path="lastName" placeholder="Last Name"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="lastName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="phoneNumber" class="col-sm-2 control-label">Phone Number:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="phoneNumber" path="phoneNumber" placeholder="Phone Number"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="phoneNumber" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="emailAddress" class="col-sm-2 control-label">Email Address:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="emailAddress" path="emailAddress" placeholder="Email Address"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="emailAddress" cssClass="error" />
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
				<label for="qualification" class="col-sm-2 control-label">Qualification:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="qualification" path="qualification" placeholder="Qualification"/>
				</div>
				<div class="col-sm-3">
					<form:errors path="qualification" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="Skills" class="col-sm-2 control-label">Skills:</label>
				<div class="col-sm-7">
					<form:textarea cssClass="form-control" id="skills" path="skills" />
				</div>
				<div class="col-sm-3">
					<form:errors path="skills" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="experience" class="col-sm-2 control-label">Experience:</label>
				<div class="col-sm-7">
					<form:textarea cssClass="form-control" id="experience" path="experience" />
				</div>
				<div class="col-sm-3">
					<form:errors path="experience" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="webFile" class="col-sm-2 control-label">Resume:</label>
				<div class="col-sm-7">
					<form:input type="file"  cssClass="form-control" name="webFile" path="webFile" />
				</div>
				<div class="col-sm-3">
					<form:errors path="webFile" cssClass="error" />
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