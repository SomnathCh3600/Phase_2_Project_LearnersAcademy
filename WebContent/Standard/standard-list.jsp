<%@ page import="com.la.model.Standard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Class Report</h3>
			<hr>
			<div class="container text-left">
			<html>

			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Class</th>
						<th>Student Details</th>
						<th>Course Name with Assigned Teacher Details</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="standard" items="${listStandard}">

						<tr>
							<td><c:out value="${standard.stdNo}" /></td>
							<td><c:out value="${standard.student}" /></td>
							<td><c:out value="${standard.course}" /></td>
							

						<!--<td><a href="editstd?id=<c:out value='${standard.stdNo}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; | </td>  -->	
							<td><a href="deletestd?id=<c:out value='${standard.stdNo}' />"
								onclick="if(!(confirm('Are you sure you want to delete?')))return false">Delete</a></td>

						
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
