FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /rating-data-service/app/src
COPY pom.xml /rating-data-service/app
RUN mvn -f /rating-data-service/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /rating-data-service/app/target/rating-data-service-0.0.1-SNAPSHOT.jar rating-data-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/rating-data-service.jar"]

