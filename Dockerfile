FROM openjdk:21-jdk
LABEL maintainer="kat@example.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]