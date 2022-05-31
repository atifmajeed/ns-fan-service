FROM openjdk:18
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ns-fan-service.jar
ENTRYPOINT ["java","-jar","/ns-fan-service.jar"]