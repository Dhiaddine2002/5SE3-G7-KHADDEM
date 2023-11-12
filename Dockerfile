FROM openjdk:11

# Set the Nexus URL and the artifact path
ARG NEXUS_URL=http://192.168.33.10:8081/repository/maven-releases
ARG ARTIFACT_PATH=tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar

# Create a directory to store the downloaded JAR
RUN mkdir /app
RUN touch testing
# Download the JAR from Nexus and copy it into the container
RUN wget -O /app/kaddem-1.0.jar $NEXUS_URL/$ARTIFACT_PATH

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/kaddem-1.0.jar"]