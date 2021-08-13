FROM openjdk:14-alpine
VOLUME /tmp
COPY ./target/*.jar app.jar
EXPOSE 80
CMD ["java","-jar","/app.jar"]