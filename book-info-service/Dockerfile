FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /book-info-service/app/src
COPY pom.xml /book-info-service/app
RUN mvn -f /book-info-service/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /book-info-service/app/target/book-info-service-0.0.1-SNAPSHOT.jar book-info-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/book-info-service.jar"]
