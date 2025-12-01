# language: es
Característica: Compra de productos en Your Store App

  Como cliente de la aplicación Your Store
  Quiero poder seleccionar productos, añadirlos al carrito y completar el proceso de checkout
  Para así adquirir los artículos que deseo de forma exitosa

  Antecedentes:
    Dado que el usuario ha accedido a la página principal de Your Store App

  @compra @compra-dos-productos
  Escenario: Realizar una compra exitosa de dos productos como usuario invitado
    Cuando el usuario agrega dos productos al carrito
    Y el usuario visualiza el carrito
    Y el usuario completa el checkout como invitado
    Entonces el usuario debería ver la confirmación: Your order has been placed!

  @compra @compra-producto-por-nombre
  Esquema del escenario: Realizar la búsqueda y compra exitosa de un producto.
    Cuando el usuario busca y agrega <producto> al carrito
    Y el usuario visualiza el producto en el carrito
    Y el usuario completa el checkout como invitado
    Entonces el usuario debería ver la confirmación: Your order has been placed!

    Ejemplos:
      | producto      |
      | "iMac"        |
      | "MacBook Pro" |
      | "MacBook Air" |