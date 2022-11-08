FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employee-service-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/employee-service-0.0.1-SNAPSHOT.jar"]