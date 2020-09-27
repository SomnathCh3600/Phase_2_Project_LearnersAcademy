<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Teacher Management Application</title>

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
				<c:set var = "teacher" value = "${Teacher}"/>
				<c:if test="${teacher != null}">
					<form action="update-teacher" method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="insert-teacher" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${teacher != null}">
            			Edit Teacher
            		</c:if>
						<c:if test="${teacher == null}">
            			Add New Teacher
            		</c:if>
					</h2>
				</caption>

				<c:if test="${teacher != null}">
					<input type="hidden" name="id" value="<c:out value='${teacher.empNo}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee ID</label> <input type="text"
						value="<c:out value='${teacher.empNo}' />" class="form-control"
						name="id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Teacher First Name</label> <input type="text"
						value="<c:out value='${teacher.firstName}' />" class="form-control"
						name="fname" required="required">
				</fieldset>
				<label>Teacher Last Name</label> <input type="text"
						value="<c:out value='${teacher.lastName}' />" class="form-control"
						name="lname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Teacher email</label> <input type="text"
						value="<c:out value='${teacher.email}' />" class="form-control"
						name="email" >
				</fieldset>
				
				<fieldset class="form-group">
					<label>Designation</label> <input type="text"
						value="<c:out value='${teacher.designation}' />" class="form-control"
						name="desig">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
