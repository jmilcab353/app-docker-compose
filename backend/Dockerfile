# FROM eclipse-temurin:17-jre-jammy
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]



FROM eclipse-temurin:17-jre-jammy

# Descargar e instalar dockerize
RUN apt-get update && apt-get install -y wget && \
    wget https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz && \
    tar -xzvf dockerize-linux-amd64-v0.6.1.tar.gz -C /usr/local/bin && \
    rm dockerize-linux-amd64-v0.6.1.tar.gz  # Limpiar el archivo descargado

# Copiar el archivo JAR
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Establecer el comando de entrada, primero esperar a que la base de datos esté lista y luego ejecutar la aplicación
ENTRYPOINT ["dockerize", "-wait", "tcp://db:3306", "-timeout", "30s", "java", "-jar", "/app.jar"]



# docker build -t springbootapp:1.0 .
# docker image list
# docker run -p 8080:8080 --name springapp -d -t springbootapp:1.0
# docker stop springapp
# docker start springapp
# docker stats
# docker logs -f springapp
# docker rm springapp
# docker login
# docker tag springbootapp:1.0 alansastre/springbootapp:1.0
# docker push alansastre/springbootapp:1.0

# Desde un servidor:
# docker pull alansastre/springbootapp:1.0
# docker run -p 8080:8080 --name springapp -d -t alansastre/springbootapp:1.0
# docker rmi alansastre/springbootapp:1.0