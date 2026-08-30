# Exercícios — Parte 2: Strings, Entrada/Saída, Condicionais, Loops, Arrays e Métodos

> 🧭 Acompanha o arquivo `02-strings-io-condicionais-loops-arrays-metodos.md`. Este é o maior bloco de exercícios de toda a coleção — é também a parte que mais fixa por repetição, então não tenha pressa.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Strings

**1. Imprimindo e medindo** ⭐
Declare uma `String` com seu nome completo e imprima o conteúdo e o `length()` dela.

**2. `==` vs. `.equals()` com literais** ⭐
Crie duas Strings com o mesmo conteúdo, ambas como literal (`"abc"`), e compare com `==` e com `.equals()`. Depois crie uma terceira com `new String("abc")` e repita as duas comparações contra a primeira.

**3. Imutabilidade na prática** ⭐
Declare `String s = "java";`. Chame `s.toUpperCase();` **sem** capturar o retorno, e imprima `s` na sequência. Depois capture o retorno numa nova variável e imprima essa nova variável.

**4. Métodos essenciais, um a um** ⭐⭐
Dada a String `"  Programação em Java  "`, aplique em sequência: `trim()`, depois `toUpperCase()`, depois `replace("A", "4")`, imprimindo o resultado depois de cada etapa.

**5. `substring` com índices** ⭐⭐
Dada `String linguagem = "JavaScript";`, use `substring` para extrair apenas `"Java"` e, separadamente, apenas `"Script"`.

**6. `split` em um nome completo** ⭐⭐
Dada `"Maria da Silva Santos"`, use `split(" ")` para separar em partes, e imprima separadamente o primeiro nome e o último sobrenome.

**7. Contando vogais** ⭐⭐⭐
Escreva um método `contarVogais(String texto)` que percorre a String caractere a caractere (`charAt`) e conta quantas vogais (maiúsculas ou minúsculas) existem.

**8. Verificando palíndromo** ⭐⭐⭐
Escreva um método `boolean ehPalindromo(String texto)` que verifica se uma palavra é a mesma lida de trás para frente (ignore diferenças de maiúsculas/minúsculas). Teste com `"arara"`, `"Ovo"` e `"java"`.

**9. `StringBuilder` na prática** ⭐⭐
Use um `StringBuilder` para montar a frase `"Java é uma linguagem orientada a objetos."` a partir de palavras separadas, usando `append()` várias vezes, e imprima o resultado final com `toString()`.

**10. Medindo a diferença de performance (na prática, não só na teoria)** ⭐⭐⭐
Escreva duas versões de um método que monta uma String com os números de `0` a `50000` separados por vírgula: uma usando `+=` dentro de um loop, e outra usando `StringBuilder`. Meça o tempo de cada uma com `System.currentTimeMillis()` (ou `System.nanoTime()`) antes e depois de cada versão, e imprima a diferença.

**11. Validador de senha simples** ⭐⭐⭐
Escreva um método `boolean senhaForte(String senha)` que retorna `true` somente se a senha tiver pelo menos 8 caracteres, `contains` pelo menos um dígito (percorrendo com `charAt` + `Character.isDigit`), e não `isBlank()`.

**12. Normalizando um nome de usuário** ⭐⭐⭐⭐
Escreva um método `gerarUsername(String nomeCompleto)` que recebe um nome completo (ex: `"Ana Paula Souza"`), remove espaços das pontas, transforma tudo em minúsculo, e substitui os espaços internos por `.` — resultado esperado: `"ana.paula.souza"`.

**13. Contador de palavras** ⭐⭐⭐
Escreva um método `contarPalavras(String texto)` que devolve quantas palavras existem numa frase (separadas por um ou mais espaços), sem usar Streams ainda (isso volta na Parte 5B, provavelmente mais simples).

**14. Comparando com e sem case** ⭐⭐
Compare `"Java"` e `"JAVA"` usando `.equals()` e depois usando `.equalsIgnoreCase()`, imprimindo os dois resultados.

---

## 2. Entrada e saída de dados

**15. Saudação com `Scanner`** ⭐
Leia o nome do usuário com `Scanner` e imprima `"Olá, [nome]!"`.

