<div class="modal fade" id="agregarDetallePedidoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Detalle Pedido</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControladorPedido?accion=insertarDetalle"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="idPedido">ID Pedido</label>
                        <input type="number" class="form-control" name="idPedido" required>
                    </div>
                    <div class="form-group">
                        <label for="idProducto">ID Producto</label>
                        <input type="number" class="form-control" name="idProducto" required>
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="number" class="form-control" name="cantidad" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
