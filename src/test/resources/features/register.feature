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

      | gender | firstName | lastName | email                          | password  |
      | Male   | John      | Doe      | john.doe.test@mailinator.com   | Test1234! |
      | Female | Jane      | Smith    | jane.smith.test@mailinator.com | Pass5678! |

  @register @negative
  Scenario: Registro con un correo ya registrado
    When el usuario completa el formulario de registro
      | gender | firstName | lastName | email               | password  |
      | Male   | Test      | User     | admin@yourstore.com | Test1234! |
    Then el usuario ve el error "The specified email already exists"
