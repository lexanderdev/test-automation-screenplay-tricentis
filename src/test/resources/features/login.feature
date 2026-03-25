# Autor: William Vanegas

Feature: Inicio de sesion
  Quiero iniciar sesion en la tienda
  Para acceder a mi cuenta

  Background:
    Given el usuario navega a la pagina de inicio de sesion

  @login
  Scenario Outline: Inicio de sesion exitoso
    When el usuario inicia sesion con sus credenciales
      | email   | password   |
      | <email> | <password> |
    Then el usuario accede exitosamente a su cuenta

    Examples:
      | email                        | password  |
      | yiler76657@smkanba.com               | Test12345*|

  @login @negative
  Scenario: Inicio de sesion con contrasena incorrecta
    When el usuario inicia sesion con sus credenciales
      | email                        | password     |
      | alex@gmail.com              | WrongPass123 |
    Then el usuario ve el mensaje de error "The credentials provided are incorrect"
