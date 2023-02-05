# language: en

Feature: Retrieve address info based on Brazilian Zip Code (CEP)

  @Include
  Scenario: Successfully get address info
    Given I have access to the API with POST method using URL /v1/consultar-endereco
    When I make a POST request with the following JSON body:
      | cep | 99010001 |
    Then I should receive a response with HTTP status 200

  @Include
  Scenario: Successful request with nonexistent CEP
    Given I have access to the API with POST method using URL /v1/consultar-endereco
    When I make a POST request with the following JSON body:
      | cep | 99991111 |
    Then I should receive a response with HTTP status 404

  @Include
  Scenario: Bad Request with wrong cep format
    Given I have access to the API with POST method using URL /v1/consultar-endereco
    When I make a POST request with the following JSON body:
      | cep | asddasdd |
    Then I should receive a response with HTTP status 400
