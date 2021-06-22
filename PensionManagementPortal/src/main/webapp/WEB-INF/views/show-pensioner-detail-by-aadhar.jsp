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
				<h1>Pensioner Details</h1>
				<div class="container">
				<c:choose>  
                    <c:when test="${empty pensionerDetail}">  
                        <h4 id="msg" style="color:red">Pensioner Details Not found. Please Enter Valid Aadhar Number</h4> 
                    </c:when>  
    
                   <c:otherwise>
                   
					<table class="table table-striped">
						<thead>
							<tr>
								
								<th>Aadhar Number:</th>
								<th>Name:</th>
								<th>DOB:</th>
								<th>Pan:</th>
								<th>Salary:</th>
								<th>Allowances</th>
								<th>Pension Type:</th>
								<th>Bank name:</th>
								<th>Account Number:</th>
								<th>Bank Type:</th>
							</tr>
						</thead>
						<tbody>
							
							
								<tr>
									<td>${pensionerDetail.aadharNumber}</td>
									<td>${pensionerDetail.name}</td>
									<td>${pensionerDetail.dateOfBirth}</td>
									<td>${pensionerDetail.pan}</td>
									<td>${pensionerDetail.salaryEarned}</td>
									<td>${pensionerDetail.allowances}</td>
									<td>${pensionerDetail.pensionType}</td>
									<td>${pensionerDetail.bankName}</td>
									<td>${pensionerDetail.accountNumber}</td>
									<td>${pensionerDetail.bankType}</td>
								<!-- 	<td><a href="pensionDetails?pensionerId=${pensionerDetails.getAadharNumber()}" style="color: red">CalCulate Pension</a></td> -->
								</tr>
								
						</tbody>
					</table>
					</c:otherwise>  
                    </c:choose>
					<br>
					<br>
					<div align="center">
						
						<a class="btn btn-primary" href="/portal/showPensionerByAadhar">Find Another Pensioner</a>
					</div>
					
				</div>
			</div>
		</div>
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>
</html>