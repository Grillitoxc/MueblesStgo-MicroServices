FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spreadsheet-service-0.0.1-SNAPSHOT.jar
EXPOSE 8095
ENTRYPOINT ["java","-jar","/spreadsheet-service-0.0.1-SNAPSHOT.jar"]