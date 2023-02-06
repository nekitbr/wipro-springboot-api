# Getting Started
* Reference Documentation
https://drive.google.com/file/d/1GN7PR7IE3szQ5ht7wvLJ3rMDVsTOP1Fr/view?usp=share_link

## Setup:
- Download java version 11
- Clone repository
- Open the project on your IDE
- Download maven dependencies
- Create an application.properties under main.resources (the .example is ready-to-go, just rename it)
- Create an application.properties under test.resources (the .example is ready-to-go, just rename it)

### To run the project:
- Run main.java.com.jose.api.ApiApplication to start your spring-boot service

### To run the BDD tests:
- Run test.java.resources.com.jose.api.bdd.features.*

### To run the TDD tests:
- Run test.java.com.jose.api.tdd.controller.*

### To run all tests (with intelliJ):
- Right click on test.java -> Run 'Tests' in 'Java'  
![image](https://user-images.githubusercontent.com/69054878/216855164-e029e3a9-f603-4930-8f80-f64d6a05c66e.png)

### To build the application:
* There's already a release version on github, but here's how it's done:
- run "mvn clean package spring-boot:repackage"

# Routes  
* BasePath is "/v1"

| Method  | Path | Description |
| ------------- | ------------- | ----------- |
| POST  | /v1/consulta-endereco | Returns address info based on given cep code |
| GET  | /v1/api-docs | Swagger based API Documentation |
