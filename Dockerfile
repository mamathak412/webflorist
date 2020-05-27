FROM openjdk:8-jre-alpine

RUN mkdir /app

COPY target/WebFlorist-1.0.jar /app/app.jar

CMD java -jar /app/app.jar