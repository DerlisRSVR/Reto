# Reto
## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Construcción](#collaboration)
4. [Ejecución](#faqs)
### General Info
***
La aplicación está realizada en Java usando spring boot,jpa,hibernate. Se uso PosgreSQL como base de datos, la base de datos fue creada en CodeFirst. Se ha procurado
el orden de los paquetes de la aplicación y generar el código de una manera entendible.

## Technologies
***
A list of technologies used within the project:
* [Spring Boot]: Versión 2.7.2
* [Maven]: 
* [JPA]: 
* [Java]: Version JDK 11
* [PostgreSQL]: Version 13.2
* [Hibernate] 5.6.10
* [Swagger openapi] 1.6.4
## Construcción
***
```
La apliación fue construida desde Spring Initializr
Project Maven
Language Java 11
Spring Boot 
Packaging  Jar


Dependencias 
Spring Boot DevTools 
PostgreSQL Driver 
Lombok 
Spring Data JPA 
$
El nombre de la base de datos es RetoDB

Url de la aplicación en GitHub
https://github.com/DerlisRSVR/Reto.git
$ gh repo clone DerlisRSVR/Reto


```

## Ejecución
***
```
Url de la Api
Mostrar e Insertar
http://localhost:8080/Usuarios
Editar
http://localhost:8080/Usuarios?codigo=#
Eliminar
http://localhost:8080/Usuarios/Eliminar?codigo=#
Se puede manejar de una mejor manera desde Swagger
http://localhost:8080/swagger-ui.html

```