**16. `print`, `println` e `printf` lado a lado** ⭐
Usando as três formas de saída, imprima o nome, a idade e a altura de uma pessoa fixados no código, formatando a altura com 2 casas decimais via `printf`.

**17. Lendo os 4 tipos básicos** ⭐⭐
Escreva um programa que lê, em sequência, um nome (`String`), uma idade (`int`), uma altura (`double`) e se a pessoa é maior de idade (`boolean`), usando os métodos apropriados de `Scanner`.

**18. Reproduzindo o bug `nextInt()` + `nextLine()`** ⭐⭐
Escreva um programa que lê uma idade com `nextInt()` e, na sequência, um nome com `nextLine()`. Rode e observe o nome "sumir". Depois, corrija de **duas formas diferentes** (as duas mostradas na teoria): com um `nextLine()` extra para descartar o `\n`, e lendo tudo como `nextLine()` + conversão manual.

**19. Menu simples com `Scanner`** ⭐⭐⭐
Peça ao usuário para digitar um número de 1 a 3 e, conforme a escolha, leia dados diferentes (ex: 1 = ler um nome, 2 = ler dois números para somar, 3 = encerrar).

**20. Calculadora de IMC via console** ⭐⭐⭐
Leia peso (`double`) e altura (`double`) via `Scanner`, calcule o IMC (`peso / (altura * altura)`) e imprima o valor formatado com `printf` usando 2 casas decimais.

**21. Simulação de formulário de cadastro** ⭐⭐⭐⭐
Leia nome, idade e e-mail via `Scanner` e imprima um "resumo de cadastro" formatado com `printf`, no estilo `"Nome: %s | Idade: %d | E-mail: %s"`.
> 💡 *Dica:* isso é, em miniatura, o mesmo tipo de dado que futuramente vai chegar via JSON numa requisição HTTP — só que por enquanto entra pelo teclado.

---

## 3. Estruturas condicionais

**22. Classificando por idade** ⭐
Dada uma variável `idade`, use `if/else if/else` para imprimir `"Criança"`, `"Adolescente"` ou `"Adulto"`, usando as mesmas faixas do exemplo da teoria.

**23. Condição composta** ⭐
Dadas as variáveis `idade` e `possuiCarteira` (boolean), imprima `"Pode dirigir"` somente se as duas condições forem satisfeitas ao mesmo tempo.

**24. `switch` tradicional com dias da semana** ⭐⭐
Dado um `int diaSemana` (1 a 7), use `switch` tradicional (com `break`) para imprimir o nome do dia. Inclua um `default` para valores inválidos.

**25. Provocando o fall-through de propósito** ⭐⭐
Reescreva o exercício anterior **removendo** um dos `break` de propósito. Rode com um valor que "cai" para o case seguinte e observe o comportamento. Depois, coloque o `break` de volta.

**26. Switch moderno (seta)** ⭐⭐
Reescreva o exercício 24 usando a sintaxe moderna de `switch` (com `->`), retornando o nome do dia como valor de uma expressão em vez de imprimir dentro de cada `case`.

**27. Ternário para status** ⭐
Dada uma `idade`, use o operador ternário para atribuir `"maior de idade"` ou `"menor de idade"` a uma `String status`, e imprima.

**28. Classificação de nota com ternário aninhado (com cautela!)** ⭐⭐⭐
Dada uma nota de `0` a `10`, classifique como `"Aprovado"` (nota ≥ 7), `"Recuperação"` (nota ≥ 5) ou `"Reprovado"`. Primeiro resolva com `if/else if/else`; depois, só como exercício de leitura, tente reescrever com ternários encadeados e compare qual versão é mais legível.

**29. Validador de triângulo** ⭐⭐⭐
Dados três valores `double` representando lados de um triângulo, use condicionais para determinar se eles formam um triângulo válido (a soma de quaisquer dois lados deve ser maior que o terceiro) e, se for válido, classifique como equilátero, isósceles ou escaleno.

**30. Calculadora de frete por faixa de peso** ⭐⭐⭐⭐
Dado o peso de um pacote (`double`), calcule o valor do frete usando faixas (ex: até 1kg = R$10, até 5kg = R$25, até 10kg = R$45, acima disso = R$45 + R$3 por kg extra). Use `if/else if` encadeado.

