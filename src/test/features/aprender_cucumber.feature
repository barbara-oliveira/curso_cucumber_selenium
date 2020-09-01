# language: pt
Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar critérios de aceitação

  @ignore
  Cenário: Deve executar especificação
    Dado que criei o arquivo corretamente
    Quando executa-lo
    Então a especificacao deve finalizar com sucesso

  Cenário: Deve incrementar o contador
    Dado que o valor do contador e 15
    Quando eu incrementar em 3
    Então o valor do contador sera 18

  Cenário: Deve incrementar o contador
    Dado que o valor do contador e 123
    Quando eu incrementar em 33
    Então o valor do contador sera 156