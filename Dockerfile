FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/mi-aplicacion.jar /app/mi-aplicacion.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]
