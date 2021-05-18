<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
   <%
	ProductBean product = (ProductBean) request.getAttribute("product");
   	System.out.println(product);
%>
<!DOCTYPE html>
<html>
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.pastryshop.*"%>
<head>
<meta charset="ISO-8859-1">
<title>Prodotto</title>
</head>
<body>
<a href="./product">Home</a>
<a href="./CartView.jsp">Carrello</a>
<h2>Details</h2>
	<%
		if (product != null) {
	%>
	<table border="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td><%=product.getCode()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getDescription()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getQuantity()%></td>
			<td><a href="product?action=addC&id=<%=product.getCode()%>">Add to cart</a></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>