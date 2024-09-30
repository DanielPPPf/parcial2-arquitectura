1. Clonar Repositorio:

   En una terminal de git bash:<br>
    git clone https://github.com/DanielPPPf/parcial2-arquitectura
   
2. Crear un contenedor mysql con las propiedades de la aplicación: <br>
  docker run --name mysql-yms -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=yms -e MYSQL_USER=yms_user -e MYSQL_PASSWORD=yms_clave -p 3306:3306 -d mysql:5.7

3. Correr la aplicación: <br>
  ./gradlew bootRun


Crear Dockerfile:

# 1. Usar una imagen base oficial de Java 11 (o la versión de Java que estés usando)
FROM openjdk:11-jre-slim

# 2. Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# 3. Copiar el archivo JAR generado al contenedor
COPY target/mi-aplicacion.jar /app/mi-aplicacion.jar

# 4. Exponer el puerto que utiliza la aplicación (8080 en este caso)
EXPOSE 8080

# 5. Comando para ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]

Crear imagen de docker:

docker build -t parcial2 .

docker run -p 8080:8080 parcial2


