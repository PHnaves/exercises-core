# Exercícios — Parte 4: Enums, Exceptions, Collections, Generics e Autoboxing

> 🧭 Acompanha o arquivo `04-enums-exceptions-collections-generics-autoboxing.md`. São as ferramentas que você vai usar em praticamente toda classe de negócio daqui em diante — vale investir tempo extra aqui, principalmente em Collections.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Enums

**1. Seu primeiro enum** ⭐
Crie um `enum Cor` com `VERMELHO`, `VERDE`, `AZUL`. Atribua um valor a uma variável e compare com `==` contra cada constante.

**2. `switch` com enum** ⭐
Usando o `enum Cor`, escreva um `switch` (tradicional ou moderno) que imprime um nome de cor em português para cada constante.

**3. `values()`, `name()` e `ordinal()`** ⭐⭐
Percorra `Cor.values()` com um `for-each`, imprimindo, para cada constante, o `name()` e o `ordinal()`.

**4. `valueOf` e o risco de erro em tempo de execução** ⭐⭐
Use `Cor.valueOf("VERMELHO")` para converter uma String em enum. Depois, tente `Cor.valueOf("ROXO")` (uma constante que não existe) e observe a exceção lançada.

**5. Enum com atributos e construtor** ⭐⭐⭐
Recrie o `enum StatusPedido` da teoria (com `descricao` e `statusFinal`). Escreva um método que recebe um `StatusPedido` e imprime sua descrição, além de dizer se é um status final ou não.

**6. Por que não usar `ordinal()` como ID** ⭐⭐⭐
No `enum StatusPedido`, imprima o `ordinal()` de cada constante. Depois, **reordene** as constantes no código-fonte (troque a ordem de duas delas) e rode de novo. O que aconteceu com os valores de `ordinal()`? Por que isso seria perigoso se você tivesse salvo esses números num banco de dados?

**7. Enum com método de comportamento próprio** ⭐⭐⭐⭐
Crie um `enum FormaPagamento` (`CARTAO`, `PIX`, `BOLETO`) com um método `calcularTaxa(double valor)` que devolve uma taxa diferente para cada constante (pode usar um `switch` dentro do método, ou um atributo de taxa por constante — tente as duas formas e compare qual fica mais legível).

---

## 2. Exceptions

**8. Provocando e capturando** ⭐
Provoque uma `ArithmeticException` (divisão por zero) de propósito, capture com `try/catch`, e imprima uma mensagem amigável usando `e.getMessage()`.

**9. `finally` sempre roda** ⭐
Escreva um `try/catch/finally` onde o `finally` imprime uma mensagem. Rode uma vez provocando exceção e outra vez sem provocar — confirme que o `finally` roda nas duas situações.

**10. Vários `catch`, do mais específico ao mais genérico** ⭐⭐
Escreva um método que pode lançar `IllegalArgumentException` **ou** `NullPointerException` dependendo do parâmetro recebido, com dois `catch` específicos e um terceiro `catch (Exception e)` genérico por último. Teste passando valores que disparem cada um dos 3 caminhos.

**11. `throw` vs. `throws`, lado a lado** ⭐⭐
Escreva um método `validarIdade(int idade)` que usa `throw` para lançar uma exceção *unchecked*. Escreva outro método `lerConfiguracao(String caminho) throws IOException` que apenas **declara** uma exceção checked, sem necessariamente lançá-la nesse trecho. Explique, num comentário, a diferença de papel entre as duas palavras-chave.

**12. Sua primeira exceção customizada** ⭐⭐
Crie `SaldoInsuficienteException extends RuntimeException`. Escreva um método `sacar(double valor, double saldo)` que a lança quando `valor > saldo`, com uma mensagem informando os dois valores envolvidos.

**13. Checked de verdade, com `throws` obrigatório** ⭐⭐⭐
Crie uma exceção customizada `ArquivoInvalidoException extends Exception` (não `RuntimeException` — repare que isso a torna *checked*). Escreva um método que a lança, e confirme que, ao chamá-lo, o compilador **exige** um `try/catch` ou um `throws` na assinatura de quem chama.

**14. Catch vazio — veja o problema na prática** ⭐⭐⭐
Escreva um `catch` vazio (sem nenhum código dentro) para uma exceção provocada de propósito. Rode e observe como o programa "engole" o erro silenciosamente. Corrija adicionando, no mínimo, um `System.out.println` ou log da exceção.

**15. Múltiplos tipos num único `catch`** ⭐⭐⭐
Pesquise a sintaxe `catch (IllegalArgumentException | NullPointerException e)` (multi-catch) e reescreva o Exercício 10 usando essa forma para os dois primeiros tipos, mantendo o terceiro `catch` genérico separado.

**16. Exceção com causa encadeada** ⭐⭐⭐
Escreva um método que captura uma exceção "de baixo nível" (ex: `ArithmeticException`) e a relança como uma exceção customizada sua, passando a exceção original como **causa** (`new MinhaExcecao("mensagem", causaOriginal)`). Imprima o `getCause()` da exceção capturada no nível de fora.

