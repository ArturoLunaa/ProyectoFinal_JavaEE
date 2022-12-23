var carrito = (function() {
    cart = [];
    
    // Constructor de articulos
    function Producto(nombre, precio, count, talla) {
      this.nombre = nombre;
      this.precio = precio;
      this.count = count;
      this.talla = talla;
    }
    
    // Guardar carrito a localstorage
    function guardarCarrito() {
      localStorage.setItem('carrito', JSON.stringify(cart));
    }
    
    // Cargar carrito leyendo localstorage
    function cargarCarrito() {
      cart = JSON.parse(localStorage.getItem('carrito'));
    }

    if (localStorage.getItem("carrito") != null) {
      cargarCarrito();
    }
    
    // Objeto json
    var obj = {};
    
    // Agregar al carrito
    obj.agregarProducto = function(nombre, precio, count, talla) {
      for(var item in cart) {
        if(cart[item].nombre === nombre) {
          cart[item].count ++;
          guardarCarrito();
          return;
        }
      }
      var item = new Producto(nombre, precio, count, talla);
      cart.push(item);
      guardarCarrito();
    }

    // Limpiar carrito, lo hacemos cuando el cliente cierre el Modal
    obj.limpiarCarrito = function() {
      cart = [];
      guardarCarrito();
    }
  
    // Contar articulos
    obj.totalArticulos = function() {
      var totalArticulos = 0;
      for(var item in cart) {
        totalArticulos += cart[item].count;
      }
      return totalArticulos;
    }
  
    // Precio final (total)
    obj.totalCarrito = function() {
      var totalCarrito = 0;
      for(var item in cart) {
        totalCarrito += cart[item].precio * cart[item].count;
      }
      return '$' + Number(totalCarrito.toFixed(2));
    }
  
    // Mostrar carrito
    obj.prepararCarrito = function() {
      var cartCopy = [];
      for(i in cart) {
        item = cart[i];
        itemCopy = {};
        for(p in item) {
          itemCopy[p] = item[p];
        }
        itemCopy.total = Number(item.precio * item.count).toFixed(2);
        cartCopy.push(itemCopy)
      }
      return cartCopy;
    }
    return obj;
  })();
  
  // Eventos

  // Agregar al carrito
  $('.agregar-carrito').click(function(event) {
    carrito.limpiarCarrito(); // agregue esto porque a veces no cierran el modal desde el boton
    event.preventDefault();
    var nombre = $(this).data('nombre');
    var precio = Number($(this).data('precio'));
    var select_talla = document.getElementById("talla");
    var talla = select_talla.options[select_talla.selectedIndex].text;
    var select = document.getElementById("cantidad");
    var convertirCantidString = parseInt(select.value, 10)
    carrito.agregarProducto(nombre, precio, convertirCantidString, talla);

    mostrarCarrito();
  });
  
  // Limpiar Carrito
  $('.limpiar-carrito').click(function() {
    carrito.limpiarCarrito();
    mostrarCarrito();
  });
  
  // Mostrar carrito
  function mostrarCarrito() {
    var cartArray = carrito.prepararCarrito();
    var output = "";
    for(var i in cartArray) {
      output += "<ul class='list-group'>"
        + "<li class='list-group-item'>" + cartArray[i].nombre + "<br>" + "Precio: $" + cartArray[i].precio + "</li>" 
        + "<li class='list-group-item'>Talla: " + cartArray[i].talla + "</li>"
        + "<li class='list-group-item'>Cantidad: " + carrito.totalArticulos() + "</li>"
        +  "</ul>";
    }
    $('.show-cart').html(output);
    $('.modelo-subtitulo').html("<p>Unos grandiosos <strong>" + cartArray[i].nombre + "</strong> te esperan</p>");
    $('.total-cart').html(carrito.totalCarrito());
    $('.total-count').html(carrito.totalArticulos());
  }

  mostrarCarrito();
  