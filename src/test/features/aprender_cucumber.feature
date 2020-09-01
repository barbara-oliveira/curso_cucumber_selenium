# language: pt
Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar critérios de aceitação

  @ignore
  Cenário: Deve executar especificação
    Dado que criei o arquivo corretamente
    Quando executa-lo
    Então a especificação deve finalizar com sucesso

  Cenário: Deve incremetar o contador
    Dado que o valor do contador é 15
    Quando eu incrementar em 3
    Então o valor do contador será 18

  Cenário: Deve incremetar o contador
    Dado que o valor do contador é 123
    Quando eu incrementar em 33
    Então o valor do contador será 156