# PetStore API Tests con Karate

Este proyecto contiene pruebas automatizadas para la API PetStore utilizando Karate framework.

## Requisitos previos

1. Java JDK 8 o superior
2. Maven 3.6.0 o superior
3. Git

## Instrucciones paso a paso para la ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/petstore-api-test.git
cd petstore-api-test
```

### 2. Estructura del proyecto

Asegúrate de que la estructura del proyecto sea la siguiente:

```
petstore-api-test/
├── pom.xml
├── README.txt
├── conclusiones.txt
└── src/
    └── test/
        ├── java/
        │   └── petstore/
        │       ├── TestRunner.java
        │       └── users.feature
        └── resources/
            └── karate-config.js
```

### 3. Ejecutar las pruebas

Ejecuta el siguiente comando para correr las pruebas:

```bash
mvn clean test
```

### 4. Ver los reportes

Los reportes se generan en la carpeta `target/cucumber-html-reports`. Abre el archivo `overview-features.html` en un navegador para ver los resultados detallados.

```bash
open target/cucumber-html-reports/overview-features.html  # En macOS
# O
explorer target/cucumber-html-reports/overview-features.html  # En Windows
```

### 5. Descripción de los tests

Las pruebas realizan las siguientes operaciones en la API de PetStore:

1. Crear un usuario
2. Buscar el usuario creado
3. Actualizar el nombre y el correo del usuario
4. Buscar el usuario actualizado
5. Eliminar el usuario
6. Verificar que el usuario ha sido eliminado

### 6. Notas adicionales

- Se utiliza un ID y nombre de usuario fijos para las pruebas
- Se generan correos electrónicos aleatorios para evitar conflictos
- Se validan todas las respuestas de la API para asegurar que cumplen con el formato esperado