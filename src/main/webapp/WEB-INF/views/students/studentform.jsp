<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${studentForm['new']}">
			<h1>Add Student</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Student</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/students" var="studentActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="studentForm" action="${studentActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="section">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Section</label>
				<div class="col-sm-10">
					<form:input type="number" path="section" class="form-control" id="section" placeholder="Section" />
					<form:errors path="section" class="control-label" />
				</div>
			</div>
		</spring:bind>
<spring:bind path="fatherName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Father's Name</label>
				<div class="col-sm-10">
					<form:input path="fatherName" class="form-control" id="fatherName" placeholder="Father's name" />
					<form:errors path="fatherName" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" rows="5" class="form-control" id="address" placeholder="address" />
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${studentForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>


</body>
</html>