# Getting Started
Reference Documentation: [Desafio.pdf](https://github.com/nekitbr/wipro-springboot-api/files/11132308/Desafio.pdf)

This project is a Maven-based Spring Boot application that requires Java 11 to be installed. To get started, follow these steps:

## Setup
1. Download Java SDK 11
2. Clone the repository
3. Open the project in your IDE
4. Download Maven dependencies
5. Run it!

# Routes
The application runs by default on port 8080 and the base path is `/v1`.  
The available routes are:

| Method | Path | Description |
| ------ | ---- | ----------- |
| POST   | v1/consulta-endereco | Returns address information based on the given CEP code |
| GET    | v1/api-docs | Swagger-based API documentation |
