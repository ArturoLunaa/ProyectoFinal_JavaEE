<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4>Listado de Detalle Pedidos</h4>

                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">ID Pedido</th>
                            <th scope="col">ID Producto</th>
                            <th scope="col">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iteramos cada elemento de la lista de clientes -->
                        <c:forEach var="detallePedido" items="${detallePedidos}" varStatus="status" >
                            <tr>
                                <th scope="row">${detallePedido.idDetallePedido}</th>
                                <td>${detallePedido.idPedido}</td>
                                <td>${detallePedido.idProducto}</td>
                                <td>${detallePedido.cantidad}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControladorPedido?accion=editarDetalle&idDetallePedido=${detallePedido.idDetallePedido}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i>Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</section>
<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/detallePedido/agregarDetallePedido.jsp"/>
