# Burger App

![](https://github.com/matheuscostap/burgerapp/blob/main/burger.gif?raw=true)

Uma hamburgueria necessitava de um aplicativo para exibir o seu cardápio aos clientes e também dar algum destaque para determinados lanches.

Esse aplicativo tem o objetivo de resolver esse problema possibilitando a exibição do cardápio completo da hamburgueria em formato de lista, com áreas para itens em destaque e um banner no topo para comunicação em formato de imagem. Também é possível visualizar mais informações dos lanches, como informações nutricionais e informações de alérgenos.


## Tech

O projeto utiliza o padrão MVVM e possui 3 módulos: app, data e domain. Cada módulo possui seus testes unitários. Para a construção da interface foi utilizado o Jetpack Compose, e o framework de injeção de dependências escolhido foi o Hilt.

Demais bibliotecas utilizadas:

- Coil
- Coroutines
- Kotlin Flow
- Mockito
- Retrofit
- Gson

## Pontos de melhoria

- Usar mais do Flow, não apenas para substituir o LiveData, mas usar o Flow como stream de dados desde a chamada de API para fazer proveito dos operadores;
- Ajustar melhor o layout dos componentes de informações nutricionas na tela de detalhes do produto;
- Implementar o Dark Mode e fazer uso dos temas do Compose;
- Usar a biblioteca Jetpack Navigation para implementar a navegação entre as telas do app;
- Implementar tratamento de erro nas requisições para diversos tipos de status code;
- Ajustar o ripple effect dos componentes da lista de produtos.

Gostaria também de testar a solução de modularização por feature, mas optei pela modularização por camadas por já ter familiaridade.
