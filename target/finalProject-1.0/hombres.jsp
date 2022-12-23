<%-- 
    Document   : hombres
    Created on : 24 nov 2022, 16:01:57
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<html>
    <head>
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
          <title>Hombres</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
    <!--Carrousel-->
    <section id="global">
  <h1>HOMBRES</h1>
      <div class="container">
        <div class="item">
          <a href="hombres/adidasforumlow.html"><img src="img/adidas.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/adidasforumlow.html">
              <h3>ADIDAS FORUM LOW</h3>
              <p>$3,599 MXN </p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="hombres/adidasforumhigh.html"> <img src="img/adidas_2.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/adidasforumhigh.html">
              <h3>ADIDAS FORUM HIGH</h3>
              <p>$3,899 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="hombres/adidasforumlowjelly.html"><img src="img/adidas_3.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/adidasforumlowjelly.html">
              <h3>ADIDAS FORUM LOW JELLY</h3>
              <p>$3,499 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="hombres/adidasforumhighjelly.html"><img src="img/adidas_4.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/adidasforumhighjelly.html">
              <h3>ADIDAS FORUM HIGH JELLY</h3>
              <p>$3,699 MXN</p>
            </a>
          </div>
        </div>


        <div class="item">
          <a href="hombres/adidasmidwestblack.html"><img src="img/adidas_5.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/adidasmidwestblack.html">
              <h3>ADIDAS MIDWEST BLACK</h3>
              <p>$2,699 MXN</p>
            </a>
          </div>
        </div>

        <div class="item">
          <a href="hombres/nikesbblazermid.html"> <img src="img/NIKE.png" alt="" class="item-img"></a>
          <div class="item-text">
            <a href="hombres/nikesbblazermid.html">
              <h3>NIKE SB BLAZER MID</h3>
              <p>$2,299 MXN</p>
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

