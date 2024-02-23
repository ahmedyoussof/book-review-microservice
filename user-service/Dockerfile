FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /user-service/app/src
COPY pom.xml /user-service/app
RUN mvn -f /user-service/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /user-service/app/target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/user-service.jar"]
