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
				<div align="center">
						
					<c:if test="${processPensionResponce.processPensionStatusCode == 10}">
							<h3 style="color:green">Pension disbursement Success</h3>
					</c:if>
					<c:if test="${processPensionResponce.processPensionStatusCode == 21}">
							<h3 style="color:red">Pension amount calculated is wrong, Please redo the calculation.</h3>
					</c:if>			
					
					</div>
				<form:form modelAttribute="processPensionInput" action="processStatusCode" method="GET">
				
				<div class="form-group">
							<form:label path="aadharNumber">Aadhar Number</form:label>
							<form:input path="aadharNumber" class="form-control" id="aadharNumber"
								type="text" readonly="true" />
						</div>
				
					<div class="form-group">
							<form:label path="pensionAmount">Pension Amount</form:label>
							<form:input path="pensionAmount" class="form-control"
								id="pensionAmount" readonly="true"/>
						</div>
						
						<div class="form-group">
							<form:label path="bankCharge">Bank Charge</form:label>
							<form:input path="bankCharge" class="form-control" type="number" min="1"  id="bankCharge" required="required" />
							<form:errors path="bankCharge" />
						</div>
						
						
						<div align="center">
						
						<form:button class="btn">Submit</form:button>
						</div>
				
				
				
				
				</form:form>			
				</div>
			</div>
			
		
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>
</html>