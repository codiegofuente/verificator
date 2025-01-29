## Descripción

Este proyecto consta de una aplicación Spring Boot que proporciona un servicio REST para obtener un listado de lecturas sospechosas.

## Ficheros

Los datos utilizados se cargan desde los ficheros que se encuentran en el directorio src/main/resources/files y en la ejecución se usa el fichero indicado (2016-readings.csv, 2016-readings.xml). Los ficheros (test.csv y test.xml) son unicamente utilizados para los test.

## Endpoint REST

El servicio REST expone el siguiente endpoint:

- **URL**: `/suspiciousReadings`
- **Método**: `GET`
- **Parámetros de entrada**:
    - `fileName` (Nombre del fichero)

## Ejecutar el Proyecto

1. **Clonar el repositorio**:
    ```
    git clone https://github.com/codiegofuente/verificator.git
    cd verificator
    ```

2. **Construir el proyecto**:
    ```
    mvn clean install
    ```

3. **Ejecutar la aplicación**:
    ```
    mvn spring-boot:run
    ```

4. **Ejecutar los tests**:
    ```
    mvn test
    ```

## Requisitos

- Java 17
- Maven
- IDE recomendado: IntelliJ IDEA
