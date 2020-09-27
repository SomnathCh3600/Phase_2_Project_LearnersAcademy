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
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${Student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${Student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Student != null}">
					<input type="hidden" name="id" value="<c:out value='${Student.rollNo}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Student First Name</label> <input type="text"
						value="<c:out value='${Student.firstName}' />" class="form-control"
						name="fname" required="required">
				</fieldset>
				<label>Student Last Name</label> <input type="text"
						value="<c:out value='${Student.lastName}' />" class="form-control"
						name="lname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student email</label> <input type="text"
						value="<c:out value='${Student.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Class</label> <input type="text"
						value="<c:out value='${Student.standard}' />" class="form-control"
						name="std">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
