# language: pt

Funcionalidade: Alugar filme
  Como um usuário
  Eu quero cadastrar alugueis de filmes
  Para controlar pecos e datas de entrega

  Cenário: Não deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Entao nao sera possivel por falta de estoque
    E o estoque do filme sera 0

  Cenário: Deve dar condições especiais para categoria extendida
    Dado um filme com estoque de 2 unidades
    E que o preco do aluguel seja R$ 4
    E que o tipo do aluguel seja extendido
    Quando alugar
    Então o preco do aluguel sera R$ 8
    E a data de entrega sera em 3 dias
    E a pontuacao sera de 2 pontos

  Cenário: Deve alugar um filme para categoria comum
    Dado um filme com estoque de 2 unidades
    E que o preco do aluguel seja R$ 3
    E que o tipo do aluguel seja comum
    Quando alugar
    Entao o preco do aluguel sera R$ 3
    E a data de entrega sera em 1 dia
    E o estoque do filme sera 1