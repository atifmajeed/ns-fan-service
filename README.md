# ns-fan-service
 A SpringBoot based micro-service to receive requests from clients that simulate the operation of a ceiling fan. A sample Angular UI client resides in the repository [NS Fan UI](https://github.com/atifmajeed/ns-fan-ui) that uses this service. This application provides a REST service to retrieve and update the operational state of ceiling fan
 
 The client and service work as follows:
- The UI retrieves the initial state of the fan from the service. The state of the fan comprises its speed and direction. 
- The UI allows controlling speed and direction of the fan 
- Each setting change in speed or direction results in a BE call
- This service uses JPA and H2 database to persist the current state
- The service populates the initial state in its database on startup
 
## Architecture
* CeilingFanController - service end point that serves as the service API
* FanState - Data model that represents fan state
* FanStateRepository - An interface to query and save the state in the database

## Resources
* schema.sql - creates table to save the state 
* data.sql - populates table with the seed data for initial state

## Docker
* A public image of the application is available on the docker hub [atifmajeed/ns-service-ui:latest](https://hub.docker.com/layers/224023070/atifmajeed/ns-fan-service/latest/images/sha256-12e9eb2a5900d56b4de61efbe34b962fd3eceadb32228e2d72fa913058dafb2c?context=repo) to pull and run locally
* `docker pull atifmajeed/ns-fan-service:latest`
* Run the container: `docker run --rm -d -p 8080:8080 atifmajeed/ns-fan-service:latest`
* Open browser to access http://localhost:8080/fan-state which will JSON response from the service
* This project contains a Dockerfile. Run `docker build --tag=ns-fan-service:latest .` to build the application into a deployable docker image.


## Local development and execution
* Clone this repository
* Run `mvnw spring-boot:run`
* Open browser to access http://localhost:8080/fan-state

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)