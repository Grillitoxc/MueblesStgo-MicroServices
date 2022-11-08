FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} extrahours-service-0.0.1-SNAPSHOT.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","/extrahours-service-0.0.1-SNAPSHOT.jar"]