FROM openjdk:17-jdk-alpine
COPY target/book-info-service-0.0.1-SNAPSHOT.jar book-info-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/book-info-service.jar"]
