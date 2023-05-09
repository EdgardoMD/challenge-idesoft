FROM openjdk:11
ARG JAR_FILE=target/challenge-idesoft-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]