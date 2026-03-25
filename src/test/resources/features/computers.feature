# Autor: William Vanegas

Feature: Navegacion y compra de computadores
  Como usuario registrado
  Quiero navegar por las categorias y subcategorias y comprar un producto
  Para completar una orden exitosamente

  Background:
    Given el usuario navega a la pagina de inicio de sesion
    When el usuario inicia sesion con sus credenciales
      | email          | password   |
      | alt.xm-doh3nzhv@yopmail.com | Test123, |

  @computers
  Scenario: Agregar Build your own computer al carrito desde Desktops
    When el usuario navega a la subcategoria "Desktops" dentro de "Computers"
    And el usuario agrega "Build your own cheap computer" al carrito
    Then el usuario ve la notificacion de producto agregado al carrito
    And el usuario va al carrito desde la notificacion
    And el usuario completa el proceso de compra
    Then el usuario ve la confirmacion de su orden
