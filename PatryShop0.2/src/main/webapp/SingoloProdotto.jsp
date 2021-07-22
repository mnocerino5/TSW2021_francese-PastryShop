<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pastryshop.model.*"%>
<%
	ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto");

%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Singolo Prodotto</title>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/SingoloProdotto.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="HeaderPastryshop.jsp" %>
	<section class = "section-single">
		<div class = "content-single">
			<div class = "image-single">
				<img src="./getPicture?id=<%=prodotto.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg">
			</div>
			<div class = "paragraph-content">
				<div class = "name-single">
						<h1><%=prodotto.getNome_prodotto()%></h1>
				</div>
				<div class = "description-single">
						<p><%=prodotto.getDescrizione_prodotto()%> </p>
				</div>
				<div class ="quantity-single">
					<h2>Disponibilità : <%=prodotto.getQuantita_disponibile_prodotto()%></h2>
				
				</div>
			
				<div class = "price-and-cart">
					<div class = "price-single">
							<p><%=prodotto.getPrezzo_prodotto()%>&euro; </p>
					</div>
					<div class = "cart-single">
							<a href="prodotto?action=aggiungiProdottoCarrello&id=<%=prodotto.getId_prodotto()%>"><i class="fas fa-shopping-cart" style="color:#daa520;"></i></a>
					</div>
				</div>
			</div>		
		</div>
	</section>
</body>
</html>