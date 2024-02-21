FROM openjdk:17-jdk-alpine
COPY target/configuration-server-0.0.1-SNAPSHOT.jar configuration-server.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/configuration-server.jar"]
