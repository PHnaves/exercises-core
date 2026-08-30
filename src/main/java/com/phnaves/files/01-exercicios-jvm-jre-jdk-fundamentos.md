# Exercícios — Parte 1: Java, JVM, JRE, JDK e Fundamentos de Sintaxe

> 🧭 Acompanha o arquivo `01-jvm-jre-jdk-e-fundamentos.md`. Leia (ou revise) a teoria antes de tentar os exercícios de cada seção — a ordem abaixo segue exatamente a ordem das seções do arquivo teórico.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End
> Detalhes completos de como usar este material estão no arquivo `00-indice-e-guia-de-uso.md`.

---

## Seção 1-3 — O que é Java, o pipeline de compilação, e JDK vs. JRE vs. JVM

**1. `java -version` vs. `javac -version`** ⭐
Abra o terminal e rode `java -version` e `javac -version`. Anote a saída dos dois. Se `javac` não existir na sua máquina, isso significa o quê sobre o que está instalado (JRE ou JDK)?

**2. Explique com suas palavras** ⭐
Sem colar de nenhum lugar, escreva 3 frases curtas explicando a diferença entre JDK, JRE e JVM para alguém que nunca programou.

**3. O pipeline completo** ⭐⭐
Escreva (em texto ou em um diagrama simples) o caminho completo de um arquivo `Main.java` até ele efetivamente rodar na sua tela, nomeando a ferramenta ou o componente responsável por cada etapa.

**4. `class` sem `main`** ⭐⭐
Crie um arquivo `.java` com uma classe pública, mas sem nenhum método `main`. Tente rodar com `java NomeDaClasse` e leia a mensagem de erro. O que ela te diz sobre como a JVM decide onde "começar"?

**5. `ClassNotFoundException` vs. `NoClassDefFoundError`** ⭐⭐⭐
Pesquise a diferença entre essas duas mensagens de erro e relacione cada uma com uma das três fases do Class Loader (loading, linking, initialization) explicadas na Seção 4.1 do arquivo teórico.

**6. Provocando um `StackOverflowError`** ⭐⭐⭐
Escreva um método que chama a si mesmo sem nenhuma condição de parada (recursão infinita) e rode. Leia a stack trace gerada — o que ela revela sobre como a Stack (Seção 4.2) funciona por dentro?

---

## Seção 5 — Estrutura básica de um programa Java

**7. Seu primeiro `Main.java`** ⭐
Crie um arquivo `Main.java` que imprime seu nome completo com `System.out.println`.

**8. Quebrando de propósito** ⭐
No programa do exercício anterior, remova o `;` do final da linha, rode, leia o erro, e corrija. Repita o mesmo processo removendo uma chave `}` e depois removendo `static` do `main`.

**9. Nome de classe ≠ nome de arquivo** ⭐
No mesmo `Main.java`, renomeie a classe pública para `Ola` (sem renomear o arquivo). Rode o compilador e leia a mensagem de erro exata.

**10. Três tipos de comentário** ⭐
Escreva um programa pequeno com um comentário de uma linha, um comentário de várias linhas, e um comentário Javadoc (`/** ... */`) logo acima do método `main`.

**11. Convenções de nomenclatura** ⭐⭐
Para cada nome a seguir, diga se ele segue a convenção correta em Java e, se não seguir, reescreva-o corretamente: `numero_de_tentativas` (variável), `pessoa` (classe), `maxUsuarios` (constante), `Calculadora` (classe), `CalcularTotal` (método).

---

## Seção 6 — Variáveis e tipos primitivos

**12. Os 8 tipos primitivos** ⭐
Declare uma variável de cada um dos 8 tipos primitivos com um valor plausível, e imprima todas numa única chamada de `System.out.println`, concatenando com `+`.

**13. Valores padrão de atributos** ⭐⭐
Crie uma classe `Exemplo` com um atributo de cada tipo primitivo, **sem inicializar nenhum**. No `main`, instancie e imprima todos os atributos, comprovando os valores padrão da tabela da Seção 6.

**14. Estourando o limite** ⭐⭐
Declare `byte`, `short`, `int` e `long` com os valores **máximos** de cada tipo (pesquise `Byte.MAX_VALUE`, `Short.MAX_VALUE` etc.) e some `1` a cada um. Imprima o resultado antes e depois — o que acontece?

