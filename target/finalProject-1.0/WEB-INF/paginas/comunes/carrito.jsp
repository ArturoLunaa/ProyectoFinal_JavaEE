<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Codigo de el Modal de Login -->
    <div class="modal fade" id="modal_login" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" data-backdrop="static">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Iniciar Sesión</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
              <form>
                  <!-- Alerta que esta escondida por defecto, usamos jquery para mostrarla cuando se hace click en #iniciar -->
                  <div class="alert alert-primary alert-dismissable" style="display: none;">
                              Bienvenido, esta página esta en desarrollo aún
                  </div>

                  <div class="form-group">
                    <label for="exampleInputEmail1" class='mt-4'>Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese su email">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1" class='mt-4'>Contraseña</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ingrese su ContraseÃ±a">
                  </div>
                  <div class="text-center">
                  <button type="button" class="btn btn-primary mt-4" id="iniciar">Iniciar Sesión</button>
                  </div>
              </form>
          </div>
        </div>
      </div>
    </div>

    <!-- Codigo de el Modal de Carrito -->
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
                  <div class="py-5 text-center">
                    <img class="d-block mx-auto mb-4" src="../img/lbr-logoRosa.png" alt="" width="120" height="120">
                    <h2>Termina tu Compra</h2>
                    <p class='modelo-subtitulo'></p>
                  </div>
            
                  <div class="row">
                    <div class="col-md-4 order-md-2 mb-4">
                      <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Tu carrito</span>
                        <span class="badge badge-secondary badge-pill">3</span>
                      </h4>
                      <table class="show-cart table">
          
                      </table>
                      <div class='list-group-item d-flex justify-content-between lh-condensed'>Total: <span class="total-cart"></span></div>
                    </div>
                    <div class="col-md-8 order-md-1">
                      <h4 class="mb-3">Dirección de Enví­o</h4>
                      <form class="needs-validation" novalidate>
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
                            <label for="country">Paí­s</label>
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
                                <option value="CDMX">Ciudad de MÃ©xico</option>
                                <option value="Coahuila">Coahuila</option>
                                <option value="Colima">Colima</option>
                                <option value="Durango">Durango</option>
                                <option value="Estado de MÃ©xico">Estado de MÃ©xico</option>
                                <option value="Guanajuato">Guanajuato</option>
                                <option value="Guerrero">Guerrero</option>
                                <option value="Hidalgo">Hidalgo</option>
                                <option value="Jalisco">Jalisco</option>
                                <option value="MichoacÃ¡n">MichoacÃ¡n</option>
                                <option value="Morelos">Morelos</option>
                                <option value="Nayarit">Nayarit</option>
                                <option value="Nuevo LeÃ³n">Nuevo LeÃ³n</option>
                                <option value="Oaxaca">Oaxaca</option>
                                <option value="Puebla">Puebla</option>
                                <option value="QuerÃ©taro">QuerÃ©taro</option>
                                <option value="Quintana Roo">Quintana Roo</option>
                                <option value="San Luis PotosÃ­">San Luis PotosÃ­</option>
                                <option value="Sinaloa">Sinaloa</option>
                                <option value="Sonora">Sonora</option>
                                <option value="Tabasco">Tabasco</option>
                                <option value="Tamaulipas">Tamaulipas</option>
                                <option value="Tlaxcala">Tlaxcala</option>
                                <option value="Veracruz">Veracruz</option>
                                <option value="YucatÃ¡n">YucatÃ¡n</option>
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
                      </form>
                    </div>
                  </div>
                </div>
                <div class="align-content-center text-center">
                  <button type="button" class="btn btn-primary">Ordenar Ahora</button>
                </div>
          </div>
      </div>
      </div>
    </div> 

    <!-- Importamos jquery para que se actualicen los datos usando javascript sin refrescar la pagina, y nuestro js para carrito-->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
    <script src='../js/carrito.js'></script>

    <script type="text/javascript">
      $(document).ready(function(){
          $('#iniciar').click(function(){
              $('.alert').show()
          }) 
      });
    </script>