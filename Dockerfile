FROM openjdk:8-jre-alpine

RUN mkdir /app
 
RUN rm target/*original*.jar

COPY target/*.jar /app/app.jar

CMD java -jar /app/app.jar