**15. Sufixos obrigatórios** ⭐⭐
Escreva `long l = 6000000000;` sem o sufixo `L`, leia o erro, e corrija. Repita o experimento com `float f = 12.5;` sem o sufixo `f`.

**16. Dinheiro com `double` — o problema na prática** ⭐⭐⭐
Simule uma conta com saldo `double` começando em `0`. Faça 3 depósitos de `0.10` seguidos e imprima o saldo final sem arredondar nada. O resultado é exatamente `0.30`? Pesquise rapidamente o nome da classe recomendada para valores monetários em Java (não precisa usá-la ainda — só descobrir o nome e por que ela existe).

**17. Convertendo texto vindo "de fora"** ⭐⭐⭐
Simule receber 3 valores como `String`: `"25"`, `"1999.90"` e `"true"`. Converta cada um para o tipo primitivo correspondente usando `Integer.parseInt`, `Double.parseDouble` e `Boolean.parseBoolean`, e imprima os valores já convertidos.

**18. Tabela de limites** ⭐⭐⭐⭐
Usando `System.out.printf`, monte uma tabela impressa no console com 4 colunas (Tipo, Tamanho em bits, Mínimo, Máximo) para `byte`, `short`, `int` e `long`, usando as constantes prontas (`Byte.MIN_VALUE`, `Integer.MAX_VALUE` etc.) em vez de digitar os números manualmente.

---

## Seção 7 — Primitivo vs. referência (o assunto mais importante desta parte)

> 💡 Se você só puder praticar uma seção deste arquivo com calma, seja esta. É a base de tudo que vem na Parte 3 (POO) e na Parte 2 (pass-by-value).

**19. Duas variáveis, um objeto só** ⭐
Crie uma classe `Produto` com um atributo público `preco` (ainda sem encapsulamento — isso é assunto da Parte 3). Crie **uma** variável `p1`, e uma segunda variável `p2 = p1`. Altere `preco` através de `p2` e imprima o valor através de `p1`. O que você observa?

**20. Dois objetos de verdade** ⭐
Repita o exercício anterior, mas agora crie **dois** `new Produto()` diferentes com o mesmo preço inicial. Altere o preço de um deles e confirme, com `println`, que o outro não muda.

**21. Reatribuir não é o mesmo que mutar** ⭐⭐
Escreva um método `resetar(Produto p)` que tenta "zerar" o preço fazendo `p = new Produto(0)` dentro do método (reatribuindo o parâmetro). Chame esse método a partir do `main` passando um `Produto` já existente e comprove que o preço original **não muda**.

**22. Agora mutando de verdade** ⭐⭐
Escreva um segundo método `zerarPreco(Produto p)` que faz `p.preco = 0` (altera o atributo do objeto recebido). Compare o resultado com o exercício 21 — imprima o preço do objeto original antes e depois de cada uma das duas chamadas.

**23. `null` não apaga o objeto** ⭐⭐
Crie `p1`, depois `p2 = p1`. Em seguida, faça `p1 = null`. Imprima `p2.preco` (deve funcionar normalmente) e depois tente imprimir `p1.preco` (deve lançar `NullPointerException`). Explique em um comentário por que isso acontece.

**24. Por que `int x = null` não compila** ⭐⭐
Tente compilar `int x = null;`, leia a mensagem de erro exata, e explique em um comentário por que tipos primitivos não podem ser `null`.

**25. Cópia de valor vs. cópia de referência, lado a lado** ⭐⭐⭐
Num único programa: (a) crie `int a = 5; int b = a;`, altere `b`, e imprima `a`; (b) crie um objeto próprio seu, uma segunda variável apontando pra ele, altere um atributo através da segunda variável, e imprima através da primeira. Escreva, num comentário, uma frase comparando os dois resultados.

**26. Referências dentro de uma coleção** ⭐⭐⭐⭐
Crie uma classe `Carrinho` com uma `List<String>` de itens (pode usar `ArrayList` mesmo sem ter estudado a fundo ainda — Parte 4). Escreva um método `substituir(Carrinho c)` que tenta trocar o carrinho inteiro fazendo `c = new Carrinho()`, e outro `esvaziar(Carrinho c)` que faz `c.getItens().clear()`. Compare o efeito de cada um sobre o carrinho original criado no `main`.
> 💡 *Dica:* isso antecipa exatamente o comportamento que você vai reconhecer, mais adiante, entre Controller → Service → Repository no Spring.

---

## Seção 8 — Conversão de tipos (Casting)

