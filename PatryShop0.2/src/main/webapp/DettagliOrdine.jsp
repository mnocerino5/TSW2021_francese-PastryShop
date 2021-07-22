<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pastryshop.model.*"%>
<%
	Collection<?> lista_dett_ordini = (Collection<?>) request.getAttribute("dettagliordini");

%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Singolo Prodotto</title>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Footer.css">
<link rel="stylesheet" href="./css/Ordine.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="HeaderPastryshop.jsp" %>
<div class = "content-order">
	
	<h1 class = "title-order"> Ordine Selezionato </h1>
	<div class = "tab-order">
	<%
		if (lista_dett_ordini != null) {
	%>
		<table class = tab-order-tot>
			<tr>
				<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
				<th> Codice</th>  
				<%} %>	
				<th> Nome </th>
            	<th> Descrizione </th>
            	<th> Quantità </th>
            	<th> Prezzo Totale </th>
			</tr> 
			
			<%
			if (lista_dett_ordini != null && lista_dett_ordini.size() != 0) {
				Iterator<?> it = lista_dett_ordini.iterator();
				while (it.hasNext()) {
					OrdiniDettagliBean ordini_dett = (OrdiniDettagliBean) it.next();
			%>
			
			<tr>
				<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
            	<td data-label = "Codice" > <%=ordini_dett.getId_ordini()%> </td>
            	<%} %>
            	<td data-label = "Nome"> <%=ordini_dett.getNome_dett_ordini()%> </td>
            	<td data-label = "Descrizione"> <%=ordini_dett.getDescri_dett_ordini()%> </td>
            	<td data-label = "Quantità"> <%=ordini_dett.getQuantit_dett_ordini()%> </td>
            	<td data-label = "Prezzo Totale"> <%=ordini_dett.getPrezzo_tot_dett_ordini()%> </td>
        	</tr>
        
        	 <%
            	}
            } else {
       		 %>
        	<tr>
            	<td colspan="6">Non ci sono ordini</td>
        	</tr>
        	<%
            	}
        	%>
      </table>
		<%	
			}
		%>
	</div>
</div>






	<%-- <%
		if (lista_dett_ordini != null) {
	%>
	<table border="1">
		<tr>
			<th>Codice</th>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Quantità</th>
			<th>Prezzo</th>
			
		</tr>
		
		<%
			if (lista_dett_ordini != null && lista_dett_ordini.size() != 0) {
				Iterator<?> it = lista_dett_ordini.iterator();
				while (it.hasNext()) {
					OrdiniDettagliBean ordini_dett = (OrdiniDettagliBean) it.next();
		%>
		<tr>
			<td><%=ordini_dett.getId_ordini()%></td>
			<td><%=ordini_dett.getNome_dett_ordini()%></td>
			<td><%=ordini_dett.getDescri_dett_ordini()%></td>
			<td><%=ordini_dett.getQuantit_dett_ordini()%></td>
			<td><%=ordini_dett.getPrezzo_tot_dett_ordini()%></td>
		</tr>
		<%
				}
			} else {
		%>
		
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%>
	</table>
		<%	
			}
		%> --%>
		
<%@ include file="Footer.jsp" %>
</body>
</html>