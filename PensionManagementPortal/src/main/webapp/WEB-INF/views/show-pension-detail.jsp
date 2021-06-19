<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pension Management System</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Pinyon+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/style-table.css">
<link rel="stylesheet" href="/css/style-admin.css">
</head>
<body>
	<div class="main-container-register">
		<%@ include file="fragments/header.jsp"%>
		<div class="section grid">
			<%@ include file="admin-fragments/admin-sidebar.jsp"%>
			<div class="content list-container">
				<h1>Pension Details</h1>
				
				<form:form modelAttribute="pensionDetail" action="show-pension-detail" method="GET">
				
				<div class="form-group">
							<form:label path="aadharNumber">Aadhar Number</form:label>
							<form:input path="aadharNumber" class="form-control" id="aadharNumber"
								type="text" required="required" readonly="true" />
						</div>
				
				<div class="form-group">
							<form:label path="name">Name</form:label>
							<form:input path="name" class="form-control" id="name"
								type="text" required="required" readonly="true" />
						</div>
				
					<div class="form-group">
							<form:label path="dateOfBirth">Date Of Birth</form:label>
							<form:input path="dateOfBirth" class="form-control"
								id="dateOfBirth" required="required" readonly="true" />
						</div>
						
						<div class="form-group">
							<form:label path="pan">Pan Card Number</form:label>
							<form:input path="pan" class="form-control" id="pan" required="required" readonly="true"/>
						</div>
						<div class="form-group">
							<form:label path="pensionType">Pension Type</form:label>
							<form:input path="pensionType" class="form-control" id="pensionType" required="required" readonly="true"/>
						</div>
						<div class="form-group">
							<form:label path="pensionAmount">Pension Amount</form:label>
							<form:input path="pensionAmount" class="form-control" id="pensionAmount" required="required" readonly="true"/>
						</div>
						
						<div align="center">
						 <a class="btn btn-info" href="processStatusCode?aadharNumber=${pensionDetail.getAadharNumber()}&pensionAmount=${pensionDetail.getPensionAmount()}">Continue to Pension Process</a>
						</div>
				
				
				
				
				</form:form>			
				
			</div>
		</div>
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>
</html>