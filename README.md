# Spring User API

## Descripción

Este proyecto Spring Boot proporciona dos servicios:

1. **User Service**: Consume una API externa para obtener una lista de usuarios y la expone mediante un endpoint.
2. **Palindrome Service**: Recibe un JSON con un parámetro de cadena y devuelve información sobre si la cadena es un palíndromo, su longitud, y la longitud de los caracteres especiales.

## Configuración

1. Clona el repositorio.
2. Navega al directorio del proyecto.
3. Usa el comando `mvn spring-boot:run` para ejecutar la aplicación.

## Endpoints

### User Service

- **GET** `/api/users`

  Obtiene una lista de usuarios de una API externa.

### Palindrome Service

- **POST** `/api/palindrome`

  **Request Body**:
  ```json
  {
    "palindromo": "radar"
  }

- **POST** `/api/palindrome`

  **Response Body**:
  ```json
  {
    "lengthCadena": 5,
    "isPalindromo": true,
    "lengthCaracteresEspeciales": 0
  }

## Ejecución de Pruebas
Asegúrate de que el servidor de pruebas esté en funcionamiento.
Usa mvn test para ejecutar las pruebas unitarias.

## Requisitos
JDK 11 o superior
Maven 3.6 o superior

Contacto
Para más información, contacta a electryxs@gmail.com.