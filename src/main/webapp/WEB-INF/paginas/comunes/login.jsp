<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>


<!-- Codigo de el Modal de Login -->
<div class="modal fade" id="modal_login" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" data-backdrop="static">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Iniciar Sesión</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                 <form action="${pageContext.request.contextPath}/ServletControladorUsuario?accion=login"
              method="POST" class="was-validated" onsubmit='alert("Inicio de sesión Exitoso")'>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="user">Usuario</label>
                            <input type="text" class="form-control" name="user" required>
                        </div>
                        <div class="form-group mt-2">
                            <label for="contrasena">Contraseña</label>
                            <input type="password" class="form-control" name="contrasena" required>
                        </div>
                        <div class="form-group">
                            <a class="btn btn-dark mt-3" data-bs-toggle="modal" data-bs-dismiss="modal" data-bs-target="#agregarUsuarioModal" href="#">Si no tienes cuenta, regístrate.</a>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit">Iniciar Sesión</button>
                    </div>    
                </form>
            </div>
        </div>
    </div>
</div>