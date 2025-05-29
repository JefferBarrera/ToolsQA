# Documentación de la Prueba Técnica - Registro de Usuario - ToolsQA

## Descripción General

Este proyecto implementa una automatización de pruebas utilizando 
SerenityBDD con el patrón de diseño Screenplay, Java y Cucumber. 
Está orientado a validar un formulario web en 
diferentes escenarios de ingreso de datos, incluyendo 
validaciones visuales y mensajes de éxito o error.

## Arquitectura

- **Framework de Automatización**: SerenityBDD v4.0.46
- **Lenguaje**: Java 17
- **Frameworks Adicionales**: Cucumber, JUnit
- **Diseño**: Patrón Screenplay
- **Generación de Datos**: Java Faker, Jackson
- **Reportes**: Serenity HTML Reports

## Estructura del Proyecto

```
src
├── main
│   └── java
│       └── co.com.segurosbolivar
│           ├── constants
│           ├── interactions
│           ├── models
│           ├── questions
│           ├── tasks
│           ├── userinterfaces
│           └── utils
└── test
    ├── java
    │   └── co.com.segurosbolivar.Sistema
    │       ├── runners
    │       └── stepdefinitions
    └── resources
        └── features
```

## Configuración del navegador

La configuración del WebDriver se define en `serenity.conf`:

```hocon
webdriver {
  driver = chrome
  autodownload = true
  capabilities {
    browserName = "chrome"
    acceptInsecureCerts = true
    "goog:chromeOptions" {
      args = [
        "new --headless",
        "window-size=1920,1080",
        "--remote-debugging-port=0",
        "start-maximized",
        "--proxy-bypass-list=*",
        "--proxy-server=direct://",
        "disable-download-notification",
        "always-authorize-plugins",
        "allow-running-insecure-content",
        "disable-cache",
        "test-type",
        "no-sandbox",
        "remote-allow-origins=*",
        "ignore-certificate-errors",
        "disable-popup-blocking",
        "disable-default-apps",
        "incognito",
        "disable-infobars",
        "disable-gpu"
      ]
    }
  }
}

```

---
## Hooks

- **Antes de cada escenario**: Se configura el actor y el navegador.
- **Después de cada escenario**: Se cierra el navegador (`driver.quit()`).

```java
@Before
public void actorSetup() {
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled("Automatizador").can(BrowseTheWeb.with(driver));
}

@After
public static void atTheEnd(){
    driver.quit();
}
```

## Runner

A continuación se muestra la configuración del runner de Cucumber, que define las características a ejecutar::

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/Sistema",
    glue = "co.com.segurosbolivar.stepdefinitions",
    plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner { }
```

## Ejecución

```bash
./gradlew clean test aggregate
```

Este comando compila el proyecto, ejecuta los tests y genera los reportes HTML en `target/site/serenity/index.html`.

## Recomendaciones

- Mantener los métodos y clases bajo el patrón Screenplay (Tasks, Questions, Interactions).
- Utilizar objetos generadores de datos para mantener tests dinámicos.
- Validar siempre los elementos con `Ensure` o `seeThat` para asegurar la legibilidad de los resultados.
- Para ejecución paralela, configurar `gradle.properties` y segmentar los escenarios en múltiples archivos `.feature`.