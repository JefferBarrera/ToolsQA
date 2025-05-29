
# Prueba Técnica - Registro de Usuario - ToolsQA

Este proyecto automatiza los escenarios de prueba del formulario de registro usando **SerenityBDD**, **Cucumber**, **Java** y el patrón de diseño **Screenplay**.

## Tecnologías utilizadas

- Java 11+
- Serenity BDD
- Cucumber
- JUnit
- Screenplay Pattern
- Selenium WebDriver (Chrome)
- Java Faker
- Jackson (manejo de JSON)
- Gradle

---

## Ejecución de pruebas

### Desde la terminal

```bash
./gradlew clean test aggregate
```

Esto genera el reporte en `target/site/serenity/index.html`.

### Desde un runner específico

Puedes ejecutar una clase `Runner` directamente desde tu IDE (por ejemplo, IntelliJ o Eclipse).

---

## Escenarios cubiertos

- Envío exitoso del formulario con datos válidos
- Validación de campos obligatorios vacíos (nombre, apellido, género, etc.)
- Validación de formatos inválidos (email, teléfono)
- Envío del formulario con datos provenientes de una API

---

## Patrón de diseño: Screenplay

Se aplica el patrón **Screenplay** para estructurar las pruebas de forma desacoplada y escalable. Los elementos clave son:

- **Actor**: `Automatizador`, configurado en los hooks.
- **Tasks**: Navegar, DiligenciarRegistroTask.
- **Questions**: Validaciones como `EsInvalido`, `ColorLabel`, `TextoModal`.

---


## Reportes

Los reportes se generan automáticamente al ejecutar las pruebas:

- Ubicación: `target/site/serenity/index.html`
- Incluyen capturas antes y después de cada paso (`BEFORE_AND_AFTER_EACH_STEP`).

---

## Ejecución por etiquetas

Puedes agregar tags a tus escenarios y ejecutarlos por línea de comandos:

```bash
./gradlew clean test -Dtags="@TC01"
```

---

## Generación de datos

Los datos de prueba se generan dinámicamente mediante la clase `GeneradorUsuarios`, utilizando:

- Datos aleatorios (Java Faker)
- Datos simulados desde API


---

## Requisitos

- JDK 11+
- Chrome
- Gradle

---

## Notas

- El proyecto está diseñado para ejecutarse en paralelo si se configura en `gradle.properties`.
- El navegador corre en modo `headless` por defecto, modificable en `serenity.conf`.
