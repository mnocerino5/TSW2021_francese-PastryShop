<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pastryshop.model.*"%>
    
<%
CarrelloBean cart1 = (CarrelloBean) request.getSession().getAttribute("carrello"); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrello</title>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Carrello.css">
<link rel="stylesheet" href="./css/Footer.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="HeaderPastryshop.jsp" %>
	<% if(cart1 != null) { %>
		<div class="small-container cart-page">
		<table class="tab-cart">
			<tr>
				<th class="put-left">Prodotto</th>
				<th>Quantità</th>
				<th>Prezzo Totale</th>
			</tr>
			<% List<ProdottoBean> prodcart = cart1.getCarrello_prodotti(); 	
		   	for(ProdottoBean beancart: prodcart) {
			%>
			<tr>
				<td>
					<div class="cart-info">
						<img src="./getPicture?id=<%=beancart.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg">
						<div class= "details-left">
							<p><%=beancart.getNome_prodotto()%></p>
							<small>Price: <%=beancart.getPrezzo_prodotto()%>&euro;</small></br>
							<a href="prodotto?action=cancellaProdottoCarrello&id=<%=beancart.getId_prodotto()%>">Elimina dal carrello</a>
						</div>
					</div>
				
				</td>
				<td class="prezzo-quantita"><%=beancart.getQq()%></td>
				<td class="prezzo-quantita"><%=beancart.getTot_price_qq()%>&euro;</td>
			</tr>
			<%} %>
		</table>
		<div class="total-price">
			<table>
				<tr>
					<td>Totale</td>
					<td><%=cart1.getTotal()%>&euro;</td>
					
				</tr>
				
				<tr>
				<% if(User != null){ %>
					<td colspan="2"><a href="ordini?action=acquista"><button>ACQUISTA</button></a></td>
					<%} %>
				
				</tr>
			</table>
		</div>
	<% } else { %>
	<div class="small-container cart-page">
		<table class="tab-cart">
			<tr>
				<th class="put-left">Prodotto</th>
				<th class="put-center">Quantità</th>
				<th class="put-right">Prezzo Totale</th>
			</tr>
		</table>
		<div class="total-price">
			<table>
				<tr>
					<td>Totale</td>
					<td>0&euro;</td>
				</tr>
				<tr>
					<% if (User != null) {%>
					<td colspan="2">Aggiungi un prodotto</td>
					<%} %>
				
				</tr>	
				
			<%-- 	
			<% if(User==null) {%>
        		<a href="Login.jsp"><button>ACQUISTA</button></a>
        	<%}
        	else {%>
        		<a href="ordini?action=acquista"><button>ACQUISTA</button></a>
        	<%}%> --%>
            
       		
			</table>
			
		</div>
	</div>
		<%} %>
		
	</div>
<%-- 	<a href="./Homepage.jsp">Home</a>
		<% if(cart1 != null) { %>
		<h2>Cart</h2>
		<table border="1">
		<tr>
			<th>Nome</th>
			<th>Quantità</th>
			<th>Prezzo Totale</th>
			<th>Azione</th>
		</tr>
		<% List<ProdottoBean> prodcart = cart1.getCarrello_prodotti(); 	
		   for(ProdottoBean beancart: prodcart) {
		%>
		<tr>
			<td><%=beancart.getNome_prodotto()%></td>
			<td><%=beancart.getQq()%></td>
			<td><%=beancart.getTot_price_qq()%></td>
			<td><a href="prodotto?action=cancellaProdottoCarrello&id=<%=beancart.getId_prodotto()%>">Delete from cart</a></td>
		</tr>
		<%} %>
	</table>		
	<% } else { %>
			<h2>Cart</h2>
		<table border="1">
		<tr>
			<th>Nome</th>
			<th>Quantità</th>
			<th>Prezzo Totale</th>
			<th>Azione</th>
		</tr>
		</table>
	<%} %>

	<%if(user!=null){ %>
            <a href="ordini?action=acquista"><button>ACQUISTA</button></a>
            <%}%>

        <%if(user==null) {%><a href="Login.jsp"><button>ACQUISTA</button></a>
        
        <%}%> --%>
	<%@ include file="Footer.jsp" %>
</body>
</html>