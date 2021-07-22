<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./css/Footer.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Login.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="HeaderPastryshop.jsp" %>
	<div class="l-form">
		<form action="./login" method="post" class="form" onsubmit="return validate()">
			<h1 class="form_titolo">Pagina di accesso</h1>
		
			<div class="form_div">
				<input name="username" class="form__input" type="text" required placeholder=" ">
				<label for="" class="form__label">Username</label>
			</div>
			<div class="form_div">
				<input name="password" class="form__input" type="password" required placeholder=" ">
				<label for="" class="form__label">Password</label>
 			</div>
			
			<input type="submit" class="form_button" value="Accedi">
		
		</div>
	</form>
<script>
	fuction validate(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	if(username == null && password=="")
		
	}
	
</script>
<%@ include file="Footer.jsp" %>
</body>
</html>