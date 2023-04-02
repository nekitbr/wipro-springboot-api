# Getting Started
<details>
<summary>
:brazil:
</summary>
Documentação de referência: [Desafio.pdf](https://github.com/nekitbr/wipro-springboot-api/files/11132308/Desafio.pdf)

Este projeto é uma aplicação Spring Boot baseada em Maven que requer a instalação do Java 11. Para começar, siga estes passos:

## Configuração
1. Baixe o Java SDK 11
2. Clone o repositório
3. Abra o projeto em seu IDE
4. Baixe as dependências do Maven
5. Execute a aplicação!

# Rotas
A aplicação é executada por padrão na porta 8080 e o caminho base é `/v1`.
As rotas disponíveis são:

| Método | Caminho | Descrição |
| ------ | ------ | --------- |
| POST   | v1/consulta-endereco | Retorna informações de endereço com base no código CEP fornecido |
| GET    | v1/api-docs | Documentação de API baseada em Swagger |

# Sobre os testes:
- Testes unitários:
  - Feitos em estilo TDD.
- Testes de integração:
  - Feitos em estilo BDD com Cucumber.
  - Usam anotações em inglês com descrições em português para evitar problemas de codificação que possam afetar beans como "Então" (When).
</details>

<details>
<summary>
:us:
</summary>
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

# About the tests:  
 - Unit tests:  
     - Made in TDD style.
 - Integration tests:  
     - Made in BDD style with cucumber.  
     - Uses english annotations with portuguese descriptions to avoid bad encondig to ruin beans like "Então" (When)
</details>
