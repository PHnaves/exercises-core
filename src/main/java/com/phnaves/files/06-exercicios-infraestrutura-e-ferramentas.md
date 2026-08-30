# Exercícios — Parte 6: Pacotes, Imutabilidade, Memória, Concorrência, I/O, Maven, Annotations e Reflection

> 🧭 Acompanha o arquivo `06-infraestrutura-e-ferramentas.md`. Você pediu para não incluir exercícios de testes unitários (JUnit) porque vai praticar isso escrevendo os próprios testes na mão — então esta seção **não tem um bloco dedicado a JUnit**, propositalmente. Todos os outros temas do arquivo teórico (pacotes, imutabilidade, memória, concorrência, I/O, Maven, annotations, reflection) estão cobertos normalmente.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Pacotes e organização de projeto

**1. Organizando por responsabilidade** ⭐
Pegue duas classes já prontas de exercícios anteriores (ex: `Usuario` e `UsuarioService`) e organize-as em pacotes (`model`, `service`), com as declarações corretas de `package` e `import`.

**2. Estrutura completa de um mini-projeto** ⭐⭐
Planeje (em texto, não precisa criar tudo) a estrutura de pacotes de um sistema pequeno de "biblioteca" (livros, empréstimos, usuários), seguindo o padrão `controller`/`service`/`repository`/`model`/`dto`/`exception` da teoria. Não é preciso implementar todas as classes — o objetivo é praticar a organização.

**3. `import` de classes do mesmo pacote vs. de pacotes diferentes** ⭐⭐
Crie duas classes no mesmo pacote e confirme que uma enxerga a outra **sem** `import`. Depois mova uma delas para outro pacote e adicione o `import` necessário para a primeira voltar a enxergá-la.

---

## 2. Imutabilidade

**4. Sua primeira classe imutável** ⭐⭐
Recrie a classe `Ponto` da teoria (`final class`, campos `final`, sem setters, com um método `mover(...)` que devolve um objeto **novo**). Confirme que o objeto original nunca muda, mesmo depois de chamar `mover(...)` várias vezes.

**5. A armadilha: campo `final` guardando uma lista mutável** ⭐⭐⭐
Recrie a classe `Pedido` "com vazamento" da teoria (guarda a referência da `List` recebida diretamente, e devolve essa mesma referência no getter). Comprove, alterando a lista original de fora, que o "imutável" `Pedido` também muda por dentro.

**6. Corrigindo com cópias defensivas** ⭐⭐⭐
Corrija a classe do exercício anterior fazendo cópia defensiva no construtor (`new ArrayList<>(itens)`) e devolvendo uma cópia imutável no getter (`List.copyOf(itens)`). Repita o teste do exercício 5 e confirme que agora o `Pedido` realmente não é afetado.

**7. Imutabilidade parcial — decida o que trava** ⭐⭐⭐
Modele uma classe `Pessoa` onde `nome` e `cpf` são realmente imutáveis (sem setter), mas `email` e `telefone` podem ser atualizados (com setter). Justifique, em um comentário, por que faz sentido essa distinção nesse caso.

**8. `record` como atalho (Java 16+)** ⭐⭐
Reescreva a classe `Ponto` do exercício 4 como um `record Ponto(int x, int y)`. Compare a quantidade de código necessária, e confirme que `equals()`, `hashCode()` e `toString()` já vêm prontos, testando os três.

**9. DTO imutável com `record`** ⭐⭐⭐
Crie um `record ProdutoDTO(String nome, double preco)` e use-o no lugar de uma classe DTO tradicional (com getters manuais) num método que converte uma lista de `Produto` (entidade) em `List<ProdutoDTO>` — pode reaproveitar o Exercício 31 da Parte 5B.

---

## 3. Memória e Garbage Collector

**10. Objeto elegível para coleta** ⭐⭐
Crie um objeto, guarde numa variável, depois atribua `null` a essa variável. Explique, num comentário, em que momento esse objeto se torna elegível para o Garbage Collector (sem se preocupar em "forçar" a coleta — isso não é controlável diretamente).

**11. Recriando o `CacheRuim`** ⭐⭐⭐
Recrie a classe `CacheRuim` da teoria (uma lista `static` que só cresce, nunca remove nada). Explique, em um comentário, por que essa lista nunca é coletada pelo GC enquanto a aplicação estiver rodando, mesmo que nenhum outro código do programa "use" mais os itens antigos.

**12. Corrigindo o `CacheRuim` com limite de tamanho** ⭐⭐⭐
Reescreva a classe do exercício anterior para que ela tenha um tamanho máximo — ao atingir o limite, o item mais antigo é removido antes de adicionar um novo (dica: pesquise `LinkedHashMap` com `removeEldestEntry`, ou implemente manualmente com uma `Queue` auxiliar).

**13. `StackOverflowError` revisitado** ⭐⭐
Sem olhar o Exercício 6 da Parte 1, escreva de novo um método com recursão infinita, rode, e leia a stack trace — quantos frames aproximadamente aparecem antes do erro? Isso te dá uma noção prática do tamanho da Stack.

---

## 4. Concorrência e Threads — introdução

**14. Sua primeira `Thread`** ⭐⭐
Crie e inicie uma `Thread` com uma lambda que imprime uma mensagem, usando `.start()`. Compare com o que aconteceria se você chamasse `.run()` diretamente em vez de `.start()` (teste os dois e compare a saída/comportamento).

