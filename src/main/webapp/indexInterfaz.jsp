<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estilos.css" type="text/css" />
        <link rel="stylesheet" href="css/font.css">
        <link rel="icon" href="img/favicon.ico" />
        <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
         <title>LBRKICKZ</title>
    </head>
    <body>
         <!--Barra de navegación-->
         <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
       
    <section id="global">
         <!--Carrousel-->
        <jsp:include page="/WEB-INF/paginas/comunes/carrusel.jsp"/>
        <section class="contenido">
            <!--QUIÉNES SOMOS?-->
           
            <!--SECCIÓN UNO--CATEGORÍAS-->
            <section id="title-cards"  >
                <div class="title-cards">
		<h2>LO MÁS NUEVO</h2>
	</div>
<div class="container-card">
	
<div class="card">
	<figure>
		<img src="img/jordan1ow.webp">
	</figure>
	<div class="contenido-card">
		<h3>JORDAN 1</h3>
		<p>El Air Jordan 1 es una de las zapatillas más vendidas de Nike en relación con la practica del baloncesto</p>
		<a href="mostrarProductos.jsp">COMPRAR</a>
	</div>
</div>
<div class="card">
	<figure>
		<img src="img/af1xd.webp">
	</figure>
	<div class="contenido-card">
		<h3>AIR FORCE 1</h3>
		<p>El Air Force 1, diseñado por Bruce Kilgore y lanzado en 1982, fue el primer calzado de básquetbol en contar con tecnología Nike Air, lo que revolucionó el juego y la cultura del calzado para siempre.</p>
		<a href="mostrarProductos.jsp">COMPRAR</a>
	</div>
</div>
<div class="card">
	<figure>
		<img src="img/yeezy1.webp">
	</figure>
	<div class="contenido-card">
		<h3>YEEZY</h3>
		<p>La zapatilla que ha definido un década, la Yeezy Boost es, sin duda, el diseño más triunfador de Kanye West para Adidas.</p>
		<a href="mostrarProductos.jsp">COMPRAR</a>
	</div>
</div>
</div>
            </section>

            <!--CARROUSEL CON BANNERS-->
             <div class="social-bar">
    <a href="https://www.facebook.com" class="icon icon-facebook" target="_blank"></a>
    <a href="https://twitter.com" class="icon icon-twitter" target="_blank"></a>
    <a href="https://www.youtube.com" class="icon icon-youtube" target="_blank"></a>
    <a href="https://www.instagram.com" class="icon icon-instagram" target="_blank"></a>
  </div>
                
          
    

            <!--Segunda sección-Marcas-->
           
        <!--Footer-->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        
        </section>
        
        <!--Modal Login-->
        <jsp:include page="/WEB-INF/paginas/comunes/login.jsp"/>
          <!-- Agregar cliente MODAL -->
          <jsp:include page="/WEB-INF/paginas/usuario/agregarUsuario.jsp"/>

    </body>
</html>
