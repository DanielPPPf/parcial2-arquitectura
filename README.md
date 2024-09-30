# Parcial 2 - Arquitectura

Este proyecto está diseñado para correr con una base de datos MySQL utilizando Docker. A continuación se explican los pasos para ejecutar la aplicación localmente.

## Requisitos

- Docker
- Java 17+
- Gradle

## Paso 1: Crear y correr el contenedor de MySQL

Primero, debemos levantar un contenedor de MySQL. Ejecuta el siguiente comando:

```bash
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=app_db -p 3306:3306 -d mysql:latest
