FROM openjdk:17-jdk-alpine
COPY target/book-catalog-service-0.0.1-SNAPSHOT.jar book-catalog-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/book-catalog-service.jar"]