**17. `UsuarioNaoEncontradoException` em um cenário completo** ⭐⭐⭐⭐
Crie `UsuarioNaoEncontradoException extends RuntimeException`. Simule um "repositório" (pode ser um array ou `HashMap`, veja a Seção 3 abaixo) e um método `buscarUsuario(id)` que lança essa exceção quando o `id` não é encontrado. No `main`, capture a exceção e imprima uma mensagem amigável para o usuário final, sem expor detalhes técnicos internos.

**18. Não capture genérico demais — refatore** ⭐⭐⭐⭐
Pegue um método que faz várias coisas diferentes (ex: validar um CPF, converter uma String para número, e acessar uma posição de array) e que está, hoje, com um único `catch (Exception e)` cobrindo tudo. Reescreva-o com `catch`s específicos para cada tipo de falha possível, e explique num comentário por que a versão genérica escondia informação importante sobre o que realmente deu errado.

---

## 3. Collections Framework

**19. `ArrayList` do zero** ⭐
Crie um `ArrayList<String>`, adicione 3 nomes, imprima a lista inteira, remova um pelo valor, e imprima de novo.

**20. `get`, `set` e `contains`** ⭐
Dado um `ArrayList<String>` já populado, use `get(i)` para pegar um elemento específico, `set(i, novoValor)` para substituí-lo, e `contains(valor)` para verificar se outro valor existe na lista.

**21. `HashMap` básico** ⭐⭐
Crie um `HashMap<String, Integer>` representando produto → quantidade em estoque. Adicione pelo menos 4 produtos, verifique se um produto existe com `containsKey`, pegue a quantidade de um deles, atualize essa quantidade, e percorra imprimindo todos com `entrySet()`.

**22. `HashSet` para garantir unicidade** ⭐⭐
Crie um `HashSet<String>` de e-mails, adicione alguns e-mails repetidos de propósito, e imprima o `size()` para confirmar que as duplicatas foram ignoradas.

**23. `List` → `Set` para remover duplicatas** ⭐⭐
Dada uma `List<String>` com nomes repetidos, converta para um `Set` (`new HashSet<>(suaLista)`), e imprima a diferença de tamanho entre os dois.

**24. `ConcurrentModificationException`, provocada de propósito** ⭐⭐⭐
Reproduza o erro clássico: percorra uma `List` com `for-each` e tente `remove()` um elemento de dentro do loop. Leia a exceção. Corrija de duas formas diferentes: usando `Iterator` explícito com `it.remove()`, e usando `removeIf(...)`.

**25. `ArrayList` vs. `LinkedList` — meça a diferença** ⭐⭐⭐
Crie uma `ArrayList` e uma `LinkedList`, ambas com uns 50.000 elementos. Meça (com `System.nanoTime()`) o tempo de inserir um elemento **no início** da lista em cada uma. Qual foi mais rápida? Isso bate com o que a teoria descreve sobre o funcionamento interno de cada uma?

**26. `TreeSet` para manter ordem automática** ⭐⭐
Adicione uma sequência de números **fora de ordem** a um `TreeSet<Integer>` e imprima o conjunto — confirme que ele já sai ordenado, sem você precisar chamar nenhum método de ordenação.

**27. `LinkedHashMap` preservando ordem de inserção** ⭐⭐
Adicione pares chave-valor em uma ordem específica a um `HashMap` comum e a um `LinkedHashMap`, e imprima os dois. Compare a ordem de iteração de cada um.

**28. Escolhendo a coleção certa** ⭐⭐⭐
Para cada cenário, diga qual coleção você usaria e por quê: (a) uma lista de produtos de um pedido, onde a ordem de adição importa e duplicatas são permitidas; (b) o conjunto de e-mails já cadastrados no sistema, onde duplicata nunca pode existir; (c) um "dicionário" de código de país → nome do país, para consulta rápida por código; (d) um ranking que precisa estar sempre ordenado por pontuação.

**29. `Queue` e `Deque` básicos** ⭐⭐
Usando `ArrayDeque`, simule uma fila de atendimento (FIFO): adicione 5 "clientes" (Strings) com `offer`/`add`, e atenda-os em ordem com `poll`, imprimindo cada atendimento.

**30. Mini carrinho de compras com `List`** ⭐⭐⭐
Monte um "carrinho de compras": uma classe `Produto` (nome, preço) e uma `List<Produto>` representando o carrinho. Escreva métodos para adicionar produtos, calcular o total (com um `for`, sem Streams ainda), e remover um produto pelo nome — usando o padrão seguro de remoção (sem cair no erro do Exercício 24).

**31. "Repositório" em memória com `HashMap`** ⭐⭐⭐⭐
Simule um repositório em memória com `HashMap<Long, Usuario>` (ID → Usuário), com métodos `salvar` e `buscarPorId` (devolvendo `null` se não achar). Crie uma classe de "serviço" que chama esse repositório e, se o resultado for `null`, lança a `UsuarioNaoEncontradoException` da Seção 2.
> 💡 *Dica:* isso combina Collections + Exceptions + o padrão interface/service da Parte 3B — é bem próximo do que uma camada de serviço real faz.

