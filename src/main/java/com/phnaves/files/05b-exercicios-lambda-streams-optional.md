# Exercícios — Parte 5B: Lambda, Stream API e Optional

> 🧭 Acompanha o arquivo `05b-lambda-streams-optional.md`. É o trio que mais muda a "cara" do Java que você vai ler em projetos Spring reais — vale muito a repetição aqui.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Lambda e interfaces funcionais

**1. Sua primeira lambda** ⭐
Escreva uma lambda implementando `Runnable` (interface funcional com um único método `run()`, sem parâmetros e sem retorno) que imprime uma mensagem, e execute-a chamando `.run()`.

**2. `Predicate<T>` — uma condição como valor** ⭐
Escreva uma lambda implementando `Predicate<Integer>` que verifica se um número é positivo. Teste com `test()` para alguns valores.

**3. `Function<T, R>` — uma transformação como valor** ⭐
Escreva uma `Function<String, Integer>` que devolve o tamanho de uma String, e aplique com `.apply(...)` a algumas palavras.

**4. `Consumer<T>` — uma ação como valor** ⭐
Escreva um `Consumer<String>` que imprime o texto recebido em maiúsculo, e chame com `.accept(...)`.

**5. `Supplier<T>` — fornecendo um valor sob demanda** ⭐
Escreva um `Supplier<Double>` que devolve um número aleatório (`Math.random()`), e chame com `.get()` algumas vezes seguidas, confirmando que o valor muda a cada chamada.

**6. Sua própria interface funcional** ⭐⭐
Crie uma interface funcional `Operacao` (anotada com `@FunctionalInterface`) com um método `int aplicar(int a, int b)`. Implemente 3 lambdas diferentes com ela: soma, subtração e multiplicação.

**7. Lambda com corpo de bloco** ⭐⭐
Escreva uma lambda (usando qualquer uma das interfaces funcionais já usadas acima) cujo corpo tenha mais de uma linha, exigindo chaves `{ }` e um `return` explícito.

**8. Method reference — para método estático** ⭐⭐
Reescreva a lambda do Exercício 3 (`Function<String, Integer>`) usando method reference no lugar da lambda: `String::length`.

**9. Method reference — para método de instância e construtor** ⭐⭐
Escreva um `Consumer<String>` usando `System.out::println` como method reference, e um `Supplier<ArrayList<String>>` usando `ArrayList::new`.

**10. Lambda como parâmetro de método** ⭐⭐⭐
Escreva um método `processar(List<Integer> lista, Predicate<Integer> condicao)` que percorre a lista e imprime apenas os elementos que satisfazem a condição recebida. Chame-o duas vezes, passando lambdas diferentes (ex: números pares, números maiores que 10).

---

## 2. Stream API

**11. `for` tradicional vs. Stream, lado a lado** ⭐⭐
Dada uma `List<String>` de nomes, filtre os que têm mais de 4 letras e converta para maiúsculo, primeiro com um `for` tradicional (guardando o resultado num `ArrayList` novo), depois com um único encadeamento de Stream (`filter` + `map` + `collect`). Compare a legibilidade das duas versões.

**12. `filter` + `collect`** ⭐
Dada uma `List<Integer>`, use `stream().filter()` e `collect()` para obter apenas os números pares.

**13. `map` — transformando cada elemento** ⭐
Dada uma `List<String>` de nomes, use `map()` para gerar uma nova lista com o tamanho (`length()`) de cada nome.

**14. `sorted()` natural e com `Comparator`** ⭐⭐
Dada uma `List<Produto>` (nome, preço), use `sorted()` para ordenar por preço (natural, se `Produto` implementar `Comparable` — Parte 5A) e, separadamente, `sorted(Comparator.comparing(...))` para ordenar por nome.

**15. `distinct()` na prática** ⭐⭐
Dada uma `List<String>` com nomes repetidos, use `stream().distinct().collect(...)` para remover as duplicatas, e compare com a abordagem de `HashSet` da Parte 4 — os resultados batem?

**16. `limit()` — top N** ⭐⭐
Dada uma `List<Produto>` ordenada por preço decrescente, use `limit(3)` para obter só os 3 mais caros.

