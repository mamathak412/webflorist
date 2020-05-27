FROM openjdk:8-jre-alpine

RUN mkdir /app

COPY target/*.jar /app/app.jar

CMD java -cp /app/app.jar com.web.blosom.Application