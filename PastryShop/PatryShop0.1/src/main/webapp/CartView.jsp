<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<% 
	Cart cart1 = (Cart) request.getSession().getAttribute("cart"); 
	System.out.println(cart1);
%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.pastryshop.*"%>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
</head>
<body>
	<a href="./product">Home</a>
		<% if(cart1 != null) { %>
		<h2>Cart</h2>
		<table border="1">
		<tr>
			<th>Name</th>
			<th>Quantità</th>
			<th>Prezzo Totale</th>
			<th>Action</th>
		</tr>
		<% List<ProductBean> prodcart = cart1.getProducts(); 	
		   for(ProductBean beancart: prodcart) {
		%>
		<tr>
			<td><%=beancart.getName()%></td>
			<td><%=beancart.getQq()%></td>
			<td><%=beancart.getTot_price()%></td>
			<td><a href="product?action=deleteC&id=<%=beancart.getCode()%>">Delete from cart</a></td>
		</tr>
		<%} %>
	</table>		
	<% } %>
	<a href="./Checkout.jsp">Checkout</a>	
</body>
</html>