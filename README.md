Esto levantará un contenedor de MySQL con las siguientes credenciales:

- **Usuario:** root
- **Contraseña:** rootpassword
- **Base de datos:** app_db

## Paso 2: Configurar el archivo `application.yml`

Asegúrate de que el archivo `src/main/resources/application.yml` tenga la siguiente configuración:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/app_db
    username: root
    password: rootpassword
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect
