<%-- 
    Document   : contacto
    Created on : 24 nov 2022, 15:35:22
    Author     : artur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estilos.css" type="text/css" />
        <link rel="icon" href="img/favicon.ico" />
        <link rel="stylesheet" href="css/font.css">
         <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
          <title>Contacto</title>
    </head>
<body>
        <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
  
  <section id="global">
      
    <div id="contenedor">
      <h2>CONTÁCTANOS</h2>
      <h3>Dejanos saber que piensas y en qué podemos ayudarte</h3>


     <section class="contact">
        <div class="contact__image-wrapper">
            <img src="img/lbr4.jpeg" alt="" class="contact__image">
        </div>
        <div class="contact__right-side">
            
            <form action="" class="contact__form-wrapper">
                <div class="contact__input-line">
                    <label for="name" class="contact__label">Nombre</label>
                    <input type="text" name="name" id="name" class="contact__input">
                </div>
                <div class="contact__input-line">
                    <label for="email" class="contact__label">Email</label>
                    <input type="email" name="email" id="email" class="contact__input">
                </div>
                <div class="contact__input-line">
                    <label for="subject" class="contact__label">Asunto</label>
                    <input type="text" name="subject" id="subject" class="contact__input">
                </div>
                <div class="contact__input-line">
                    <label for="message" class="contact__label">Mensaje</label>
                    <textarea type="text" name="message" id="message" class="contact__input--textarea"></textarea>
                </div>
                <input type="submit" value="Enviar Mensaje" class="contact__submit-button">
            </form>
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
