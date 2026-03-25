# Autor: William Vanegas

Feature: Registro de usuario

  Quiero registrarme para poder acceder a las funciones de la tienda

  Background:
    Given el usuario navega a la pagina de registro

  @register
  Scenario Outline: Registro exitoso de usuario
    When el usuario completa el formulario de registro
      | gender   | firstName   | lastName   | email   | password   |
      | <gender> | <firstName> | <lastName> | <email> | <password> |
    Then el registro se completa exitosamente

    Examples:
      | gender | firstName | lastName     | email            | password  |
      | Male   | Alexander | Vanegas      | yiler76657@smkanba.com  | Test12345* |


  @register @negative
  Scenario: Registro con un correo ya registrado
    When el usuario completa el formulario de registro
      | gender | firstName | lastName | email               | password  |
      | Male   | Test      | User     | alex@gmail.com     | Test1234! |
    Then el usuario ve el error "The specified email already exists"
