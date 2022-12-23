<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="pedidos.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Pedido
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletControladorPedido?accion=eliminar&idPedido=${pedido.idPedido}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Pedido
                </a>
            </div>
        </div>
    </div>
</section>