**17. `forEach` como operação terminal** ⭐
Use `forEach` (com method reference, `System.out::println`) para imprimir cada elemento de uma lista, sem precisar de `collect`.

**18. `reduce` para somar** ⭐⭐⭐
Dada uma `List<Produto>`, use `reduce` (não `mapToDouble().sum()`) para calcular o valor total do carrinho, entendendo o papel do valor inicial e da função de combinação.

**19. `mapToDouble().sum()` — a forma idiomática de somar** ⭐⭐
Repita o exercício anterior usando `mapToDouble(Produto::getPreco).sum()`, e compare o resultado com o do `reduce`.

**20. `anyMatch`, `allMatch`, `noneMatch`** ⭐⭐
Dada uma `List<Produto>`, verifique: existe algum produto acima de R$1000 (`anyMatch`)? Todos os produtos custam menos de R$5000 (`allMatch`)? Nenhum produto tem preço zero ou negativo (`noneMatch`)?

**21. `findFirst()` devolvendo `Optional`** ⭐⭐
Use `stream().filter(...).findFirst()` para buscar o primeiro produto de uma lista cujo preço seja maior que um valor específico, e trate o `Optional` resultante com `ifPresent(...)`.

**22. `count()`** ⭐
Conte quantos produtos de uma lista custam mais de R$100, usando `stream().filter().count()`.

**23. `Collectors.groupingBy` — agrupando por categoria** ⭐⭐⭐
Dada uma `List<Produto>` com um atributo `categoria`, use `Collectors.groupingBy(Produto::getCategoria)` para obter um `Map<String, List<Produto>>` agrupado, e imprima cada grupo.

**24. `groupingBy` com condição booleana** ⭐⭐⭐
Recrie o exemplo da teoria: agrupe uma lista de produtos em "caros" e "baratos" (`Map<Boolean, List<Produto>>`) usando `groupingBy(p -> p.getPreco() > 500)`.

**25. `Collectors.joining`** ⭐⭐
Dada uma `List<String>` de nomes, use `Collectors.joining(", ")` para gerar uma única String com todos os nomes separados por vírgula.

**26. Pipeline com várias etapas encadeadas** ⭐⭐⭐
Dada uma `List<String>` de nomes, use um único encadeamento de Stream para: filtrar nomes que começam com uma letra específica, converter para maiúsculo, ordenar alfabeticamente, e coletar num `List<String>`.

**27. Um Stream só pode ser consumido uma vez — comprove o erro** ⭐⭐
Crie um `Stream<String>` a partir de uma lista, chame uma operação terminal nele (`forEach`, por exemplo), e tente usar o **mesmo** Stream de novo numa segunda operação terminal (`count()`, por exemplo). Leia a `IllegalStateException`, e corrija criando um novo `.stream()` a partir da fonte original.

**28. Efeito colateral dentro de um Stream — o erro sutil** ⭐⭐⭐
Escreva um `forEach` que incrementa uma variável **externa** ao Stream (ex: um contador `int[] contador = {0};` — truque necessário porque lambdas não alteram variáveis locais comuns). Depois, reescreva o mesmo cálculo de forma "correta", sem efeito colateral, usando `count()` ou `reduce`. Explique num comentário por que a segunda versão é mais alinhada ao espírito da Stream API.

**29. `for` ainda é a escolha certa às vezes** ⭐⭐⭐
Pegue um problema com lógica de controle de fluxo complexa (por exemplo, o Exercício 39 da Parte 2 — números primos, com `break` condicional dentro de loop aninhado) e tente reescrevê-lo como Stream. Depois de tentar, escreva num comentário se a versão com Stream ficou mais clara ou mais confusa que o `for` original — e por quê.

**30. Carrinho de compras com Streams (revisitando a Parte 4)** ⭐⭐⭐⭐
Reescreva o exercício do "carrinho de compras" da Parte 4 (calcular total, filtrar por categoria, etc.) inteiramente usando Streams em vez de loops manuais, e compare a legibilidade das duas versões lado a lado.

