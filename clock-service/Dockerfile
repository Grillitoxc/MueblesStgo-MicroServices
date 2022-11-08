FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} clock-service-0.0.1-SNAPSHOT.jar
EXPOSE 8094
ENTRYPOINT ["java","-jar","/clock-service-0.0.1-SNAPSHOT.jar"]