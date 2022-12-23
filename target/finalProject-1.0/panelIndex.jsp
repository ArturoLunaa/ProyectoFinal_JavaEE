
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="icon" href="img/favicon.ico" />
        <link rel="stylesheet" href="css/estilos.css" type="text/css" />
        <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
         <title>PANEL ADMINISTRATIVO LBRKICKZ</title>
    </head>
    <header>
         <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/panel/navPanel.jsp"/>
    </header>

    <body>
        <section id="container-card">
       <!--Barra de navegación-->
        <jsp:include page="/WEB-INF/paginas/panel/entidades.jsp"/>
        </section>
        <!--Footer-->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
    </body>

</html>
