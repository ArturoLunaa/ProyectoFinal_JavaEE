<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4>Listado de Proovedores</h4>

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
                        <c:forEach var="proovedor" items="${proovedores}" varStatus="status" >
                            <tr>
                                <th scope="row">${proovedor.idProovedor}</th>
                                <td>${proovedor.nombre}</td>
                                <td>${proovedor.apellidoP}</td>
                                <td>${proovedor.apellidoM}</td>
                                 <td>${proovedor.telefono}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</section>
<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/proovedor/agregarProovedor.jsp"/>
