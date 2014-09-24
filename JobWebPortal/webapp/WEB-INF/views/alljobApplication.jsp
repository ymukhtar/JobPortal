<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="includeHome.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Job Portal Welcome</title>

<script type="text/javascript">
	function nextPage(page){
		if(page<1 || page>parseInt("${totalPages}",10))
		{}
		else
		{
			var urlA="<%=request.getContextPath()%>/viewAllApplication?currentPage="+page;
			window.location.href=urlA;
		}

	}
	
	function nextPageEmp(page,id){
		if(page<1 || page>parseInt("${totalPages}",10))
		{}
		else
		{
			var urlA="<%=request.getContextPath()%>/resumeAgainstVaccancy?currentPage="+page+"&id=${vaccancyCount.vacancy.id}";
			window.location.href=urlA;
		}

	}
	
	
	
	jQuery(document).ready(function(){
		jQuery('#pageSelection').val('${currentPage}');
		
	});
	
</script>
</head>
<body>



	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	
		<div class="container">
			<div class="row">
				<h3>
				<sec:authorize access="hasRole('ROLE_JOB_SEEKER')">
					Welcome
					<sec:authentication property="principal.username" />
					as Job Seeker
				</sec:authorize>
				
				</h3>

				<p>Search from Millions of Jobs</p>
			</div>
		
		</div>

		<h3>${message}</h3><hr></hr>
		<table id="example" class="table table-striped table-bordered" cellspacing="20" width="100%">
			<thead>
				<tr>
					<th>Sr #</th>
					<th>Job Title</th>
					<th>Employer</th>
					<th>Apply Date</th>
					<th>Status</th>
					<sec:authorize access="hasRole('ROLE_EMPLOYER')">
						<th>View Resume</th>
					</sec:authorize>		
				</tr>
			<thead>
			<tbody>
			<c:forEach var="application" items="${applicationList}" varStatus="loop">
				<tr>
					<td>${loop.index}</td>
					<td>${application.vaccancy.title}</td>
					<td>${application.vaccancy.address.city}</td>
					<td>${application.applicationDate}</td>
					<c:if test="${application.status == 'R'.charAt(0)}">
						<td>RECIEVED</td>
					</c:if>
					<c:if test="${application.status == 'S'.charAt(0)}">
						<td>SHORT_LIST</td>
					</c:if>
					<c:if test="${application.status == 'X'.charAt(0)}">
						<td>REJECTED</td>
					</c:if>
					<c:if test="${application.status == 'A'.charAt(0)}">
						<td>APPROVED</td>
					</c:if>
					<sec:authorize access="hasRole('ROLE_EMPLOYER')">
						<td><a href="<c:url value="/resume/${application.seeker.personId}"/>">resume</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    
    
    		  <sec:authorize access="hasRole('ROLE_JOB_SEEKER')">
    		      <ul class="pager">
					  <li class="previous"><a onclick="nextPage('${currentPage-1}');">&larr; Previous</a></li>
					  <li>
				
						  		<select id="pageSelection" onchange="nextPage(this.value);">
									<c:forEach begin="1" end="${totalPages}" varStatus="loop">
										<option value="${loop.index}">${loop.index}</option>
									</c:forEach>
								</select>
					
						 
					  </li>
					  <li class="next"><a onclick="nextPage('${currentPage+1}');">Next &rarr;</a></li>
					</ul>
    		   </sec:authorize>
	
	
			 <sec:authorize access="hasRole('ROLE_EMPLOYER')">
			 	<ul class="pager">
			 	<li class="previous"><a onclick="nextPageEmp('${currentPage-1}');">&larr; Previous</a></li>
	  				<li>
						<select id="pageSelection" onchange="nextPageEmp(this.value);">
							<c:forEach begin="1" end="${totalPages}" varStatus="loop">
								<option value="${loop.index}">${loop.index}</option>
							</c:forEach>
						</select>
				
				    </li>
				<li class="next"><a onclick="nextPageEmp('${currentPage+1}');">Next &rarr;</a></li>
				</ul>
			 </sec:authorize>
	
		<br>

	</div>
	<footer>
		<p>&copy; Company 2014 Developed By Yasir Mukhtar & Awais Tariq</p>
	</footer>
	</div>
</body>
</html>
