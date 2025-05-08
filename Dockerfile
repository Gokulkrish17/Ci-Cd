FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY /target/cicd-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 6060

ENTRYPOINT ["java","-jar","app.jar"]