**27. Widening automático** ⭐
Converta um `int` para `double` sem nenhum cast explícito, e imprima. Confirme no comentário por que isso compila sem cast.

**28. Truncar não é arredondar** ⭐
Antes de rodar, escreva num comentário sua previsão do resultado de `(int) 9.99`. Depois rode e confira. Repita com `(int) -9.99`.

**29. Overflow silencioso** ⭐⭐
Calcule `(byte) 200` e `(byte) 130`. Tente prever o resultado (pesquise como o "wrap around" funciona) antes de rodar, depois confira executando.

**30. `Math.round` vs. cast simples** ⭐⭐
Escreva um método `arredondar(double valor)` que devolve um `int` corretamente arredondado usando `Math.round`. Compare o resultado dele com um cast `(int)` simples para os valores `4.4`, `4.5` e `4.6`, imprimindo os dois resultados lado a lado.

**31. Validar antes de converter** ⭐⭐⭐
Simule receber uma "idade" como `int` (por exemplo, `300`, um valor claramente inválido para caber num `byte`). Antes de fazer `(byte) idade`, escreva um `if` que verifica se o valor está dentro do intervalo de `byte` (`Byte.MIN_VALUE` a `Byte.MAX_VALUE`) e só imprime o valor convertido se estiver — senão, imprime uma mensagem avisando que o valor não cabe.

**32. Calculadora de média — o erro e o conserto** ⭐⭐⭐
Escreva um método que recebe 3 notas como `int` e devolve a média como `double`. Primeiro, escreva-o **errado de propósito** (dividindo a soma inteira por `3` sem cast) e observe o resultado truncado. Depois corrija fazendo o cast no lugar certo, comparando os dois resultados.

---

## Seção 9 — Operadores

**33. Divisão inteira na prática** ⭐
Calcule e imprima `7 / 2` e `7.0 / 2`. Escreva sua previsão dos dois resultados **antes** de rodar.

**34. O sinal do resto** ⭐
Calcule `-7 % 3` e `7 % -3`. Confirme se o resultado bate com a regra "segue o sinal do dividendo" descrita na teoria.

**35. Curto-circuito com `&&`, provado na prática** ⭐⭐
Crie um método `boolean logAndRetornaTrue()` que imprime uma mensagem e devolve `true`. Escreva uma expressão `false && logAndRetornaTrue()` e comprove, pela ausência da mensagem impressa, que o método nunca chegou a ser chamado.

**36. Curto-circuito com `||`** ⭐⭐
Repita o exercício anterior com `||`: comprove que `true || logAndRetornaTrue()` também não chama o método.

**37. Curto-circuito evitando `NullPointerException`** ⭐⭐
Declare um `Produto p = null;`. Escreva `if (p != null && p.preco > 100)` e comprove que o programa não quebra, mesmo `p` sendo `null`. Depois, só para comparar, escreva a versão sem a checagem de `null` e observe a exceção.

**38. Pré-incremento vs. pós-incremento** ⭐⭐
Declare `int x = 5;`. Calcule `int y = x++;` e, na sequência, `int z = ++x;`. Imprima `x`, `y` e `z`, e explique cada valor num comentário.

**39. Simulador de caixa com operadores compostos** ⭐⭐⭐
Escreva um pequeno simulador de caixa: um saldo inicial, e uma sequência de pelo menos 5 operações usando `+=`/`-=` (depósitos e saques), imprimindo o saldo atualizado a cada operação.

**40. Precedência: com e sem parênteses** ⭐⭐⭐
Escreva 3 expressões aritméticas **sem** parênteses que misturem pelo menos `+`, `*` e `%`. Preveja o resultado de cada uma antes de rodar. Depois, reescreva as mesmas 3 expressões usando parênteses para deixar a ordem inequívoca, e confirme que o resultado não muda.

**41. Mini folha de pagamento** ⭐⭐⭐⭐
Dado um salário bruto (`double`), calcule um desconto usando operadores aritméticos, aplicando um teto máximo de desconto com uma condição composta (`&&`/`||`). Não se preocupe em ser fiel à legislação real — o objetivo aqui é só combinar operadores aritméticos, relacionais e lógicos num cenário só.

---

## Fechando

Depois de resolver o máximo que conseguir aqui — especialmente a Seção 7 — siga para `02-exercicios-strings-io-condicionais-loops-arrays-metodos.md`. Ela retoma primitivo vs. referência com força total em **pass-by-value**.