**15. Várias threads "ao mesmo tempo"** ⭐⭐⭐
Crie 3 `Thread`s diferentes, cada uma imprimindo uma mensagem distinta em loop algumas vezes, e inicie as 3 quase simultaneamente. Rode o programa mais de uma vez e observe se a ordem das mensagens impressas muda entre as execuções — o que isso te diz sobre concorrência?

**16. Provocando uma race condition** ⭐⭐⭐⭐
Crie uma classe com um atributo `int contador = 0` e um método (não sincronizado) que faz `contador++`. Crie várias threads que chamam esse método um número grande de vezes cada (ex: 10.000 vezes, 10 threads), aguarde todas terminarem, e imprima o valor final de `contador`. Ele bate com o valor esperado (soma de todas as chamadas)? Repita algumas vezes — o resultado é sempre igual?

**17. Corrigindo com `synchronized`** ⭐⭐⭐
Corrija o método do exercício anterior marcando-o como `synchronized`, repita o experimento, e confirme que agora o valor final sempre bate com o esperado.

---

## 5. I/O e arquivos

**18. Escrevendo e lendo um arquivo texto** ⭐⭐
Use `Files.writeString(...)` para salvar uma frase num arquivo, depois `Files.readString(...)` para ler de volta e imprimir.

**19. Verificando existência antes de ler** ⭐⭐
Use `Files.exists(...)` para checar se um arquivo existe antes de tentar lê-lo, evitando um erro caso ele ainda não tenha sido criado.

**20. Log de eventos simples em arquivo** ⭐⭐⭐
Simule um "log" de eventos: cada vez que uma ação acontece no seu programa (ex: um pedido é criado), adicione uma linha nova a um arquivo texto (dica: pesquise as opções de `Files.writeString` para **anexar** em vez de sobrescrever). No final, leia o arquivo inteiro e imprima o histórico.

**21. `try-with-resources` na prática** ⭐⭐⭐
Escreva um trecho de código lendo um arquivo com `InputStream`, usando `try (InputStream in = ...)`. Provoque um erro de propósito no meio da leitura (ex: um arquivo que não existe) e confirme, através de um comentário ou de um `System.out` dentro de um `finally` manual comparativo, que o recurso é fechado automaticamente mesmo quando a exceção acontece.

---

## 6. Maven

**22. Lendo um `pom.xml`** ⭐⭐
Pegue o exemplo de `pom.xml` da teoria e explique, linha por linha (em comentários XML ou num texto separado), o que cada campo (`groupId`, `artifactId`, `version`, `dependencies`, `scope`) representa.

**23. Escrevendo um `pom.xml` do zero** ⭐⭐⭐
Escreva um `pom.xml` hipotético para um projeto seu, com `groupId`/`artifactId`/`version` à sua escolha, e **2 dependências** (podem ser fictícias ou reais, como `junit-jupiter`), cada uma com o `scope` apropriado.

**24. As 4 fases, em ordem** ⭐⭐
Sem rodar nada (a menos que você já tenha Maven instalado e queira testar de verdade), escreva a ordem das 4 fases (`compile`, `test`, `package`, `install`) e explique, para cada uma, o que ela faz **a mais** em relação à fase anterior.

**25. Migrando um projeto anterior para Maven** ⭐⭐⭐⭐
Se você tiver Maven instalado, pegue um dos projetos que já escreveu em exercícios anteriores (ex: o "carrinho de compras" ou o "sistema de estoque") e estruture-o como um projeto Maven de verdade, com `pom.xml` e a estrutura de pastas `src/main/java`/`src/test/java`.

---

## 7. Annotations

**26. Reconhecendo annotations que você já usa** ⭐
Liste, a partir de exercícios anteriores desta coleção, pelo menos 3 lugares onde você já usou `@Override` sem parar para pensar nisso como "uma annotation". O que o compilador verifica quando encontra esse `@Override`?

**27. `@Deprecated` na prática** ⭐⭐
Marque um método seu como `@Deprecated`, chame-o de outro lugar do código, e observe o aviso de compilação gerado pela IDE ou pelo `javac`.

---

## 8. Reflection — introdução

**28. Inspecionando uma classe** ⭐⭐⭐
Escreva um pequeno programa que usa `Produto.class.getDeclaredFields()` e `Produto.class.getDeclaredMethods()` para imprimir o nome de todos os campos e métodos declarados de uma classe sua, sem instanciar nada.

**29. `inspecionar(Object)` genérico** ⭐⭐⭐⭐
Recrie o método `inspecionar(Object objeto)` da teoria: recebendo qualquer objeto, use `getClass()`, `getDeclaredFields()`, `setAccessible(true)` e `field.get(objeto)` para imprimir o nome e o valor de todos os campos daquele objeto — mesmo os `private`. Teste com pelo menos 2 classes diferentes suas.
> 💡 *Dica:* é, em miniatura, o que bibliotecas como o Jackson fazem por dentro para transformar objetos em JSON.

---

## Fechando

Você agora reconhece as peças de "infraestrutura" que cercam qualquer projeto Java profissional. Lembre-se: pratique escrever seus próprios testes JUnit para os métodos que já implementou ao longo de toda esta coleção — é uma ótima forma de revisar tudo de uma vez, com a vantagem extra de treinar testes num código que você já entende de cor. Siga para `07-exercicios-solid-boas-praticas.md`, o último arquivo antes do Spring Boot.