**32. Sistema de tags com `Map<String, Set<String>>`** ⭐⭐⭐⭐
Modele um sistema de "tags" para artigos: um `Map<String, Set<String>>` onde a chave é o nome de um artigo e o valor é o conjunto de tags associadas a ele (sem duplicatas). Escreva métodos para adicionar uma tag a um artigo (criando o `Set` se ainda não existir) e para listar todos os artigos que têm uma tag específica.

---

## 4. Generics

**33. Sua primeira classe genérica** ⭐⭐
Recrie a classe `Caixa<T>` da teoria, com `guardar(T item)` e `pegar()`. Instancie uma `Caixa<String>` e uma `Caixa<Integer>`, e use as duas.

**34. Por que generics existem — o erro que eles evitam** ⭐⭐
Crie uma `List` **sem** generics (raw type — `List lista = new ArrayList();`), adicione uma `String` e um `Integer` na mesma lista, e tente fazer cast de um elemento errado para `String`. Observe o `ClassCastException` em tempo de execução. Reescreva com `List<String>` e confirme que o mesmo erro agora é pego **em tempo de compilação**.

**35. Método genérico** ⭐⭐
Escreva um método genérico `<T> void imprimirTodos(List<T> lista)` que funciona para qualquer tipo de lista, e teste com uma `List<String>` e uma `List<Integer>`.

**36. Classe genérica com dois tipos: `Par<A, B>`** ⭐⭐⭐
Escreva uma classe genérica `Par<A, B>` que guarda dois valores de tipos possivelmente diferentes, com getters para cada um. Crie um `Par<String, Integer>` (ex: nome + idade) e um `Par<String, Double>` (ex: produto + preço).

**37. Método genérico com retorno** ⭐⭐⭐
Escreva um método genérico `<T> T primeiro(List<T> lista)` que devolve o primeiro elemento de qualquer lista, e outro `<T> T ultimo(List<T> lista)` para o último.

**38. Reconhecendo generics já prontos** ⭐⭐
Explique, em uma frase cada, o que os parâmetros de tipo significam nestas 3 declarações (sem precisar implementar nada): `Map<String, List<Integer>>`, `Optional<Usuario>`, `JpaRepository<Produto, Long>`.

**39. Uma "caixa" genérica com validação de tipo em tempo de execução** ⭐⭐⭐⭐
Estenda a classe `Caixa<T>` do Exercício 33 para uma versão que também guarda a `Class<T>` correspondente (recebida no construtor), e um método `boolean aceita(Object o)` que usa essa `Class<T>` para verificar, em tempo de execução, se um objeto qualquer é compatível com o tipo da caixa antes de tentar guardá-lo.

---

## 5. Autoboxing e Wrapper Classes

**40. Autoboxing e unboxing na prática** ⭐
Declare um `int`, atribua a uma variável `Integer` (autoboxing), depois atribua essa `Integer` de volta a uma variável `int` (unboxing). Imprima os dois.

**41. Por que `List<int>` não existe** ⭐
Crie uma `List<Integer>`, adicione alguns números literais `int` diretamente (`lista.add(5)`), e explique num comentário o que acontece "por baixo" nesse `add`.

**42. `NullPointerException` no unboxing** ⭐⭐
Declare `Integer valor = null;` e tente fazer `int x = valor;`. Leia a exceção. Explique por que isso é especialmente perigoso quando o valor vem de um banco de dados ou de uma API externa.

**43. O cache de `Integer` entre -128 e 127** ⭐⭐⭐
Compare com `==` dois `Integer` de valor `100` (declarados separadamente) e dois de valor `200`. Um dá `true` e o outro `false`? Explique o porquê usando o conceito de cache de objetos `Integer` da teoria.

**44. `.equals()` sempre correto para Wrapper Classes** ⭐⭐
Repita o exercício anterior, mas comparando com `.equals()` em vez de `==`, para os mesmos valores `100` e `200`. Confirme que agora os dois casos dão `true`.

**45. `Long` opcional que ainda não existe** ⭐⭐⭐
Crie uma classe `Produto` com um atributo `Long id` (não `long`). Escreva um construtor que **não** define o `id` (simulando um produto ainda não salvo em banco). Imprima o `id` desse produto (deve ser `null`) e explique, num comentário, por que `long id` não poderia representar essa mesma situação.

---

## Fechando

Você agora tem as ferramentas pra modelar dados com segurança (`enum`, Generics), tratar erros de forma profissional (Exceptions) e guardar/organizar grupos de objetos (Collections) — sem precisar mais de arrays crus pra tudo. Antes de seguir, um bom teste: você já erra menos ao escolher entre `ArrayList`/`HashMap`/`HashSet` de cabeça? Se sim, siga para `05a-exercicios-object-equals-hashcode-comparable-comparator-datas.md`.
