# Utilisation d'une image OpenJDK légère
FROM openjdk:17-jdk-slim

LABEL authors="Fabulous"

# Exposer le port utilisé par l'application Web (modifie si nécessaire)
EXPOSE 9090

# Définition du répertoire de travail
WORKDIR /app

# Copie du fichier JAR de ton application web
COPY target/DemoSpringBoot_WebApp-0.0.1-SNAPSHOT.jar /app/DemoSpringBoot_WebApp-0.0.1-SNAPSHOT.jar

# Démarrer l'application Spring Boot
CMD ["java", "-jar", "TonApplicationWeb-0.0.1-SNAPSHOT.jar"]
