<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset= "UTF-8" >
<title>Registrazione</title>
<link rel="stylesheet" href="./css/Login.css">
<link rel="stylesheet" href="./css/Footer.css">
<link rel="stylesheet" href="./css/header.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<%@ include file="HeaderPastryshop.jsp" %>
	<div class="l-form">
		<form action="./registrazione" method="post" class="form" onsubmit="return validateInput()">
			<h1 class="form_titolo">Pagina di Registrazione</h1>
			<div class="form_div">
				<input required name="nome" class="form__input" type="text" required placeholder=" ">
				<label for="" class="form__label">Nome</label>
			</div>
			<div id ="message1">
					<p>Inserire <b>solo caratteri,</b> numeri <b>non consentiti</b></p>
				</div>
			
			<div class="form_div">
				<input required name="cognome" class="form__input" type="text" required placeholder=" ">
				<label for="" class="form__label">Cognome</label>
			</div>
			<div id ="message2">
					<p>Inserire <b>solo caratteri,</b> numeri <b>non consentiti</b></p>
				</div>	
			<div class="form_div">
				<input required name="username" class="form__input" type="text" required placeholder=" ">
				<label for="" class="form__label">Username</label>
			</div>
			<div id ="message3">
					<p>Inserire <b>solo caratteri alfanumerici</b></p>
				</div>		
			<div class="form_div">
				<input required name="password" class="form__input" type="password" required placeholder=" ">
				<label for="" class="form__label">Password</label><br>
			</div>
			<div id ="message4">
					<p>Inserire <b>solo caratteri alfanumerici</b></p>
				</div>		
			<div class="form_div">
				<input required name="email" class="form__input" type="email" required placeholder=" ">
				<label for="" class="form__label">Email</label>
			</div>
			<div id ="message5">
					<p>Inserire <b>solo domini esistenti .gmail , .live,</b></p>
				</div>		

			
				
			<input type="submit" class="form_button" value="Registrati">
		</form>
	</div>
<script>

	function checkName(inputtext){
		var name = /^[A-Za-z]+$/;
		if(inputtext.value.match(name)){
			return true;
			inputtext.focus();
		}
		else{
			return false;
		}
	}
	function checkSurname(inputtext){
		var name = /^[A-Za-z]+$/;
		if(inputtext.value.match(name)){
			return true;
			inputtext.focus();
		}
		else{
			return false;
		}
	}
	
	function UsernameAll(inputtext){
		var letters = /^[A-Za-z0-9]+$/;
		if(inputtext.value.match(letters)){
			return true;
			inputtext.focus();
			}
		else{
			return false;
			}
		}
	function checkPassword(inputtext){
		var name = /^[A-Za-z0-9]+$/;
		if(inputtext.value.match(name)){
			return true;
			inputtext.focus();
		}
		else{
			return false;
			}
	}
	function checkEmail(inputtext){
		var name = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
		if(inputtext.value.match(name)){
			return true;
			inputtext.focus();
		}
		else{
			return false;
		}
	}
	
	function validateInput(){
		// debugger;
		var valid = true;
		var name = document.getElementsByName("nome")[0];
		var surname = document.getElementsByName("cognome")[0];
		var username = document.getElementsByName("username")[0];
		var password = document.getElementsByName("password")[0];
		var email = document.getElementsByName("email")[0];
		//check name
		if(checkName(name)){
			document.getElementById("message1").style.display = "none";
		}
		else {
			valid = false;
			document.getElementById("message1").style.display = "block";
		}
	
		//check surname
		if(checkSurname(surname)){
			document.getElementById("message2").style.display= "none";
		}else{
			valid = false;
			document.getElementById("message2").style.display = "block";
		}
		
		//check username
		if(UsernameAll(username)){
			document.getElementById("message3").style.display= "none";
		}
		else{
			valid = false;
			document.getElementById("message3").style.display = "block";
		}
		//check password
		if(checkPassword(password)){
			document.getElementById("message4").style.display = "none";
		}
		else{
			valid = false;
			document.getElementById("message4").style.display = "block";
		}
		//check email
		if(checkEmail(email)){
			document.getElementById("message5").style.display = "none";
		}
		else{
			valid = false;
			document.getElementById("message5").style.display = "block";
		}
		if(valid){
			return true
		}
		return false;	
	}
	
</script>
<%@ include file="Footer.jsp" %>
</body>
</html>