# Getting Started
Reference Documentation: https://drive.google.com/file/d/1GN7PR7IE3szQ5ht7wvLJ3rMDVsTOP1Fr/view?usp=share_link  
This project is a Maven-based Spring Boot application that requires Java 11 to be installed. To get started, follow these steps:

## Setup
1. Download Java SDK 11
2. Clone the repository
3. Open the project in your IDE
4. Download Maven dependencies
5. Create an `application.properties` file under `main.resources`. The `.example` file is ready-to-go, simply rename it.

## Running the Project
You have two options to run the project:
1. Run `main.java.com.jose.api.ApiApplication` to start the Spring Boot service
2. Run the latest JAR release from the `releases` directory

## Running Tests
To run the tests, you can:
1. BDD Tests: run test classes in the `test.java.resources.com.jose.api.bdd.features.*` package
2. TDD Tests: run test classes in the `test.java.com.jose.api.tdd.controller.*` package
3. All Tests (using IntelliJ): right-click on `test.java` -> Run 'Tests' in 'Java'  
![image](https://user-images.githubusercontent.com/69054878/216898060-eb29c754-aaff-457a-a19a-93249f0033bd.png)

## Building the Application
There's already a release version available on Github, but you can build the application by running:
`mvn clean package spring-boot:repackage`  

# Routes
The application runs by default on port 8080 and the base path is `/v1`.  
The available routes are:

| Method | Path | Description |
| ------ | ---- | ----------- |
| POST   | /consulta-endereco | Returns address information based on the given CEP code |
| GET    | /api-docs | Swagger-based API documentation |
