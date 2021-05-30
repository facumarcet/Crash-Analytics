# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#FROM alpine:latest
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11
ADD target/db-handler.jar db-handler.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "db-handler.jar"]

#CMD ["/bin/sh"]
