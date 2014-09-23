<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
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
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/jumbotron.css"/>" rel="stylesheet">
		<script src="<c:url value="/resources/js/jQuery.min.js"/>"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    	
    	<script type="text/javascript">
    	
	    	function findJobs(){
	    		
	    		var urlA="<%=request.getContextPath()%>/JobSearch?currentPage=1&searchString="+jQuery('#searchType').val()+"&searchAddress="+jQuery('#searchAddress').val();
	    		window.location.href=urlA;
	    		
	    	}
    	
    	</script>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">JobPortal</a>
			</div>
			<div class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" role="form" method="POST"  action="<c:url value='j_spring_security_check'/>">
					<div class="form-group">
						<input type="text" name="j_username" placeholder="User Name" class="form-control">
					</div>
					<div class="form-group">
						<input name="j_password" type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<h3>Welcome to Job Portal!</h3>
				<p>Search from Millions of Jobs</p>
			</div>
			<div class="row">
				<form class="form-horizontal" role="form" method="POST"  action="<c:url value='/searchJobs'/>">
					<div class="form-group form-group-lg">	
						<input type="text" name="searchType" id="searchType" placeholder="Job Title, Keywords or Company Name" class="form-control">
					</div>
					<div class="form-group form-group-lg">
						<input name="searchAddress" type="text" id="searchAddress" placeholder="City and State or Zip Code" class="form-control">
					</div>
					<div class="form-group form-group-lg">
						<a class="btn btn-default" onclick="findJobs()" role="button"><span class="glyphicon glyphicon-search"></span>&nbsp;Find Jobs</a>
						</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Employers Register</h2>
				<p>
					<ul>
						<li>Why create an account?</li>
						<li>Reach the Right Talent</li>
						<li>Spend Less to Hire</li>
						<li>Make Hires Faster</li>
						<li>View Resumes online</li>
						<li>Get noticed by relevant candidates</li>
					</ul>
				</p>
				<p>
					<a class="btn btn-default" href="<c:url value="/registerEmployer"/>" role="button">Register &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Job Seekers Register</h2>
					<ul>
						<li>Why create an account?</li>
						<li>Follow tech Talent Communities that mirror your interests</li>
						<li>Get relevant news, jobs and a forum to connect with like-minded tech pros</li>
						<li>Post a searchable resume and get found by employers</li>
						<li>Track jobs you've already viewed and applied to</li>
						<li>Store resumes and cover letters to use with job applications</li>
					</ul>
				<p>
					<a class="btn btn-default" href="<c:url value="/registerJobSeeker"/>" role="button">Register &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Categories</h2>
				<p>
					<ul>
						<li>JAVA</li>
						<li>.NET</li>
						<li>Python</li>
					</ul>
				</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; Company 2014 Developed By Yasir Mukhtar & Awais Tariq</p>
		</footer>
	</div>
</body>
</html>
