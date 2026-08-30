# Exercícios — Parte 5A: Object, equals/hashCode, Comparable/Comparator e Datas Modernas

> 🧭 Acompanha o arquivo `05a-object-equals-hashcode-comparable-comparator-datas.md`. Esta seção inclui um complemento sobre `TemporalAdjusters` que **não está no material teórico original** — incluí porque é uma classe real e útil do `java.time`, e vale fechar essa lacuna agora, com calma, antes do Spring.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. A classe `Object` e `toString()`

**1. `toString()` padrão vs. sobrescrito** ⭐
Crie uma classe `Livro` (título, autor) **sem** sobrescrever `toString()`. Instancie e imprima — observe a saída pouco útil (`Livro@1b6d3586`). Depois sobrescreva `toString()` e imprima de novo.

**2. `toString()` em uma classe com vários atributos** ⭐
Crie uma classe `Pedido` com pelo menos 4 atributos, e sobrescreva `toString()` de forma que a saída seja legível e útil para debug (ex: `Pedido{numero=123, status=PAGO, total=99.9}`).

**3. `toString()` chamando `toString()` de outro objeto** ⭐⭐
Crie uma classe `Pessoa` (com `toString()` sobrescrito) e uma classe `Pedido` que **tem uma** `Pessoa` como atributo (cliente). No `toString()` de `Pedido`, inclua os dados do cliente — repare que isso automaticamente aciona o `toString()` de `Pessoa` quando você concatena o objeto numa String.

**4. Por que isso importa em produção** ⭐⭐
Escreva um cenário simulado: um método que "loga" um erro imprimindo um objeto (`System.out.println("Erro ao processar: " + pedido)`). Compare a utilidade dessa mensagem com e sem um `toString()` sobrescrito em `Pedido`.

---

## 2. `equals()` e `hashCode()`

**5. O comportamento padrão (por referência)** ⭐
Crie uma classe `Produto` (sem sobrescrever nada) com um atributo `nome`. Crie dois objetos com o **mesmo** nome, e compare com `.equals()`. O resultado é `true` ou `false`? Por quê?

**6. Duplicata "escondida" num `HashSet`** ⭐⭐
Usando a mesma classe `Produto` sem `equals`/`hashCode` sobrescritos, adicione os dois objetos "logicamente iguais" do exercício anterior a um `HashSet<Produto>`. Imprima o `size()` — o resultado te surpreende?

**7. Sobrescrevendo corretamente, com `Objects.equals`/`Objects.hash`** ⭐⭐
Sobrescreva `equals()` e `hashCode()` de `Produto`, baseando os dois no atributo `nome`, usando `java.util.Objects`. Repita o Exercício 6 — o `size()` do `HashSet` agora deveria ser `1`.

**8. Igualdade baseada em mais de um campo** ⭐⭐
Crie uma classe `Coordenada` (`x`, `y`) e sobrescreva `equals()`/`hashCode()` considerando os **dois** campos — duas coordenadas só são iguais se `x` e `y` baterem simultaneamente.

**9. Quebrando o contrato de propósito** ⭐⭐⭐
Sobrescreva **apenas** `equals()` de uma classe (sem sobrescrever `hashCode()`). Crie dois objetos "logicamente iguais" segundo esse `equals()`, adicione os dois a um `HashSet`, e observe que o `size()` continua `2` — mesmo o `equals()` dizendo que são iguais. Explique, num comentário, por que isso acontece (releia o mecanismo de bucket/hashCode da teoria).

**10. `getClass()` vs. `instanceof` no `equals`** ⭐⭐⭐
Pesquise a diferença entre checar `if (getClass() != o.getClass())` e `if (!(o instanceof Produto))` dentro de um `equals()`. Qual delas se comporta de forma diferente quando existe uma **subclasse** envolvida? Escreva um pequeno teste que demonstra a diferença.

**11. Identidade de negócio ≠ todos os campos** ⭐⭐⭐⭐
Modele uma classe `Pedido` com `numeroPedido` (identidade de negócio) e `status` (mutável, muda ao longo do tempo). Sobrescreva `equals()`/`hashCode()` baseados **só** em `numeroPedido` — não no `status`. Crie dois objetos `Pedido` com o mesmo número, mas status diferentes, adicione os dois a um `Set`, e confirme que só um sobrevive.
> 💡 *Dica:* isso é um padrão real — a "identidade" de uma entidade geralmente não é todos os campos, é a chave que a identifica de forma única. Guarde esse exercício: ele volta a fazer sentido quando você chegar em entidades JPA.

