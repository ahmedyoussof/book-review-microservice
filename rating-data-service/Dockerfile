FROM openjdk:17-jdk-alpine
COPY target/rating-service-0.0.1-SNAPSHOT.jar rating-service.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/rating-service.jar"]
