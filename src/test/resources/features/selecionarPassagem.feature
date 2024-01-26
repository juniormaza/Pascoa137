##language: pt
#  Funcionalidade: Selecionar Passagem
#    Cenário: Selecionar Passagem com Sucesso
#      Dado que acesso site Blazedemo
#      Quando seleciono a origem como "São Paolo" e destino "Berlin"
#      E clico em Procurar Voo
#      Então exibe a frase indicando voo sera entre "São Paolo" e "Berlin"

 Feature: Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso site Blazedemo
    When seleciono a origem como "São Paolo" e destino "Berlin"
    And clico em Procurar Voo
    Then exibe a frase indicando voo sera entre "São Paolo" e "Berlin"