FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ns-fan-service.jar
ENTRYPOINT ["java","-jar","/ns-fan-service.jar"]