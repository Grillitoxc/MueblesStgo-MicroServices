FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/eureka-service-0.0.1-SNAPSHOT.jar"]