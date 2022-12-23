<%@ page import="datos.ProductoDaoJDBC" %>
<%@ page import="dominio.Producto" %>

<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/estilos.css" type="text/css" />
        <link rel="icon" href="img/favicon.ico" />
        <link rel="stylesheet" href="css/font.css">
        <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/nav.jsp"/>
        
        <section id="global">
              <div id="contenedor">
      <h1 class="">Nuestros Productos</h1>
              </div>
      <div class="container-card">
          <%
            ProductoDaoJDBC productoDAO = new ProductoDaoJDBC();
            for (Producto producto : productoDAO.seleccionar()) {
                out.print("<div class='card'>"
                + "<a href='producto.jsp?id=" + producto.getIdProducto() + "'>"
                + "<img src='img/" + producto.getImagen() + "'alt='' class='item-img'"
                + " height='300px' width='350px'></a>"
                + "<div class='item-text'>"
                + "<a href='hombres/adidasforumhigh.jsp'>"
                + "<h3>" + producto.getModelo() + "</h3>"
                + "<p>" + producto.getPrecio() + " MXN</p></a></div>"
                + "</div>");  
            }
           %>
    </div>
    <div class="social-bar">
    <a href="https://www.facebook.com/DevCode.la" class="icon icon-facebook" target="_blank"></a>
    <a href="https://twitter.com/DevCodela" class="icon icon-twitter" target="_blank"></a>
    <a href="https://www.youtube.com/c/devcodela" class="icon icon-youtube" target="_blank"></a>
    <a href="https://www.instagram.com/devcodela/" class="icon icon-instagram" target="_blank"></a>
  </div>

        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        </section>
        
        <jsp:include page="/WEB-INF/paginas/comunes/carrito.jsp"/>
    </body>
</html>
