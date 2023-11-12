FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean install

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY --from=build /app/target/5SE3-G7-KHADDEM.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
