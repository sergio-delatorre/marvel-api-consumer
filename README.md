# Marvel API Consumer

API RESTful que consume el API de Marvel Comics

## Requisitos
Para la ejecución de este proyecto se debe tener instalado:
- Java 11
- Maven

## Ejecución
### Aplicación
1. Descargar o clonar el repositorio
2. Navegar al directorio raíz del proyecto
```
$ cd ruta/al/directorio/raíz/del/proyecto
```
3. Ejecutar en consola el siguiente comando:
```
$ mvn spring-boot:run
```
4. URL para ver la documentación en Swagger:  
   [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Tests
Para ejecutar los tests usar el siguiente comando en la raiz del proyecto:
```
$ mvn test
```


## Base de datos
Se utiliza H2 como base de datos en memoria. Para acceder a la consola de H2:
1. Dirigirse a la URL [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
2. Ingresar la cadena de conexión JDBC URL como `jdbc:h2:mem:marvelapidb`
3. Utilizar `sa` como usuario y `password` como contraseña (valores del application.properties)

