<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Insert</h2>
	<form action="RegisterServlet" method="post">
		
		<label for="firstname">FirstName:</label><br> 
		<input name="firstname" type="text" maxlength="20" required placeholder="enter name"><br> 
		
		<label for="lastname">LastName:</label><br>
		<input name="lastname" maxlength="20"  required placeholder="enter lastname"><br>
		
		<label for="username">Username:</label><br> 
		<input name="username" type="text"  required placeholder="enter username"><br>

		<label for="password">Password:</label><br> 
		<input name="password" type="password" required placeholder="enter password"><br>

		<input type="submit" value="Add">
	</form>

</body>
</html>