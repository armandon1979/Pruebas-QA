# Prueba E2E para OpenCart con Serenity BDD

Este proyecto contiene una prueba funcional automatizada (E2E) para el flujo de compra en la página http://opencart.abstracta.us/ utilizando Serenity BDD.

## Requisitos previos

- Java 11 o superior
- Maven 3.8.0 o superior
- Google Chrome (última versión estable)
- ChromeDriver compatible con la versión de Chrome instalada

## Estructura del proyecto

```
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── opencart
│   │                   ├── pages      # Page Objects
│   │                   └── steps      # Step Definitions
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── opencart
│                       └── tests      # Test Cases
├── pom.xml                           # Dependencias del proyecto
├── serenity.properties               # Configuración de Serenity
├── README.txt                        # Este archivo
└── conclusiones.txt                  # Hallazgos y conclusiones
```

## Instrucciones paso a paso para la ejecución

1. **Clonar el repositorio**

```bash
git clone https://github.com/[usuario]/opencart-serenity-test.git
cd opencart-serenity-test
```

2. **Configurar WebDriver**

Asegúrese de que la versión de ChromeDriver sea compatible con su versión de Chrome.
Puede descargar ChromeDriver desde: https://chromedriver.chromium.org/downloads

3. **Ejecutar las pruebas**

```bash
mvn clean verify
```

4. **Ver reportes de Serenity**

Después de ejecutar las pruebas, Serenity generará un informe detallado. Abra el archivo `target/site/serenity/index.html` en su navegador para ver los resultados de las pruebas.

```bash
# En Linux/Mac
open target/site/serenity/index.html

# En Windows
start target/site/serenity/index.html
```

## Configuración adicional

Si necesita modificar la configuración de Serenity, puede editar el archivo `serenity.properties` con los siguientes parámetros:

```properties
# Configuración general
serenity.project.name=OpenCart E2E Tests
webdriver.driver=chrome
webdriver.chrome.driver=/ruta/a/su/chromedriver
webdriver.timeouts.implicitlywait=5000
serenity.browser.width=1920
serenity.browser.height=1080

# Configuración de capturas de pantalla
serenity.take.screenshots=FOR_FAILURES
```

## Solución de problemas

1. **Problema**: El test no puede encontrar elementos en la página.
   **Solución**: Verifique que los selectores CSS o XPath sean correctos y que se estén utilizando tiempos de espera adecuados.

2. **Problema**: WebDriver no puede iniciarse.
   **Solución**: Asegúrese de que la versión de ChromeDriver coincida con la versión de Chrome y que la ruta al ejecutable sea correcta.