1. Clonar Repositorio:

   En una terminal de git bash:<br>
    git clone https://github.com/DanielPPPf/parcial2-arquitectura
   
2. Crear un contenedor mysql con las propiedades de la aplicación: <br>
  docker run --name mysql-yms -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=yms -e MYSQL_USER=yms_user -e MYSQL_PASSWORD=yms_clave -p 3306:3306 -d mysql:5.7

3. Correr la aplicación: <br>
  ./gradlew bootRun
