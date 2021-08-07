FROM openjdk:14-alpine
VOLUME /tmp
COPY ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]