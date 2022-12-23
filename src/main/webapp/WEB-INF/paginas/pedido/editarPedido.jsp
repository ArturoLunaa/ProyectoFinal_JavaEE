<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Editar Pedido</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="/WEB-INF/paginas/panel/navPanel.jsp"/>

        <!--Listado Clientes SOLO PARA VISUALIZACIÓN -->
        <jsp:include page="/WEB-INF/paginas/pedido/listadoPedidosVisualizacion.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControladorPedido?accion=modificar&idPedido=${pedido.idPedido}"
              method="POST" class="was-validated">

            <!--Botones de Navegacion -->
            <jsp:include page="/WEB-INF/paginas/pedido/botonesNavegacionEdicionPedidos.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Pedido</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="fecha">Fecha</label>
                                        <input type="date" class="form-control" name="fecha" required value="${pedido.fecha}">
                                    </div>
                                    <div class="form-group">
                                        <label for="estado">Estado</label>
                                        <input type="text" class="form-control" name="estado" required value="${pedido.estado}">
                                    </div>
                                    <div class="form-group">
                                        <label for="fechaEnvio">Fecha Envio</label>
                                        <input type="date" class="form-control" name="fechaEnvio" required value="${pedido.fechaEnvio}">
                                    </div>
                                    <div class="form-group">
                                        <label for="idCliente">ID Cliente</label>
                                        <input type="number" class="form-control" name="idCliente" required value="${pedido.idCliente}">
                                    </div>
                                    <div class="form-group">
                                        <label for="idVendedor">ID Vendedor</label>
                                        <input type="number" class="form-control" name="idVendedor" required value="${pedido.idVendedor}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <!--Pie de Pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
