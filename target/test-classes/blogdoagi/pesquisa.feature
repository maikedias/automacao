Feature: Automação testes

  Scenario: Validar mensagem de registros não encontrados
    Given que estou no blog da agi
    And que clico na lupa de pesquisa
    When pesquiso pelo registro "$@#$%$%@#$@&%*&*&"
    And clico no botão pesquisar
    Then deve retornar mensagem "Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes."

  Scenario: Validar busca por texto
    Given que estou no blog da agi
    And que clico na lupa de pesquisa
    When pesquiso pelo registro "Esquema funciona como uma pirâmide financeira e faz muita gente perder dinheiro"
    And clico no botão pesquisar
    Then deve retornar registro com o título "Por que o Grupo de Pix de 1 Real é uma cilada e você deve fugir dele"