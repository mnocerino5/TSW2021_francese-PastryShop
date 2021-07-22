<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/Homepage.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/Footer.css">
<meta charset="ISO-8859-1">
<title>Home Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/a87f00e192.js" crossorigin="anonymous"></script>
</head>
<script>
$(document).ready(function(){
	  $(".img-test-1").animate({left:'0'});
	  $(".img-test-2").animate({left:'0'});
	  $(".img-test-3").animate({left:'0'});
	  $(".home-paragrafo-1").animate({left:'0'});
	  $(".home-paragrafo-2").animate({left:'0'});
	  $(".home-paragrafo-3").animate({left:'0'});
	  });
</script>
<body>


	 <%@ include file="HeaderPastryshop.jsp" %>
<div class="container-section">
	<h1 class="home-header">La nostra storia: chi siamo</h1>
	<div class="home-item">
		<img class="img-test-1"alt="" src="./img/american-heritage-chocolate.jpg">
			<p class="home-paragrafo-1">Pastryshop nasce dall&#39idea di due ragazzi, Manuel e Pasquale, con l&#39obbiettivo di realizzare un negozio 
			online interamente dedicato ai prodotti della pasticceria, ambiente conosciuto e apprezzato da loro. 
			Questa idea è scaturita dalla mancanza di vendite online di prodotti della pasticceria nelle zone limitrofe
		 	e scarse anche nei territori regionali e nazionali. Attivi solo sul piano fisco, con la possibilità di ritirare 
		 	i prodotti presso un punto di ritiro. Abbiamo deciso di non mettere 
		 	la possibilità di spedizioni, in modo da garantire la qualità e il
		  	sapore dei prodotti.</p>
		
	
	</div>
		<h1 class="home-header">La nostra missione</h1>
		<div class="home-item">
		
			<p class="home-paragrafo-2">Il nostro obbiettivo ha un format ben preciso: <b>ZERO SPRECHI!</b> 
			Questo ci consente di combattere gli enormi sprechi che ogni giorno vengono a crearsi, 
			riuscendo ad essere una realtà sostenibile. In questo modo possiamo garantire ai nostri clienti prodotti sempre freschi. 
			Per poter portare avanti questo nostro format, lavoriamo solo sui prodotti che ci vengono ordinati.</p>
			<img class="img-test-2" alt="" src="./img/Immagine-homepage.jpg">
		</div>
		<h1 class="home-header">I nostri prodotti</h1>
		<div class="home-item">
		
			<img class = "img-test-3" alt="" src="./img/Immagine-homepage-2.jpeg">
			<p class="home-paragrafo-3">Utilizziamo solo prodotti di alta qualità, realizzando prodotti freschissimi e altamente digeribili, 
			grazie all'utilizzo di farine ai grani antichi, lievito madre 100% e panna fresca. 
			Abbiamo deciso di focalizzarci sulla produzione di Lievitati, Torte, Mignon e Prodotti da Colazione.</p>
		</div>

</div>	 
	<%@ include file="Footer.jsp" %>
</body>
</html>