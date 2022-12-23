<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4>Listado de Pedidos</h4>

                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Fecha Envío</th>
                            <th scope="col">ID Cliente</th>
                            <th scope="col">ID Vendedor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iteramos cada elemento de la lista de clientes -->
                        <c:forEach var="pedido" items="${pedidos}" varStatus="status" >
                            <tr>
                                <th scope="row">${pedido.idPedido}</th>
                                <td>${pedido.fecha}</td>
                                <td>${pedido.estado}</td>
                                <td>${pedido.fechaEnvio}</td>
                                 <td>${pedido.idCliente}</td>
                                 <td>${pedido.idVendedor}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</section>

