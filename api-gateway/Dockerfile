FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /api-gateway/app/src
COPY pom.xml /api-gateway/app
RUN mvn -f /api-gateway/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /api-gateway/app/target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/api-gateway.jar"]

