<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import=" java.util.* ,pastryshop.model.* "%>

<%
	Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");
	
	
	if(ordini == null) {
	response.sendRedirect("/PatryShop0.2/ordinipage");	
	return;
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordini</title>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Footer.css">
<link rel="stylesheet" href="./css/Ordine.css">
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<%@ include file="HeaderPastryshop.jsp" %>
<div class = "content-order">
	
	<h1 class = "title-order"> Ordini Effettuati </h1>
	<div class = "tab-order">
		<table class = tab-order-tot>
			<tr>
				<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
				<th> Numero ordine</th>  
				<%} %>	
				<th> Prezzo totale ordine </th>
            	<th> Quantità prodotti dell'ordine </th>
            	<th> Stato dell'ordine </th>
            	<th> Data ordine effetuato </th>
            	<th> Data ordine concluso </th>
            	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
            	<th> Id utente </th>
            	<%} %>	
            	<th> Dettaglio Ordine </th>
			</tr>
			
			<%
            if (ordini != null && ordini.size() != 0) {
                Iterator<?> it = ordini.iterator();
                while (it.hasNext()) {
                    OrdiniBean bean = (OrdiniBean) it.next();
     	    %>
			
			<tr>
				<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
            	<td data-label = "Numero ordine" > <%=bean.getId_ordini()%> </td>
            	<%} %>
            	<td data-label = "Prezzo totale ordine"> <%=bean.getPrezzo_ordini()%> </td>
            	<td data-label = "Quantità prodotti dell'ordine">  <%=bean.getQuantit_ordini()%> </td>
            	<td data-label = "Stato dell'ordine"> <%=bean.getStato_ordini()%> </td>
            	<td data-label = "Data ordine effetuato"> <%=bean.getData_eff_ordini()%> </td>
            	<td data-label = "Data ordine concluso"> <%=bean.getData_conc_ordini()%> </td>
            	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
            	<td data-label = "Id utente"> <%=bean.getId_utente()%> </td>
            	<%} %>
            	<td data-label = "Dettaglio Ordine"> <a href="ordini?action=leggi&id=<%=bean.getId_ordini()%>">Dettagli</a><br></td>
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
        	

        	<% if (User!=null && User.getRuolo().equalsIgnoreCase("Admin")) {%>
        	<div class="admin-table">
			<h2>Modifica Stato e data fine</h2>
			<form action="ordini" method="post">
				<input type="hidden" name="action" value="modificaordine">
				<label for="id">IdOrdine</label><br>
				<input type="number" name="id" required><br>
				<br>
				<select id="stato" name="stato">
					<option value = "0">Seleziona lo stato</option>
					<option value ="Completato">Completato</option>
				</select> <br>
				<br>
				<input type="submit" value="Modifica">
			</form>
			</div>
			<%} %>	
       	
		
	</div> 

</div>
	

<%@ include file="Footer.jsp" %>
	


</body>
</html>