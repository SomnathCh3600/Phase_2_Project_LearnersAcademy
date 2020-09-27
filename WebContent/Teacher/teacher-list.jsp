<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>

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
			<h3 class="text-center">List of Teachers</h3>
			<hr>
			<div class="container text-left">
			<html>

				<a href="<%=request.getContextPath()%>/new-teacher"
					class="btn btn-success">Add Teacher</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>email</th>
						<th>Designation</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Student Student: Students) {  -->
					<c:forEach var="teacher" items="${listTeacher}">

						<tr>
							<td><c:out value="${teacher.empNo}" /></td>
							<td><c:out value="${teacher.firstName}" /></td>
							<td><c:out value="${teacher.lastName}" /></td>
							<td><c:out value="${teacher.email}" /></td>
							<td><c:out value="${teacher.designation}" /></td>

							<td><a href="edit-teacher?id=<c:out value='${teacher.empNo}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; | <a
								href="delete-teacher?id=<c:out value='${teacher.empNo}' />"
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
