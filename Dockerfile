# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Crea un directorio en el contenedor
WORKDIR /app

# Copia el archivo JAR generado
COPY target/micro-tarea-app.jar micro-tarea-app.jar


# Expon el puerto donde corre la aplicación
EXPOSE 8002

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "micro-tarea-app.jar"]

