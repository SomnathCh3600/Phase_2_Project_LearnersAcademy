<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Class Management Application</title>

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
				<c:set var = "standard" value = "${Standard}"/>
				<c:if test="${standard != null}">
					<form action="updatestd" method="post">
				</c:if>
				<c:if test="${standard == null}">
					<form action="insertstd" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${standard != null}">
            			Edit Class Details
            		</c:if>
						<c:if test="${standard == null}">
            			Add New Class Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${standard != null}">
					<input type="hidden" name="id" value="<c:out value='${standard.stdNo}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Class ID</label> <input type="text"
						value="<c:out value='${standard.stdNo}' />" class="form-control"
						name="id" required="required">
				</fieldset>
				<label>Student Details</label> <input type="text"
						value="<c:out value='${standard.student}' />" class="form-control"
						name="sid" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Teacher ID</label> <input type="text"
						value="<c:out value='${standard.teacher}' />" class="form-control"
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
