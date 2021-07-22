
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pastryshop.model.*"%>
    
<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");

	Collection<?> prodotti_lievitati = (Collection<?>) request.getAttribute("prodotti_lievitati");
	Collection<?> prodotti_torte = (Collection<?>) request.getAttribute("prodotti_torte");
	Collection<?> prodotti_colazione = (Collection<?>) request.getAttribute("prodotti_colazione");
	Collection<?> prodotti_mignon = (Collection<?>) request.getAttribute("prodotti_mignon");
	
	if(prodotti == null) {
	response.sendRedirect("./prodotto");	
	return;
	}

	ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto");
	
	CarrelloBean cart = (CarrelloBean) request.getAttribute("carrello");
	
	System.out.println(prodotto);
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Products.css">
<link rel="stylesheet" href="./css/Footer.css">
<meta charset="ISO-8859-1">
<title>Prodotti</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
</head>
<body>
  <%@ include file="HeaderPastryshop.jsp" %>
  
  
<h1 class="title1">Lievitati</h1>

<section class="section-lievitati">
<%
			if (prodotti_lievitati != null && prodotti_lievitati.size() != 0) {
				Iterator<?> it = prodotti_lievitati.iterator();
				while (it.hasNext()) {
					ProdottoBean prodotto_temp_liev = (ProdottoBean) it.next();
		%>

	<div class="container-section">
		<div class="container-image">
			<a href="prodotto?action=leggi&id=<%=prodotto_temp_liev.getId_prodotto()%>"><img src="./getPicture?id=<%=prodotto_temp_liev.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg"></a>
		</div>
		<div class="container-nome crop">
			<h3><%=prodotto_temp_liev.getNome_prodotto()%></h3>
		</div>
		<div class="container-prezzo crop crop-override">
			<h3><%=prodotto_temp_liev.getPrezzo_prodotto()%>&euro;</h3>
		</div>
		<div class="container-add-cart crop crop-override">
			<div class="container-link">
				<a href="prodotto?action=aggiungiProdottoCarrello&id=<%=prodotto_temp_liev.getId_prodotto()%>"><i class="fas fa-shopping-cart" style="color:black; font-size:1.5rem"></i></a>
			</div>
		</div>
	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) { %>
		<div class="container-delete-cart crop crop-override">
			<a href="prodotto?action=cancella&id=<%=prodotto_temp_liev.getId_prodotto()%>">Delete</a>
			id:<%=prodotto_temp_liev.getId_prodotto()%>
		</div>
	
		<%} %>
	</div>

<%
				}
			}
			else {
		%>
			<p>No products available</p>
		<%
			}
		%>
</section>
<h1 class="title1">Torte</h1>
<section class="section-torte">
		<%
		if (prodotti_torte != null && prodotti_torte.size() != 0) {
		Iterator<?> it = prodotti_torte.iterator();
		while (it.hasNext()) {
		ProdottoBean prodotto_temp_torte = (ProdottoBean) it.next();
		%>

	<div class="container-section">
		<div class="container-image">
			<a href="prodotto?action=leggi&id=<%=prodotto_temp_torte.getId_prodotto()%>"><img src="./getPicture?id=<%=prodotto_temp_torte.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg"></a>
		</div>
		<div class="container-nome crop">
			<h3><%=prodotto_temp_torte.getNome_prodotto()%></h3>
		</div>
		<div class="container-prezzo crop crop-override">
			<h3><%=prodotto_temp_torte.getPrezzo_prodotto()%>&euro;</h3>
		</div>
		<div class="container-add-cart crop crop-override">
			<div class="container-link">
				<a href="prodotto?action=aggiungiProdottoCarrello&id=<%=prodotto_temp_torte.getId_prodotto()%>"><i class="fas fa-shopping-cart" style="color:black; font-size:1.5rem"></i></a>
			</div>
		</div>
	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) { %>
		<div class="container-delete-cart crop crop-override">
			<a href="prodotto?action=cancella&id=<%=prodotto_temp_torte.getId_prodotto()%>">Delete</a>
			id:<%=prodotto_temp_torte.getId_prodotto()%>
		</div>
	
		<%} %>
	</div>

<%
				}
			}
			else {
		%>
			<p>No products available</p>
		<%
			}
		%>
</section>

