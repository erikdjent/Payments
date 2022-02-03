FROM openjdk:8-jdk-alpine
LABEL maintainer="erikVelazquez.com"
RUN addgroup -S payment && adduser -S payment -G payment
USER payment:payment
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} payments-1.0.jar
ENTRYPOINT ["java","-jar","/payments-1.0.jar"]