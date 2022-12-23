<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/favicon.ico" />
        <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
         <title>Control de Pedidos</title>
    </head>
    <body>
         <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/panel/navPanel.jsp"/>
        
       
    <section id="global">
 <!--Botones de navegacion-->
        <jsp:include page="/WEB-INF/paginas/pedido/botonesNavegacionPedidos.jsp"/>
        <jsp:include page="/WEB-INF/paginas/detallePedido/botonesNavegacionDetalle.jsp"/>
        
        <!--Listado Clientes -->
        <jsp:include page="/WEB-INF/paginas/pedido/listadoPedidos.jsp"/>
        <jsp:include page="/WEB-INF/paginas/detallePedido/listadoDetallePedidos.jsp"/>
        
        <!--Footer-->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUA
        
        </section>
        

    </body>
</html>
