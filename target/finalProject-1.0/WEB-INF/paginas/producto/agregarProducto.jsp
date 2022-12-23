<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Producto</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControladorProducto?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <div class="form-group">
                        <label for="modelo">Modelo</label>
                        <input type="text" class="form-control" name="modelo" required>
                    </div>
                    <div class="form-group">
                        <label for="marca">Marca</label>
                        <input type="text" class="form-control" name="marca" required>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" required>
                    </div>
                    <div class="custom-file">
                        <label for="imagen">Imagen: </label>
                        <input type="file" class="custom-file-input" name="imagen" id="inputGroupFile01">
                    </div>
                    <div class="form-group">
                        <label for="IProovedor">ID Proovedor</label>
                        <input type="number" class="form-control" name="idProovedor" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