**12. Gerando `equals`/`hashCode` pela IDE** ⭐⭐
Se sua IDE tiver essa opção (IntelliJ, Eclipse e VS Code com extensão Java têm), gere `equals()`/`hashCode()` automaticamente para uma classe sua com 3+ atributos, e compare o código gerado com o que você escreveria manualmente usando `Objects.equals`/`Objects.hash`.

**13. `equals` simétrico com tipos diferentes** ⭐⭐⭐
Escreva um `equals()` correto e teste explicitamente `produto.equals("uma string qualquer")` e `produto.equals(null)` — os dois devem devolver `false` sem lançar nenhuma exceção.

---

## 3. `Comparable` e `Comparator`

**14. `Comparable` — ordenação natural** ⭐⭐
Faça uma classe `Produto` (nome, preço) implementar `Comparable<Produto>`, ordenando por preço crescente. Crie uma lista fora de ordem e chame `Collections.sort(produtos)`.

**15. `Comparator` — uma segunda ordenação, sem alterar a classe** ⭐⭐
Sem mexer na classe `Produto` do exercício anterior, escreva um `Comparator<Produto>` externo que ordena por nome (alfabético), e use-o com `produtos.sort(...)`.

**16. `Comparator.comparing` + `reversed()`** ⭐⭐
Ordene a mesma lista de produtos por preço **decrescente**, usando `Comparator.comparing(Produto::getPreco).reversed()`.

**17. Empate: `thenComparing`** ⭐⭐⭐
Crie uma lista de produtos onde pelo menos dois tenham o mesmo preço. Ordene por preço e, em caso de empate, por nome, usando `thenComparing`.

**18. `compareTo` inconsistente com `equals` — identifique o risco** ⭐⭐⭐
Escreva um `compareTo()` que considera dois objetos "iguais" (retorna `0`) mesmo quando o `equals()` da mesma classe diz que são diferentes (ex: `compareTo` só olha o preço, `equals` olha nome e preço). Adicione dois desses objetos com preços iguais mas nomes diferentes a um `TreeSet`, e observe quantos sobrevivem — o resultado é o esperado?

**19. Ordenando por múltiplos critérios em cenário realista** ⭐⭐⭐⭐
Crie uma classe `Funcionario` (nome, cargo, salário). Ordene uma lista por cargo (alfabético) e, dentro do mesmo cargo, por salário decrescente, usando um único `Comparator` encadeado.

**20. `Comparable` vs. `Comparator`: você decide** ⭐⭐⭐
Para uma classe `Aluno` (nome, matrícula, média), decida: a ordenação "natural" (por matrícula, digamos) deveria ser `Comparable`? E uma eventual ordenação por média, usada só em uma tela específica do sistema, deveria ser `Comparator`? Implemente as duas e justifique a escolha de cada uma em um comentário.

---

## 4. Datas modernas (`java.time`)

**21. `LocalDate.now()` e `LocalDate.of(...)`** ⭐
Imprima a data de hoje com `LocalDate.now()`, e crie uma data específica (seu aniversário, por exemplo) com `LocalDate.of(ano, mes, dia)`.

**22. `LocalDateTime` combinando data e hora** ⭐
Crie um `LocalDateTime` específico (data e hora de um evento) usando `LocalDateTime.of(...)`, e imprima.

**23. Imutabilidade em `java.time` — a mesma armadilha de `String`** ⭐⭐
Chame `data.plusDays(5);` **sem** capturar o retorno, e imprima `data` na sequência (não deve ter mudado). Depois capture o retorno numa nova variável.

**24. Calculando idade com `Period`** ⭐⭐
Dada uma data de nascimento (`LocalDate`), calcule a idade em anos completos usando `Period.between(nascimento, LocalDate.now()).getYears()`.

**25. `Duration` entre dois horários** ⭐⭐
Dados dois `LocalTime` (início e fim de um expediente), calcule a duração entre eles com `Duration.between(...)`, e imprima em horas e minutos (`toHours()`, `toMinutesPart()`).

**26. Idade completa em anos, meses e dias** ⭐⭐⭐
Repita o Exercício 24, mas agora imprima a idade completa no formato `"X anos, Y meses e Z dias"`, usando `getYears()`, `getMonths()` e `getDays()` do mesmo `Period`.

**27. Ordenando pessoas por idade com `java.time`** ⭐⭐⭐
Dada uma lista de datas de nascimento (`LocalDate`), calcule a idade de cada pessoa e ordene do mais velho para o mais novo, usando `Comparator` (Seção 3 acima).