---

## 4. Estruturas de repetição

**31. Contando de 1 a 10** ⭐
Use um `for` tradicional para imprimir os números de 1 a 10.

**32. Contagem regressiva** ⭐
Use um `while` para imprimir uma contagem regressiva de 10 até 1, seguida de `"Vai!"`.

**33. Pelo menos uma vez** ⭐
Escreva um `do-while` que sempre imprime "Executei!" pelo menos uma vez, mesmo com uma condição inicial falsa — e explique num comentário por que um `while` comum não teria esse comportamento no mesmo cenário.

**34. Somando os pares de 1 a 100** ⭐⭐
Use um `for` para somar todos os números pares entre 1 e 100 (inclusive), e imprima o total.

**35. Tabuada completa** ⭐⭐
Peça um número via `Scanner` e imprima a tabuada dele de 1 a 10, uma linha por multiplicação (ex: `"7 x 1 = 7"`).

**36. `for-each` em um array de nomes** ⭐
Dado `String[] nomes = {"Ana", "Bruno", "Carla"};`, imprima cada nome usando `for-each`.

**37. `break` e `continue` juntos** ⭐⭐
Percorra os números de 1 a 20 com um `for`: pule (com `continue`) todos os múltiplos de 3, e pare completamente (com `break`) assim que encontrar um número maior que 15.

**38. Loop infinito controlado** ⭐⭐
Escreva um menu com `while (true)` que só sai do loop quando o usuário digita `"sair"`, usando `break` para encerrar.

**39. Números primos até N** ⭐⭐⭐
Peça um número `N` e imprima todos os números primos entre 2 e `N`, usando loops aninhados (um loop externo percorrendo os candidatos, um loop interno testando divisibilidade).

**40. Sequência de Fibonacci** ⭐⭐⭐
Peça uma quantidade `N` e imprima os primeiros `N` números da sequência de Fibonacci, usando um `for` e variáveis auxiliares (sem recursão ainda).

**41. Menu de console persistente** ⭐⭐⭐⭐
Monte um menu com `switch` + `while`: `"1 — Cadastrar produto"`, `"2 — Listar produtos"`, `"3 — Sair"`. O programa deve voltar a mostrar o menu depois de cada opção, até o usuário escolher sair. Use um array (ou, se preferir, um `ArrayList` — Parte 4) para guardar os produtos cadastrados nessa sessão.

---

## 5. Arrays

**42. Declarando e populando** ⭐
Declare um `int[]` de 5 posições, atribua um valor a cada posição individualmente (por índice), e imprima todas usando um `for` tradicional.

**43. `length` sem parênteses** ⭐
Dado `int[] numeros = {5, 10, 15, 20};`, imprima o `length` do array e o último elemento usando `numeros.length - 1` como índice.

**44. Somando e tirando a média** ⭐⭐
Dado `double[] notas = {7.5, 8.0, 6.5, 9.0, 10.0};`, calcule e imprima a soma e a média usando um `for` tradicional.

**45. Maior e menor elemento** ⭐⭐
Dado um array de `int` com pelo menos 6 valores, encontre o maior e o menor elemento **sem usar métodos prontos** (percorrendo e comparando manualmente).

**46. Invertendo um array** ⭐⭐
Dado um array de `int`, crie um segundo array com os mesmos elementos em ordem invertida, sem usar nenhuma classe utilitária pronta — só um loop.

**47. Provocando `ArrayIndexOutOfBoundsException`** ⭐⭐
Dado `int[] numeros = {1, 2, 3};`, tente acessar `numeros[3]` de propósito, leia a exceção lançada, e depois corrija verificando o índice antes de acessar.

**48. Contando ocorrências** ⭐⭐⭐
Dado um array de `String` com nomes repetidos, escreva um método que recebe o array e um nome, e devolve quantas vezes aquele nome aparece.

**49. Matriz simples (array bidimensional)** ⭐⭐⭐
Crie uma matriz `int[3][3]`, preencha com valores de 1 a 9 usando loops aninhados, e imprima como uma grade (linha por linha, com espaço entre os números).

