<%-- 
    Document   : accesorios
    Created on : 24 nov 2022, 16:13:40
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<html>
    <head>
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
          <title>Sucursales</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
    <!--Carrousel-->
    <section id="global">
   <h1>Accesorios</h1>
      <div class="container">
        <div class="item">

          <a href="accesorios/sticker.html"><img src="img/accesorios_1.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/sticker.html">
              <h3>STICKERS SUPREME</h3>
              <p>$149 MXN </p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="accesorios/chucky.html"> <img src="img/accesorios_2.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/chucky.html">
              <h3>SUPREME x CHUCKY DOLL</h3>
              <p>$1,899 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="accesorios/lampara.html"><img src="img/accesorios_10.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/lampara.html">
              <h3>SUPREME BELLHOM LAMP</h3>
              <p>$2,499 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="accesorios/hoodie.html"><img src="img/accesorios_7.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/hoodie.html">
              <h3>LOUIS VUITTON x SUPREME HOODIE</h3>
              <p>$140,000 MXN</p>
            </a>
          </div>
        </div>


        <div class="item">
          <a href="accesorios/juguete.html"><img src="img/accesorios_6.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/juguete.html">
              <h3>SUPREME x MEDICOM TOY KERMIT THE FROG</h3>
              <p>$9,699 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="accesorios/megafono.html"> <img src="img/accesorios_9.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="accesorios/juguete.html">
              <h3>SUPREME MEGAPHONE</h3>
              <p>$7,899 MXN</p>
            </a>
          </div>
        </div>
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
