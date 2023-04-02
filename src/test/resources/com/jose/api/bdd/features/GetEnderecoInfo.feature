# language: en

Feature: Testar o calculo de frete por regiao a partir de um CEP

  Scenario Outline: Obter frete por regiao a partir de um CEP
    Given que eu possua o CEP "<cep>"
    When eu chamar a rota POST "/v1/consulta-endereco" informando tal cep
    Then a tabela de endereço retornada deve conter tais informacoes:
      | cep   | rua   | complemento | bairro     | cidade   | estado   | frete   |
      | <cep> | <rua> | <complemento> | <bairro> | <cidade> | <estado> | <frete> |
    Examples:
      | cep       | rua                  | complemento | bairro                | cidade    | estado | frete |
      | 01153-000 | Rua Vitorino Carmilo |             | Barra Funda           | São Paulo | SP     | 7.85  |
      | 69075-110 | Rua Javari           |             | Distrito Industrial I | Manaus    | AM     | 20.83 |
      | 40110-080 | Avenida São Jorge    |             | Canela                | Salvador  | BA     | 15.98 |
      | 74075-340 | Rua 30 A             |             | Setor Aeroporto       | Goiânia   | GO     | 12.5  |
      | 80010-080 | Rua André de Barros  |             | Centro                | Curitiba  | PR     | 17.3  |
