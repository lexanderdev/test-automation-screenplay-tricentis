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

---

## Ejecución de Pruebas

### Ejecutar todos los escenarios

```bash
./gradlew test
```

### Ejecutar por escenario específico

| Escenario | Comando |
|-----------|---------|
| Registro de usuario | `./gradlew test -Dcucumber.filter.tags="@register"` |
| Inicio de sesión | `./gradlew test -Dcucumber.filter.tags="@login"` |
| Compra de producto | `./gradlew test -Dcucumber.filter.tags="@purchase"` |
| Escenarios negativos | `./gradlew test -Dcucumber.filter.tags="@negative"` |

### Generar reporte HTML de Serenity

```bash
./gradlew aggregate
```

> El reporte se genera en `target/site/serenity/index.html`

---

## Estructura del Proyecto

```
src/test
├── java/co/com/stricentis/
│   ├── hooks/                  # Ciclo de vida de los escenarios, inicialización y cierre del navegador antes y después de cada escenario
│   ├── models/                 # Clases de datos (UserModel, LoginModel, BillingModel, PaymentModel)
│   ├── questions/              # Preguntas Screenplay: validan el estado de la UI y retornan un valor
│   ├── runners/                # Configuración del runner de Cucumber con JUnit 5
│   ├── stepdefinitions/        # Mapeo entre los pasos Gherkin y las acciones Screenplay
│   ├── tasks/                  # Acciones que el actor puede realizar sobre la aplicación
│   └── userinterface/          # Localizadores de elementos web organizados por página
│
└── resources/
    ├── features/               # Escenarios de prueba escritos en Gherkin (español)
    │   ├── register.feature
    │   ├── login.feature
    │   └── purchase_product.feature
    └── serenity.conf           # Configuración de Serenity (driver, URL base, screenshots)
```

---

## Estado de Implementación

### ✅ Implementado

- Arquitectura Screenplay con capas `tasks`, `questions`, `userinterface`, `models`, `hooks` y `stepdefinitions`
- Flujo E2E de registro de usuario con escenario positivo y negativo
- Flujo E2E de inicio de sesión con escenario positivo y negativo
- Flujo E2E de compra de producto: navegación por categorías, carrito, checkout, pago con tarjeta y confirmación de orden
- Modelos de datos con Lombok (`@Data` + `@Builder`) para separar datos de lógica
- Ejecución por tags (`@register`, `@login`, `@purchase`, `@negative`)
- Modo incógnito para sesiones de navegador limpias entre ejecuciones
- Reporte HTML con Serenity BDD

---

### 🚀 Mejoras Futuras

| # | Mejora | Descripción |
|---|--------|-------------|
| 1 | **Múltiples ambientes** | Agregar bloques `staging`, `qa` y `production` en `serenity.conf` para ejecutar las pruebas contra distintos entornos sin modificar código |
| 2 | **Externalización de datos** | Mover los datos de prueba de los features a un servicio externo como **Firebase Realtime Database**, eliminando la necesidad de modificar el código para actualizar credenciales o datos de formulario |
| 3 | **Análisis de calidad de código** | Integrar **SonarQube** para inspección estática del código, detección de code smells y control de cobertura |
| 4 | **CI/CD con GitHub Actions** | Configurar un workflow en `.github/workflows/ci.yml` para ejecutar las pruebas automáticamente en cada push o pull request, con publicación del reporte Serenity como artefacto |
| 5 | **Protección de ramas** | Configurar reglas en GitHub para las ramas `develop` y `main`: requerir pull request aprobado, pasar los checks de CI y restringir push directo a `main` para garantizar que solo código validado llegue a producción |
| 6 | **Ejecución en paralelo** | Configurar Serenity para ejecutar los features en paralelo y reducir el tiempo total de ejecución |
| 7 | **Reintentos automáticos** | Configurar reintentos automáticos para escenarios fallidos, evitando falsos negativos causados por inestabilidad de red o tiempos de respuesta variables |
| 8 | **Esperas explícitas** | Reemplazar las esperas implícitas por `WaitUntil` antes de interactuar con elementos críticos, garantizando que sean visibles e interactuables antes de continuar y eliminando la posibilidad de flaky tests |
| 9 | **Estrategia de ejecución por etapas** | Implementar **Smoke Tests** con el tag `@smoke` para ejecutar en cada push solo los escenarios críticos, y configurar un **Nightly Build** en GitHub Actions (`cron: '0 2 * * *'`) para ejecutar la suite E2E completa en horario nocturno, evitando ralentizar el ciclo de desarrollo |
