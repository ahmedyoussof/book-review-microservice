FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /book-catalog-service/app/src
COPY pom.xml /book-catalog-service/app
RUN mvn -f /book-catalog-service/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /book-catalog-service/app/target/book-catalog-service-0.0.1-SNAPSHOT.jar book-catalog-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/book-catalog-service.jar"]
