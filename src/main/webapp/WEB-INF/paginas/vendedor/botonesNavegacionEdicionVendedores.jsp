<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="vendedores.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Vendedor
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControladorVendedor?accion=eliminar&idVendedor=${vendedor.idVendedor}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Vendedor
                </a>
            </div>
        </div>
    </div>
</section>