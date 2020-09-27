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
			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">
			<html>

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Roll No</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>e-mail</th>
						<th>Class</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Student Student: Students) {  -->
					<c:forEach var="Student" items="${listStudent}">
					

						<tr>
							<td><c:out value="${Student.rollNo}" /></td>
							<td><c:out value="${Student.firstName}" /></td>
							<td><c:out value="${Student.lastName}" /></td>
							<td><c:out value="${Student.email}" /></td>
							<td><c:out value="${Student.standard}" /></td>
							

							<td><a href="edit?id=<c:out value='${Student.rollNo}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${Student.rollNo}' />"
								onclick="if(!(confirm('Are you sure you want to delete?')))return false">Delete</a></td>

						
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
