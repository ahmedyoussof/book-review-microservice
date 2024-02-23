FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /discovery-service/app/src
COPY pom.xml /discovery-service/app
RUN mvn -f /discovery-service/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /discovery-service/app/target/discovery-service-0.0.1-SNAPSHOT.jar discovery-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/discovery-service.jar"]
