# Utilisation de l'image officielle OpenJDK en tant qu'image de base
FROM openjdk:11-jre-slim

# Copier le fichier JAR Spring Boot dans le conteneur
COPY target/khaddem-4.0.jar /app.jar

# Port exposé par votre application Spring Boot
EXPOSE 8089

# Commande pour exécuter l'application Spring Boot
CMD ["java", "-jar", "/app.jar"]