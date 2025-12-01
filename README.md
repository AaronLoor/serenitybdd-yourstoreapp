# Framework de Automatización E2E - Your Store App (OpenCart)

Este proyecto implementa pruebas automatizadas End-to-End (E2E) para el sitio de comercio electrónico OpenCart, utilizando el patrón de diseño **Screenplay** con **Serenity BDD**, **Cucumber** y **Java**.

## 🛠️ Tecnologías Utilizadas

*   **Lenguaje:** Java 17
*   **Framework BDD:** Serenity BDD + Cucumber
*   **Patrón de Diseño:** Screenplay Pattern
*   **Build Tool:** Maven
*   **Driver:** Selenium WebDriver (Chrome)
*   **Gestión de Aserciones:** Serenity Ensure

## 📋 Prerrequisitos

Antes de ejecutar las pruebas, asegúrate de tener configurado lo siguiente:

1.  **Java JDK 17** o superior instalado.
2.  **Maven 3.6+** configurado en las variables de entorno.
3.  **Google Chrome** actualizado a la última versión estable.
4.  **ChromeDriver:** Debes tener el binario de ChromeDriver compatible con tu versión de Chrome.
    *   Descárgalo desde el sitio oficial: [Chrome for Testing - Stable](https://googlechromelabs.github.io/chrome-for-testing/#stable)
    *   Una vez descargado, coloca el ejecutable en la ruta correspondiente a tu sistema operativo dentro de: `src/test/resources/webdriver/{os}/` (según configuración en `serenity.conf`).

## 🧪 Escenarios de Prueba Implementados

El proyecto incluye un archivo de características (`.feature`) escrito en Gherkin (Español) que cubre los flujos críticos de compra.

**Feature:** Compra de productos en Your Store App

### 1. Compra de Múltiples Productos
*   **Tag:** `@compra-dos-productos`
*   **Descripción:** Valida el flujo "Happy Path" donde un usuario agrega dos productos específicos desde el catálogo principal, verifica que ambos estén en el carrito y finaliza la compra como invitado.

### 2. Búsqueda y Compra (Data Driven)
*   **Tag:** `@compra-producto-por-nombre`
*   **Tipo:** Esquema del Escenario (Scenario Outline)
*   **Descripción:** Valida la funcionalidad de búsqueda, agregando dinámicamente el producto encontrado al carrito y completando el pago.
*   **Datos de Prueba:** Se ejecuta iterativamente para los siguientes productos:
    *   "iMac"
    *   "MacBook Pro"
    *   "MacBook Air"

## 📊 Reportes y Resultados

Serenity BDD genera documentación viva y reportes detallados tras cada ejecución. Tienes dos formas de acceder a ellos:
*   **Acceso Directo desde la Consola:** Al finalizar la ejecución (ya sea exitosa o fallida), observa las últimas líneas en tu terminal. Serenity generará un enlace directo al reporte.

* **Acceso Manual:** Si cerraste la consola, siempre puedes encontrar los archivos en la carpeta del proyecto:
       Navega a: **target/site/serenity/**  
       Abre el archivo index.html.

## 🚀 Instrucciones de Ejecución

### 1. Ejecución Estándar (Todos los Tests)
Ejecuta el siguiente comando en la raíz del proyecto. Esto descargará las dependencias, compilará el código y ejecutará todos los escenarios definidos en los archivos `.feature`.


```bash
mvn clean verify
```