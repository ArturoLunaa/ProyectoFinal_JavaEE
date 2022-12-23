<%-- 
    Document   : mujeres
    Created on : 24 nov 2022, 16:05:12
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<html>
    <head>
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
          <title>Mujeres</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
    <!--Carrousel-->
    <section id="global">
  <h1>MUJERES</h1>
      <div class="container">
        <div class="item">
          <a href="mujeres/adidasforumhigh.html"><img src="img/adidas_mujer.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/adidasforumhigh.html">
              <h3>ADIDAS FORUM HIGH</h3>
              <p>$2,599 MXN </p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="mujeres/airforce1recycled.html"><img src="img/af1_mujer.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/airforce1recycled.html">
              <h3>AIR FORCE 1 RECYCLED</h3>
              <p>$2,899 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="mujeres/airforcejewel.html"> <img src="img/af1_mujer_2.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/airforcejewel.html">
              <h3>AIR FORCE JEWEL </h3>
              <p>$2,499 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="mujeres/nikedunklowanimal.html"><img src="img/dunk_mujer2.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/nikedunklowanimal.html">
              <h3>NIKE DUNK LOW ANIMAL</h3>
              <p>$2,699 MXN</p>
            </a>
          </div>
        </div>


        <div class="item">
          <a href="mujeres/pumalacing.html"> <img src="img/puma_m.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/pumalacing.html">
              <h3>PUMA LACING</h3>
              <p>$2,999 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="mujeres/jordan1lowmagenta.html"> <img src="img/jordan_1_mujer.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="mujeres/jordan1lowmagenta.html">
              <h3>JORDAN 1 LOW MAGENTA</h3>
              <p>$2,199 MXN</p>
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
