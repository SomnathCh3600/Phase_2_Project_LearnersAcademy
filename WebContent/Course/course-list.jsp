<%@ page import="com.la.model.Course"%>
<%@ page import="com.la.model.Standard"%>
<%@ page import="com.la.model.Student"%>
<%@ page import="com.la.model.Teacher"%>
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
			<h3 class="text-center">List of Subjects</h3>
			<hr>
			<div class="container text-left">
			<html>

				<a href="<%=request.getContextPath()%>/new-subject"
					class="btn btn-success">Add Subject Details</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Subject ID</th>
						<th>Subject Name</th>
						<th>Class</th>
						<th>Teacher Assigned</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="subject" items="${listCourse}">

						<tr>
							<td><c:out value="${subject.couNo}" /></td>
							<td><c:out value="${subject.name}" /></td>
							<td><c:out value="${subject.std}" /></td>
							<td><c:out value="${subject.teacher}" /></td>

							<td><a href="edit-subject?id=<c:out value='${subject.couNo}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; | <a
								href="delete-subject?id=<c:out value='${subject.couNo}' />"
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
