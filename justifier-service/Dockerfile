FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} justifier-service-0.0.1-SNAPSHOT.jar
EXPOSE 8093
ENTRYPOINT ["java","-jar","/justifier-service-0.0.1-SNAPSHOT.jar"]