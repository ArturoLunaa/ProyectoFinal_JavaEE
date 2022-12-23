 <head>
        <jsp:include page="/WEB-INF/paginas/comunes/head.jsp"/>
    </head>
    <section id="global">
          <section class="container">
            <div class="row">
                <div id="imgTenis" class="col-lg-6 col-sm-12 mt-5">
                    <img src="../img/adidas_2.png" alt="" height="100%" width="100%">
                </div>
                <div id="textoDesc" class="col-lg-6 col-sm-12">
                    <h2>Adidas Forum High</h2>
                    <h3>MXN $3,899</h3>
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
                        <button data-nombre="Adidas Forum High" data-precio="3899" 
                        class="agregar-carrito btn btn-primary" data-bs-toggle="modal" data-bs-target="#cart">Comprar</button>
                    </div>
                </div>

            </div>
        </section>


