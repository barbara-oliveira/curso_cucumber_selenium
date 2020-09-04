# language: pt

@unitarios
Funcionalidade: Alugar filme
  Como um usuário
  Eu quero cadastrar alugueis de filmes
  Para controlar pecos e datas de entrega

Cenário: Não deve alugar filme sem estoque
  Dado um filme com estoque de 0 unidades
  Quando alugar
  Entao nao sera possivel por falta de estoque
  E o estoque do filme sera 0

  Cenário: Deve alugar um filme para categoria comum
    Dado um filme
    | estoque | 2 |
    | preco   | 3 |
    E que o tipo do aluguel seja comum
    Quando alugar
    Entao o preco do aluguel sera R$ 3
    E a data de entrega sera em 1 dia
    E o estoque do filme sera 1

Esquema do Cenario: Deve dar condições conforme tipo de aluguel
  Dado um filme com estoque de 2 unidades
  E que o preco do aluguel seja R$ <preco>
  E que o tipo do aluguel seja <tipoAluguel>
  Quando alugar
  Então o preco do aluguel sera R$ <valor>
  E a data de entrega sera em <qtdDias> dias
  E a pontuacao sera de <pontuacao> pontos

  Exemplos:
    | preco | tipoAluguel | valor | qtdDias | pontuacao |
    |   4   |  extendido  |   8   |    3    |     2     |
    |   4   |    comum    |   4   |    1    |     1     |

