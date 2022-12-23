<%-- 
    Document   : ninos
    Created on : 24 nov 2022, 16:11:40
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<html>
    <head>
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
          <title>Niños</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
    <!--Carrousel-->
    <section id="global">
  <h1>NIÑOS</h1>
      <div class="container">
        <div class="item">
          <a href="niños/bape.html"><img src="img/niños_1.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/bape.html">
              <h3>ADIDAS BAPE</h3>
              <p>$3,899 MXN </p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="niños/jordan3.html"> <img src="img/niños_2.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/jordan3.html">
              <h3>JORDAN 3 AMA MANIERE</h3>
              <p>$6,899 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="niños/zx4k.html"><img src="img/niños_3.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/zx4k.html">
              <h3>ADIDAS ZX 4K</h3>
              <p>$7,499 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="niños/badbunny.html"><img src="img/niños_4.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/badbunny.html">
              <h3>ADIDAS FORUM LOW BAD BUNNY</h3>
              <p>$4,699 MXN</p>
            </a>
          </div>
        </div>


        <div class="item">
          <a href="niños/yeezy.html"><img src="img/niños_5.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/yeezy.html">
              <h3>YEEZY 350 CREAM</h3>
              <p>$4,699 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="niños/airforce.html"> <img src="img/niños_6.jpg" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="niños/airforce.html">
              <h3>AIR FORCE 1 LUCHA LIBRE</h3>
              <p>$2,899 MXN</p>
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
