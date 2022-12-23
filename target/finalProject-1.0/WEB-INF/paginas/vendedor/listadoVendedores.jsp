<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4>Listado de Vendedores</h4>

                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido Paterno</th>
                            <th scope="col">Apellido Materno</th>
                            <th scope="col">Telefono</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Iteramos cada elemento de la lista de clientes -->
                        <c:forEach var="vendedor" items="${vendedores}" varStatus="status" >
                            <tr>
                                <th scope="row">${vendedor.idVendedor}</th>
                                <td>${vendedor.nombre}</td>
                                <td>${vendedor.apellidoP}</td>
                                <td>${vendedor.apellidoM}</td>
                                 <td>${vendedor.telefono}</td>

                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControladorVendedor?accion=editar&idVendedor=${vendedor.idVendedor}"
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
<jsp:include page="/WEB-INF/paginas/vendedor/agregarVendedor.jsp"/>
