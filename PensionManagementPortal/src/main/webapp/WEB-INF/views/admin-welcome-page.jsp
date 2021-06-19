<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

body {
  background-image: url('https://st4.depositphotos.com/1177973/20515/i/1600/depositphotos_205151278-stock-photo-cubes-text-pension-plan-calculator.jpg') ;
  background-repeat:no-repeat;
  background-position: center;
 background-size: cover;
 
}

</style>
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
<link rel="stylesheet" href="/css/style-admin.css">
</head>

<body>
	<div class="main-container-register">
		<%@ include file="fragments/header.jsp"%>
		<div class="section grid">
		
			<div class="content" align="justify">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
				
			<div align="center" style="margin-right: 207px;">
			<a class="btn btn-outline-success btn-lg" style="color: white; font-weight: bold;" href="/portal/showPensionerByAadhar">Find Pensioner Detail</a><br><br><br>
			<a class="btn btn-outline-success btn-lg" style="color: white; font-weight: bold;" href="/portal/showAllPensioner">Pensioner Detail</a><br><br><br>
			<a class="btn btn-outline-success btn-lg" style="color: white; font-weight: bold;" href="/portal/logout">Logout</a><br><br><br>	
				
			</div>	
			</div>
		</div>
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>

</html>