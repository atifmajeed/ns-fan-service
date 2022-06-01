# ns-fan-service
 This is a SpringBoot based micro-service that receives requests from clients that simulate the operation of a ceiling fan. A sample Angular UI client resides in this repository [NS Fan UI](https://github.com/atifmajeed/ns-fan-ui) that uses this service. This application provides a REST service to retrieve and update the operational state of ceiling fan
 
 The client and service work as follows:
- The UI retrieves the initial state of the fan from the service. The state of the fan comprises its speed and direction. 
- The UI allows controlling speed and direction of the fan 
- Each setting change in speed or direction results in a BE call
- This service demonstrates the use of JPA and H2 database to persist the current state
- The service populates the initial state in its database on start-up
 
## Endpoint
 * fan-state: accepts GET to return current state and PUT to save state changes. Sample URL `http://localhost:8080/fan-state` after running the service

## Architecture
* CeilingFanController - Service controller that serves as the service API
* FanState - Data model that represents fan state
* FanStateRepository - An interface to query and save the state in the database

## Resources
This SQL files get executed by the Spring framework on application start-up and are located under resources folder
* schema.sql - creates table to save the state 
* data.sql - populates table with the seed data for initial state

## Docker
* A public image of the application is available on the docker hub [atifmajeed/ns-service-ui:latest](https://hub.docker.com/layers/224023070/atifmajeed/ns-fan-service/latest/images/sha256-12e9eb2a5900d56b4de61efbe34b962fd3eceadb32228e2d72fa913058dafb2c?context=repo) to pull and run locally
* `docker pull atifmajeed/ns-fan-service:latest`
* Run the container mapping the service to port 8080: `docker run --rm -d -p 8080:8080 atifmajeed/ns-fan-service:latest`
* Open browser to access http://localhost:8080/fan-state which will JSON response from the service
* This project contains a Dockerfile. Run `docker build --tag=ns-fan-service:latest .` to build the application into a deployable docker image.

## Validation
The service uses bean level validation on data class `FanState` to ensure speed is between 0 and 3 and sends a 
400/BadRequest response if the incoming request causes validation failure.

## Local development and execution
* Clone this repository
* Install JDK 17+, set JAVA_HOME
* Run `mvnw spring-boot:run`
* Open browser to access http://localhost:8080/fan-state


## Kubernettes
This project contains deployment.yaml files to run a pod on minikube.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
