FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-service-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/config-service-0.0.1-SNAPSHOT.jar"]