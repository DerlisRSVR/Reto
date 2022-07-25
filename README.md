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
* [Java]: Version OpenJDK 11
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
## SQL DB
```
BEGIN;


CREATE TABLE public.usuario
(
    codigo integer NOT NULL,
    apellidos character varying(255),
    cedula character varying(13),
    mail character varying(255),
    nombres character varying(255),
    direccion character varying(255),
    estado_usu integer,
    estado_vacunacion integer,
    fecha_nacimiento timestamp without time zone,
    fecha_vacunacion timestamp without time zone,
    num_dosis integer,
    pass character varying(255),
    "teléfono" character varying(255),
    tipo_usu integer,
    vacunafk integer,
    PRIMARY KEY (codigo)
);

CREATE TABLE public.vacuna
(
    codigo_vacuna integer NOT NULL,
    nombre_vacuna character varying(255),
    PRIMARY KEY (codigo_vacuna)
);

ALTER TABLE public.usuario
    ADD FOREIGN KEY (vacunafk)
    REFERENCES public.vacuna (codigo_vacuna)
    NOT VALID;

END;

```