**31. Convertendo entidade em DTO** ⭐⭐⭐⭐
Crie uma classe `Produto` (entidade, com vários campos) e uma classe `ProdutoResumoDTO` (só nome e preço). Use `stream().map().collect()` para converter uma `List<Produto>` inteira em `List<ProdutoResumoDTO>`.
> 💡 *Dica:* esse é, de longe, o uso mais comum de Streams em código Spring real — você vai escrever variações disso o tempo inteiro.

---

## 3. `Optional`

**32. Criando um `Optional`** ⭐
Crie um `Optional.of("Java")`, um `Optional.empty()`, e um `Optional.ofNullable(valor)` onde `valor` é uma variável que pode ser `null`.

**33. `isPresent()` / `ifPresent()`** ⭐
Para um `Optional` com valor e outro vazio, use `isPresent()` para checar antes de imprimir, e depois reescreva usando a forma mais idiomática `ifPresent(...)`.

**34. `orElse` vs. `orElseGet`** ⭐⭐
Crie um método `calcularPadraoCaro()` que imprime uma mensagem (simulando um cálculo custoso) e devolve um valor padrão. Use-o dentro de `orElse(calcularPadraoCaro())` e dentro de `orElseGet(() -> calcularPadraoCaro())`, num `Optional` que **já tem valor**. Repare qual das duas chama o método mesmo sem precisar, e qual não chama.

**35. `orElseThrow` com exceção customizada** ⭐⭐
Use `orElseThrow(() -> new NoSuchElementException("não encontrado"))` num `Optional.empty()`, e capture a exceção lançada.

**36. `.get()` sem checar — recriando o problema que `Optional` deveria evitar** ⭐⭐
Chame `.get()` diretamente num `Optional.empty()`, sem nenhuma checagem antes. Leia a exceção (`NoSuchElementException`) e reescreva o mesmo código de forma seguraq usando `orElseThrow` ou `orElse`.

**37. `map` e `filter` em `Optional`** ⭐⭐⭐
Dado um `Optional<String>` com um nome, use `.map(String::toUpperCase)` para transformá-lo, e `.filter(s -> s.length() > 10)` para descartar valores que não atendem a uma condição — sem nunca usar `.get()` explicitamente.

**38. `ifPresentOrElse`** ⭐⭐
Use `ifPresentOrElse(...)` (Java 9+) para imprimir uma mensagem diferente conforme um `Optional` tenha ou não valor, num único bloco de código (sem `if/else` tradicional).

**39. Buscando com `Optional` via Stream** ⭐⭐⭐
Escreva um método que recebe `List<Produto>` e um nome, e devolve `Optional<Produto>` usando `stream().filter().findFirst()`. Escreva um segundo método que usa `orElseThrow` para converter a ausência em uma exceção customizada.

**40. Por que `Optional` não deveria ser atributo de classe** ⭐⭐⭐
Reescreva de propósito uma classe `Pessoa` com um atributo `private Optional<String> apelido;`. Depois, pesquise (ou raciocine a partir da teoria) pelo menos dois problemas práticos dessa abordagem, e reescreva a classe da forma recomendada (`String apelido`, que pode ser `null`, com um método `Optional<String> getApelido()` que só envolve o valor **na saída**).

**41. `UsuarioRepository` + `UsuarioService` com `Optional` de ponta a ponta** ⭐⭐⭐⭐
Implemente uma interface `UsuarioRepository` (padrão da Parte 3B/4) cujo `buscarPorId` devolve `Optional<Usuario>`, implementada por cima de uma `List<Usuario>` usando `stream().filter().findFirst()`. Escreva um `UsuarioService` que usa `orElseThrow` para lançar `UsuarioNaoEncontradoException` quando não encontrar.
> 💡 *Dica:* esse exercício amarra praticamente tudo que você viu nas Partes 3, 4 e 5 num só lugar — é o mais próximo de um serviço Spring real que você já construiu nesta série. Se conseguir fazer este sem consultar nada, você está pronto pra Parte 6.

---

## Fechando

Lambda, Streams e `Optional` fecham o "estilo moderno" de escrever Java. Antes de seguir, um teste rápido: dado um problema qualquer envolvendo uma coleção, você já consegue decidir, quase de cabeça, se um `for` tradicional ou um pipeline de Stream é a escolha mais legível? Siga para `06-exercicios-infraestrutura-e-ferramentas.md`.
