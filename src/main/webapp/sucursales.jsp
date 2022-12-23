<%-- 
    Document   : sucursales
    Created on : 24 nov 2022, 15:55:59
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<html>
    <head>
        <link rel="icon" href="img/favicon.ico" />
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
         <link rel="stylesheet" href="css/font.css">
         <link rel="stylesheet" href="css/mapa.css" type="text/css" />
          <title>Sucursales</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
    <!--Carrousel-->
    <section id="global">
       

        <section class="contenido">
            <!--QUIÉNES Sucursals?-->
            <article class="container mt-4">
                <div class="row col-sm-12 col-md-12 col-12">
                    <div class="introduction ">
                         <div id="contenedor">
                        <h2 class="title sucursal">SUCURSALES</h2>
                    </div>
                </div>
                </div>
            </article>
            <!--sucursales-->

            <section id="categorias" class="contenedor ">
                <div class="row">

                    <div class="">
                        <p>Blvd. Jesús Reyes Heroles 302 Delegación San Buenaventura Col. Valle del Campestre, León 37150 y tambien encuentranos en Plaza Mayor local A-6</p>
                        <p>

                            <a class="boton_personalizado" href="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7441.968167197262!2d-101.69813700493519!3d21.15303169344822!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x842bbf4fbbc08015%3A0xe9d6bfe57a408ba1!2sValle%20del%20Campestre%2C%20Le%C3%B3n%2C%20Gto.!5e0!3m2!1ses-419!2smx!4v1638215377584!5m2!1ses-419!2smx">AMPLIAR MAPA</a>
                        </p>

                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7441.968167197262!2d-101.69813700493519!3d21.15303169344822!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x842bbf4fbbc08015%3A0xe9d6bfe57a408ba1!2sValle%20del%20Campestre%2C%20Le%C3%B3n%2C%20Gto.!5e0!3m2!1ses-419!2smx!4v1638215377584!5m2!1ses-419!2smx"
                            width="600" height="600" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

                    </div>

                </div>
            </section>
            <div class="social-bar">
    <a href="https://www.facebook.com/DevCode.la" class="icon icon-facebook" target="_blank"></a>
    <a href="https://twitter.com/DevCodela" class="icon icon-twitter" target="_blank"></a>
    <a href="https://www.youtube.com/c/devcodela" class="icon icon-youtube" target="_blank"></a>
    <a href="https://www.instagram.com/devcodela/" class="icon icon-instagram" target="_blank"></a>
  </div>

   <!--Footer-->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
  </section>

<!--Modal Login-->
        <jsp:include page="/WEB-INF/paginas/comunes/login.jsp"/>

  <!--Carrito-->
        <jsp:include page="/WEB-INF/paginas/comunes/carrito.jsp"/>
</body>
</html>
