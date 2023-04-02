# language: en

Feature: Retorno de um endereço e frete regional por estado a partir de um CEP

  Scenario Outline: Testar obter endereco e frete a partir de um CEP
    Given que eu possua o CEP "<cep>"
    When eu chamar a rota POST "/consulta-endereco" informando tal cep
    Then a tabela de endereço retornada deve conter tais informacoes:
      | cep   | rua   | complemento | bairro     | cidade   | estado   | frete   |
      | <cep_esperado> | <rua> | <complemento> | <bairro> | <cidade> | <estado> | <frete> |
    Examples:
      | cep       | cep_esperado | rua                          | complemento         | bairro   | cidade               | estado | frete |
      | 01001-000 | 01001-000    | Praça da Sé                  | lado ímpar          | Sé       | São Paulo            | SP     | 7.85  |
      | 69620-970 | 69620-970    | Rua dos Andradas             | 38                  | Centro   | Amaturá              | AM     | 20.83 |
      | 46690-970 | 46690-970    | Praça Camerino Novais        | 16                  | Centro   | Abaíra               | BA     | 15.98 |
      | 73950-970 | 73950-970    | Avenida Senador Ramos Caiado | s/n Quadra 1 Lote 2 | Ipiranga | Alvorada do Norte    | GO     | 12.5  |
      | 98400-970 | 98400-970    | Rua do Comércio              | 302                 | Centro   | Frederico Westphalen | RS     | 17.3  |
