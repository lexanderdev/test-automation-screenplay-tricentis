# Automatización E2E - Tricentis Demo Web Shop

## Descripción

Proyecto de automatización de pruebas end-to-end para la plataforma [Tricentis Demo Web Shop](https://demowebshop.tricentis.com), implementando el patrón **Screenplay** con **Serenity BDD** **Selenium WebDriver** y **Cucumber** .

Los flujos automatizados cubren el registro de usuario, inicio de sesión y la compra completa de un producto, incluyendo agregar producto al carrito, ingresar al carrito , checkout,  dirección de facturación, y pago con tarjeta de crédito.

## Stack Tecnológico

![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=java&logoColor=white)
![Serenity BDD](https://img.shields.io/badge/Serenity_BDD-5.3.7-2196F3?style=for-the-badge&logo=serenity&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-7.x-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.14-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-1.18.34-BC4521?style=for-the-badge&logoColor=white)

## Escenarios Automatizados

### 🔐 Bloque 1 — Registro de usuario (`register.feature`)

| # | Paso | Descripción |
|---|------|-------------|
| 1 | Registro | Dar clic en **Register** e ingresar los datos requeridos para crear una cuenta en la página |
| 2 | Verificación | Validar que el registro fue exitoso |

---

### 🛒 Bloque 2 — Login y compra de producto (`login.feature` + `purchase_product.feature`)

| # | Paso | Descripción |
|---|------|-------------|
| 3 | Login | Iniciar sesión en la página Demo Web Shop Tricentis |
| 4 | Navegación | Dar clic en una **Categoría > Subcategoría** (Computers > Desktops) |
| 5 | Agregar al carrito | Seleccionar un producto y agregarlo al carrito |
| 6 | Checkout | Ingresar al carrito y dar clic en **Checkout** |
| 7 | Dirección de entrega | Ingresar los datos solicitados para la entrega; los campos restantes se dejan con los valores por defecto |
| 8 | Método de pago | Seleccionar **tarjeta de crédito** como método de pago |
| 9 | Información de pago | Completar los datos de la tarjeta de crédito |
| 10 | Confirmación | Confirmar la orden y validar el mensaje **"Your order has been successfully processed!"** |
