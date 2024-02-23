FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY src /configuration-server/app/src
COPY pom.xml /configuration-server/app
RUN mvn -f /configuration-server/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /configuration-server/app/target/configuration-server-0.0.1-SNAPSHOT.jar configuration-server.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/configuration-server.jar"]