**28. `DateTimeFormatter` para formato brasileiro** ⭐⭐
Pesquise e use um `DateTimeFormatter` para imprimir uma `LocalDate` no formato `dd/MM/yyyy` em vez do formato ISO padrão (`yyyy-MM-dd`).

**29. Janela de cancelamento com `Duration`** ⭐⭐⭐
Escreva um método que recebe um `LocalDateTime` (momento em que um pedido foi feito) e devolve se ele ainda está dentro de uma janela de cancelamento de 30 minutos a partir de agora, usando `Duration.between(...)`.

---

### 💡 Complemento: `TemporalAdjusters` (não estava no material original)

`TemporalAdjusters` é uma classe utilitária de `java.time.temporal` com "ajustes" prontos para datas — em vez de calcular manualmente quantos dias faltam até o próximo domingo ou qual é o último dia do mês, você usa um ajuste já pronto:

```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

LocalDate hoje = LocalDate.now();

LocalDate primeiroDoMes      = hoje.with(TemporalAdjusters.firstDayOfMonth());
LocalDate ultimoDoMes        = hoje.with(TemporalAdjusters.lastDayOfMonth());
LocalDate proximaSegunda     = hoje.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
LocalDate segundaAnteriorOuHoje = hoje.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
LocalDate primeiroDoProxMes  = hoje.with(TemporalAdjusters.firstDayOfNextMonth());
```

O método `.with(...)`, presente em `LocalDate`/`LocalDateTime`, aceita qualquer `TemporalAdjuster` — que é, por baixo dos panos, apenas uma **interface funcional** (o mesmo conceito da Parte 5B) com um único método que recebe uma data e devolve outra. Os ajustes prontos (`firstDayOfMonth`, `lastDayOfMonth`, `next`, `previous`, `firstDayOfNextMonth`, `lastDayOfYear`, entre outros) cobrem a esmagadora maioria dos casos do dia a dia — e você também pode escrever o seu próprio, como uma lambda.

**30. Primeiro e último dia do mês** ⭐⭐
Dada uma `LocalDate` qualquer, use `TemporalAdjusters.firstDayOfMonth()` e `TemporalAdjusters.lastDayOfMonth()` para descobrir o primeiro e o último dia daquele mês.

**31. Próxima ocorrência de um dia da semana** ⭐⭐
Dada a data de hoje, descubra qual será a próxima sexta-feira usando `TemporalAdjusters.next(DayOfWeek.FRIDAY)`. Depois, compare com `TemporalAdjusters.nextOrSame(...)` — qual a diferença de comportamento se hoje **já for** sexta-feira?

**32. Último dia útil do mês** ⭐⭐⭐
Escreva um método que devolve o último dia **útil** (segunda a sexta) de um mês: comece com `TemporalAdjusters.lastDayOfMonth()` e, se o resultado cair em sábado ou domingo, volte manualmente para a sexta-feira anterior (`minusDays`, verificando o `getDayOfWeek()`).
> 💡 *Dica:* se quiser ir além, pesquise como escrever seu **próprio** `TemporalAdjuster` como uma lambda — esse exercício também pode ser resolvido assim.

**33. Data de vencimento da próxima assinatura** ⭐⭐⭐⭐
Escreva um método `calcularProximaCobranca(LocalDate dataAssinatura)` que devolve o mesmo dia no mês seguinte (`plusMonths(1)`), mas trata o caso em que esse dia não existe no mês seguinte — por exemplo, uma assinatura feita em 31 de janeiro não tem "31 de fevereiro". Nesse caso, o método deve devolver o **último dia** do mês seguinte, usando `TemporalAdjusters.lastDayOfMonth()`.

---

## Desafio integrador da Parte 5A

**34. Catálogo de produtos "completo"** ⭐⭐⭐⭐
Modele uma classe `Produto` (nome, preço, dataCadastro) com `equals`/`hashCode` corretos (baseados num identificador único), `Comparable` para ordenação natural por nome, e um `Comparator` separado para ordenar por data de cadastro (mais recente primeiro). Monte uma lista com produtos duplicados (mesmo identificador, dados diferentes) e confirme que um `Set` reconhece a duplicata corretamente.

---

## Fechando

Você agora sabe por que `equals()`/`hashCode()` têm que andar juntos, como ordenar objetos de mais de uma forma, e como trabalhar com datas — incluindo o complemento de `TemporalAdjusters`, que fecha exatamente a lacuna que você mencionou. Siga para `05b-exercicios-lambda-streams-optional.md`, que fecha o "estilo moderno" de Java.
