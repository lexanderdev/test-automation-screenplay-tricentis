# Autor: William Vanegas

Feature: Compra de un producto
  Como usuario registrado
  Quiero navegar por las categorias y subcategorias y comprar un producto
  Para completar una orden exitosamente

  Background:
    Given el usuario navega a la pagina de inicio de sesion
    When el usuario inicia sesion con sus credenciales
      | email          | password   |
      | alt.e3-6opqb217@yopmail.com | Test123. |

  @purchase
  Scenario: Compra exitosa de un producto desde Desktops
    When el usuario navega a la subcategoria "Desktops" dentro de "Computers"
    And el usuario agrega Build your own cheap computer al carrito
    Then el usuario ve la notificacion de producto agregado al carrito
    And el usuario va al carrito desde la notificacion
    And el usuario completa el proceso de compra con direccion
      | country  | company      | city   | address           | zip    | phone      |
      | Colombia | Test Company | Bogota | Calle 123 # 45-67 | 110111 | 3001234567 |
    And el usuario paga con tarjeta de credito
      | cardholderName | cardNumber       | month | year | code |
      | Barbara Gordon | 4485564059489345 | 04    | 2039 | 123  |
    And el usuario ve la confirmacion de su orden
