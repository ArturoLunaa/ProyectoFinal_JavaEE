<%@ page import="datos.ProductoDaoJDBC" %>
<%@ page import="dominio.Producto" %>

<head>
    <link rel="icon" href="img/favicon.ico" />
    <link rel="stylesheet" href="css/estilos.css" type="text/css" />
    <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
</head>
<section id="global">
    <section class="container text-center align-content-center justify-content-between">
            <%
                String productoParam = request.getParameter("id");
                int productoId = Integer.parseInt(productoParam);
                ProductoDaoJDBC productoDAO = new ProductoDaoJDBC();
                Producto productoPorId = new Producto(productoId);
                Producto producto = productoDAO.encontrar(productoPorId);
            %>

            <div id="imgTenis" class="col-lg-6 col-sm-12 mt-5">
                <%
                    out.print("<img src='img/" + producto.getImagen() + "' alt='' height='350' width='400'>");
                %>
            </div>
            <div id="textoDesc" class="col-lg-6 col-sm-12">
                <%
                    out.print("<h2>" + producto.getModelo() + "</h2>");
                    out.print("<h3>MXN $" + producto.getPrecio() + "</h3>");
                %>
                <p>Uno de los pares más solicitados a nivel mundial, su atractivo color y modelo high brindan una
                    comodidad y aspecto inigualable</p>
                <!--ComboBox de Talla-->
                <select id="talla" class="form-select d-inline-block" aria-label="Default select example">
                    <option selected>Selecciona tu talla</option>
                    <option value="1">24</option>
                    <option value="1">25.5</option>
                    <option value="1">26</option>
                    <option value="2">27</option>
                    <option value="3">28</option>
                    <option value="4">28.5</option>
                    <option value="5">29</option>
                    <option value="6">30</option>
                </select>
                <!--ComboBox de Cantidad-->
                <select id="cantidad" class="form-select d-inline-block" aria-label="Default select example">
                    <option selected>Cantidad</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                <div class="form-check mt-4">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        Estoy de acuerdo con los términos y condiciones de LBRKICKZ
                    </label>
                </div>
                <!--Botón-->
                <div class="d-grid gap-2 mt-4">
                    <%
                        out.print("<button type='submit' data-nombre='" + producto.getModelo() + "' data-precio='" + producto.getPrecio() + "' class='agregar-carrito btn btn-primary' data-bs-toggle='modal' data-bs-target='#cart'>Comprar</button>");
                    %>
                </div>
            </div>
    </section>

    <div class="modal fade" id="cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Comprar</h5>
                    <button type="button" class="close limpiar-carrito" data-bs-dismiss="modal" aria-label="Close" >
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container">
                            <div class="col-lg-6 mb-4">
                                <div class="py-5 text-center">
                                    <img class="d-block mx-auto mb-4" src="img/lbr-logoRosa.png" alt="" width="120" height="120">
                                    <h2>Termina tu Compra</h2>
                                    <p class='modelo-subtitulo'></p>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <h4 class="d-flex justify-content-between align-items-center mb-3">
                                    <span class="text-muted">Tu carrito</span>
                                    <span class="badge badge-secondary badge-pill">3</span>
                                </h4>
                                <table class="show-cart table">

                                </table>
                                <div class='list-group-item d-flex justify-content-between lh-condensed'>Total: <span class="total-cart"></span></div>
                            </div>
                    </div>
                        <div class="">
                            <h4 class="mb-3">Dirección de Envío</h4>

                            <form class="needs-validation" novalidate action="${pageContext.request.contextPath}/ServletControladorPedido?accion=insertar"
                                  method="POST" class="was-validated">

                                <input type="hidden" class="form-control" name="fecha" value="06-12-2022"/>
                                
                                <input type="hidden" class="form-control" name="fechaEnvio" value="08-12-2022"/>
                                
                                <input type="hidden" class="form-control" name="estado" value="Procesando"/>
                                
                                <input type="hidden" class="form-control" name="idCliente" value="7"/>
                                
                                <input type="hidden" class="form-control" name="idVendedor" value="4"/>

                                <!-- comment -->
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="firstName">Nombre</label>
                                        <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                                        <div class="invalid-feedback">
                                            Campo requerido
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="lastName">Apellido</label>
                                        <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                                        <div class="invalid-feedback">
                                            Campo requerido
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email">
                                    <div class="invalid-feedback">
                                        Campo requerido
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="address">Calle y #</label>
                                    <input type="text" class="form-control" id="address" required>
                                    <div class="invalid-feedback">
                                        Campo requerido
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="address2">Colonia</label>
                                    <input type="text" class="form-control" id="address2" required>
                                </div>

                                <div class="row">
                                    <div class="col-md-5 mb-3">
                                        <label for="country">País</label>
                                        <select class="custom-select d-block w-100 form-control" id="country" required>
                                            <option value="">Elige</option>
                                            <option>México</option>
                                        </select>
                                        <div class="invalid-feedback">
                                            Campo requerido
                                        </div>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label for="state">Estado</label>
                                        <select class="custom-select d-block w-100 form-control" id="state" required>
                                            <option value="">Elige</option>
                                            <option value="Aguascalientes">Aguascalientes</option>
                                            <option value="Baja California">Baja California</option>
                                            <option value="Baja California Sur">Baja California Sur</option>
                                            <option value="Campeche">Campeche</option>
                                            <option value="Chiapas">Chiapas</option>
                                            <option value="Chihuahua">Chihuahua</option>
                                            <option value="CDMX">Ciudad de México</option>
                                            <option value="Coahuila">Coahuila</option>
                                            <option value="Colima">Colima</option>
                                            <option value="Durango">Durango</option>
                                            <option value="Estado de México">Estado de México</option>
                                            <option value="Guanajuato">Guanajuato</option>
                                            <option value="Guerrero">Guerrero</option>
                                            <option value="Hidalgo">Hidalgo</option>
                                            <option value="Jalisco">Jalisco</option>
                                            <option value="Michoacán">Michoacán</option>
                                            <option value="Morelos">Morelos</option>
                                            <option value="Nayarit">Nayarit</option>
                                            <option value="Nuevo León">Nuevo León</option>
                                            <option value="Oaxaca">Oaxaca</option>
                                            <option value="Puebla">Puebla</option>
                                            <option value="Querétaro">Querétaro</option>
                                            <option value="Quintana Roo">Quintana Roo</option>
                                            <option value="San Luis Potosí">San Luis Potosí</option>
                                            <option value="Sinaloa">Sinaloa</option>
                                            <option value="Sonora">Sonora</option>
                                            <option value="Tabasco">Tabasco</option>
                                            <option value="Tamaulipas">Tamaulipas</option>
                                            <option value="Tlaxcala">Tlaxcala</option>
                                            <option value="Veracruz">Veracruz</option>
                                            <option value="Yucatán">Yucatán</option>
                                            <option value="Zacatecas">Zacatecas</option>
                                        </select>
                                        <div class="invalid-feedback">
                                            Campo requerido
                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="zip">CP</label>
                                        <input type="text" class="form-control" id="zip" placeholder="" required>
                                        <div class="invalid-feedback">
                                            Campo requerido
                                        </div>
                                    </div>
                                </div>
                                <div class="align-content-center text-center">
                                    <button type="submit" class="btn btn-primary">Ordenar Ahora</button>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
</div> 

<!-- Importamos jquery para que se actualicen los datos usando javascript sin refrescar la pagina, y nuestro js para carrito-->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src='js/carrito.js'></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#iniciar').click(function () {
            $('.alert').show()
        })
    });
</script>


