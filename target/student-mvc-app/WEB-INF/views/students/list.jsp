<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Students</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Section</th>
					<th>Father's Name</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>
						${student.id}
					</td>
					<td>${student.name}</td>
					<td>${student.email}</td>
					<td>${student.section}</td>
					<td>${student.fatherName}</td>
					<td>
						<spring:url value="/students/${student.id}" var="studentUrl" />
						<spring:url value="/students/${student.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${studentUrl}'">Details</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>