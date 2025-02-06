FROM openjdk:21-jdk-slim
LABEL authors="Abderrazzak AIT MOUHOU"
EXPOSE 9090
ADD target/delivery-tracking-kata.jar delivery-tracking-kata.jar

ENTRYPOINT ["java", "-jar","/delivery-tracking-kata.jar"]