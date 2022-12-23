<div class="modal fade" id="agregarPedidoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Pedido</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControladorPedido?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="fecha">Fecha</label>
                        <input type="date" class="form-control" name="fecha" required>
                    </div>
                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" name="estado" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaEnvio">Fecha Envio</label>
                        <input type="date" class="form-control" name="fechaEnvio" required>
                    </div>
                    <div class="form-group">
                        <label for="idCliente">ID Cliente</label>
                        <input type="number" class="form-control" name="idCliente" required>
                    </div>
                    <div class="form-group">
                        <label for="idVendedor">ID Vendedor</label>
                        <input type="number" class="form-control" name="idVendedor" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