**50. Soma da diagonal principal** ⭐⭐⭐
Usando a matriz do exercício anterior (ou qualquer matriz quadrada `NxN`), calcule a soma dos elementos da diagonal principal (onde o índice da linha é igual ao índice da coluna).

**51. Arrays paralelos: produto e preço** ⭐⭐⭐⭐
Crie dois arrays — `String[] produtos` e `double[] precos` — com os mesmos índices representando o mesmo produto. Escreva um método que recebe os dois arrays e um índice, e devolve uma String formatada como `"Produto: Teclado - Preço: R$ 150.00"`.
> 💡 *Dica:* é uma prévia (bem rústica) do que um "repositório" vai fazer futuramente com objetos de verdade, na Parte 3B.

---

## 6. Métodos

**52. Método simples com retorno** ⭐
Escreva um método `somar(int a, int b)` que devolve a soma, e chame-o a partir do `main` imprimindo o resultado.

**53. Método `void`** ⭐
Escreva um método `void saudar(String nome)` que apenas imprime uma saudação, sem devolver nada.

**54. Sobrecarga (overloading)** ⭐⭐
Escreva três versões de um método `somar`: uma para dois `int`, uma para dois `double`, e uma para três `int`. Chame as três a partir do `main` e confirme que o Java escolhe a versão certa sozinho.

**55. Escopo de variável local** ⭐⭐
Escreva um método que declara uma variável local, e tente (de propósito) acessar essa variável fora do método, no `main`. Leia o erro de compilação e explique, num comentário, o porquê.

**56. Pass-by-value com primitivo** ⭐⭐
Escreva um método `dobrar(int x)` que multiplica o parâmetro por 2 **dentro** do método. Chame-o passando uma variável do `main` e comprove que a variável original não mudou.

**57. Pass-by-value com objeto — reatribuindo** ⭐⭐⭐
Escreva um método que recebe um objeto seu (ex: `Pessoa`) e tenta "trocá-lo" reatribuindo o parâmetro para um objeto novo dentro do método. Comprove que a variável original, no `main`, não muda.

**58. Pass-by-value com objeto — mutando** ⭐⭐⭐
Escreva um segundo método que recebe o mesmo tipo de objeto e alterA um atributo dele via setter (ou acesso direto, se ainda não tiver encapsulado). Comprove que, desta vez, a variável original **muda**. Coloque os dois métodos (este e o do exercício 57) lado a lado no mesmo programa e comente a diferença.

**59. Método que recebe e devolve um array** ⭐⭐⭐
Escreva um método `dobrarValores(int[] numeros)` que devolve um **novo** array com cada valor multiplicado por 2, sem alterar o array original.

**60. Recursão: fatorial** ⭐⭐⭐
Escreva um método recursivo `fatorial(int n)` (sem loop) que calcula o fatorial de `n`. Identifique, num comentário, qual é o caso-base que impede a recursão infinita.

**61. Recursão: Fibonacci recursivo** ⭐⭐⭐⭐
Reescreva o exercício 40 (Fibonacci) de forma recursiva, sem loop algum. Compare, num comentário, o que aconteceria em termos de desempenho ao pedir o 40º termo dessa forma, versus a versão com loop.

**62. Validação de cadastro com métodos separados** ⭐⭐⭐⭐
Simule uma validação de cadastro dividida em métodos pequenos: `boolean nomeValido(String nome)`, `boolean idadeValida(String idadeTexto)` e `boolean emailValido(String email)`. No `main`, chame os três para um conjunto de dados fixos e imprima uma mensagem específica para cada regra que falhar.
> 💡 *Dica:* mais à frente, no Spring, essas mesmas regras viram anotações como `@NotBlank` e `@Email` — a lógica por trás é exatamente essa.

---

## Fechando

Você acabou de praticar o "núcleo procedural" de Java inteiro — Strings, condicionais, loops, arrays e métodos, incluindo o ponto mais sutil desta parte: **pass-by-value** (exercícios 56 a 58). Releia esses três exercícios quantas vezes precisar; eles voltam a aparecer, com outra roupagem, em praticamente toda a Parte 3.

Quando se sentir confiante, siga para `03a-exercicios-poo-classes-encapsulamento-heranca-polimorfismo-abstracao.md`.
