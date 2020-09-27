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
				<c:set var = "subject" value = "${Course}"/>
				<c:if test="${subject != null}">
					<form action="update-subject" method="post">
				</c:if>
				<c:if test="${subject == null}">
					<form action="insert-subject" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${subject != null}">
            			Edit Subject Details
            		</c:if>
						<c:if test="${subject == null}">
            			Add New Subject Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${subject != null}">
					<input type="hidden" name="id" value="<c:out value='${subject.couNo}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Subject ID</label> <input type="text"
						value="<c:out value='${subject.couNo}' />" class="form-control"
						name="id" required="required" >
				</fieldset>

				<fieldset class="form-group">
					<label>Subject Name</label> <input type="text"
						value="<c:out value='${subject.name}' />" class="form-control"
						name="name" required="required" >
				</fieldset>

				<fieldset class="form-group">
					<label>Class ID</label> <input type="text"
						value="<c:out value='${subject.std}' />" class="form-control"
						name="cid">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Teacher ID</label> <input type="text"
						value="<c:out value='${subject.teacher}' />" class="form-control"
						name="tid">
				</fieldset>
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