<h1 class="title1">Prodotti da Colazione</h1>
<section class="section-colazione">
		<%
		if (prodotti_colazione != null && prodotti_colazione.size() != 0) {
			Iterator<?> it = prodotti_colazione.iterator();
			while (it.hasNext()) {
				ProdottoBean prodotto_temp_colazione = (ProdottoBean) it.next();
		%>

	<div class="container-section">
		<div class="container-image">
			<a href="prodotto?action=leggi&id=<%=prodotto_temp_colazione.getId_prodotto()%>"><img src="./getPicture?id=<%=prodotto_temp_colazione.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg"></a>
		</div>
		<div class="container-nome crop">
			<h3><%=prodotto_temp_colazione.getNome_prodotto()%></h3>
		</div>
		<div class="container-prezzo crop crop-override">
			<h3><%=prodotto_temp_colazione.getPrezzo_prodotto()%>&euro;</h3>
		</div>
		<div class="container-add-cart crop crop-override">
			<div class="container-link">
				<a href="prodotto?action=aggiungiProdottoCarrello&id=<%=prodotto_temp_colazione.getId_prodotto()%>"><i class="fas fa-shopping-cart" style="color:black; font-size:1.5rem"></i></a>
			</div>
		</div>
	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) { %>
		<div class="container-delete-cart crop crop-override">
			<a href="prodotto?action=cancella&id=<%=prodotto_temp_colazione.getId_prodotto()%>">Delete</a>
			id:<%=prodotto_temp_colazione.getId_prodotto()%>
		</div>
	
		<%} %>
	</div>

<%
				}
			}
			else {
		%>
			<p>No products available</p>
		<%
			}
		%>
</section>
<h1 class="title1">Mignon</h1>
<section class="section-mignon">
		<%
		if (prodotti_mignon != null && prodotti_mignon.size() != 0) {
			Iterator<?> it = prodotti_mignon.iterator();
			while (it.hasNext()) {
				ProdottoBean prodotto_temp_mignon = (ProdottoBean) it.next();
		%>

	<div class="container-section">
		<div class="container-image">
			<a href="prodotto?action=leggi&id=<%=prodotto_temp_mignon.getId_prodotto()%>"><img src="./getPicture?id=<%=prodotto_temp_mignon.getId_prodotto()%>" onerror="this.src=./img/Logo_Errore_img.jpg"></a>
		</div>
		<div class="container-nome crop">
			<h3><%=prodotto_temp_mignon.getNome_prodotto()%></h3>
		</div>
		<div class="container-prezzo crop crop-override">
			<h3><%=prodotto_temp_mignon.getPrezzo_prodotto()%>&euro;</h3>
		</div>
		<div class="container-add-cart crop crop-override">
			<div class="container-link">
				<a href="prodotto?action=aggiungiProdottoCarrello&id=<%=prodotto_temp_mignon.getId_prodotto()%>"><i class="fas fa-shopping-cart" style="color:black; font-size:1.5rem"></i></a>
			</div>
		</div>
	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) { %>
		<div class="container-delete-cart crop crop-override">
			<a href="prodotto?action=cancella&id=<%=prodotto_temp_mignon.getId_prodotto()%>">Delete</a>
			id:<%=prodotto_temp_mignon.getId_prodotto()%>
		</div>
	
		<%} %>
	</div>

<%
				}
			}
			else {
		%>
			<p>No products available</p>
		<%
			}
		%>
</section>

	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) { %>
	<div class="admin-part">
		<div class="admin-part-pad">
		<h2>Inserisci un prodotto</h2>
		<form action="prodotto" method="post" enctype="multipart/form-data">
			<input type="hidden" name="action" value="inserire"> 
		
			<label for="name">Nome:</label><br> 
			<input name="nome" type="text" maxlength="100" required placeholder="Nome prodotto"><br> 
		
			<label for="description">Descrizione:</label><br>
			<textarea name="descrizione" maxlength="200" rows="4" required placeholder="Descrizione Prodotto"></textarea><br>
		
		
			<label for="quantity">Quantità:</label><br> 
			<input name="quantita" type="number" min="1" value="1" required><br>
		
			<label for="price">Prezzo:</label><br> 
			<input name="prezzo" type="number" min="0" value="0" required><br>
			<br>
			<select id="categoria" name="categoria">
    			<option value="0">Seleziona categoria:</option>
    			<option value="lievitati">Lievitati</option>
    			<option value="torte">Torte</option>
    			<option value="colazione">Colazione</option>
    			<option value="mignon">Mignon</option>

  			</select>
  			<br>
  				<label for="file">Foto:</label><br> 
  				<input type="file" name="foto">

			<input type="submit" value="Add"><input type="reset" value="Reset">
	</form>
	<%} %>
	</div>
	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
	<div class="admin-part-pad">
		<h2>Modifica disponibilità e prezzo prodotto</h2>
		<form action="prodotto" method="post">
			<input type="hidden" name="action" value="modificaprod">
			
			<label for="id">IdProdotto</label><br>
			<input type="number" name="id" required><br>
			<label for="price">Prezzo:</label><br> 
			<input name="prezzo" type="number" min="0" value="0" required><br>
			<label for="quantity">Quantità:</label><br> 
			<input name="quantita" type="number" min="1" value="1" required><br>
			<br>
			<input type="submit" value="Modifica">
		</form>
		<%} %>
	</div>
</div>
		<%@ include file="Footer.jsp" %>
</body>
</html>