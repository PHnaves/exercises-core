# Exercícios — Parte 3B: Interfaces, Modificadores de Acesso, static/final, Construtores e this/super

> 🧭 Acompanha o arquivo `03b-interfaces-modificadores-static-final-construtores-this-super.md`. Esta parte fecha POO — é também a que tem mais peso direto para quando você abrir seu primeiro projeto Spring.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Interfaces

**1. Sua primeira interface** ⭐
Crie uma interface `Pagavel` com o método abstrato `pagar(double valor)`. Implemente-a numa classe `Boleto`. Instancie e chame o método.

**2. Múltiplas interfaces, uma classe só** ⭐⭐
Crie duas interfaces pequenas, `Logavel` (com `log(String mensagem)`) e `Auditavel` (com `auditar()`). Crie uma classe `ServicoNotificacao implements Logavel, Auditavel`, implementando os dois métodos. Confirme que isso compila normalmente (diferente de herança de classe, que só aceita uma superclasse).

**3. Tentando instanciar uma interface** ⭐
Tente escrever `new Pagavel()` diretamente. Leia o erro de compilação e compare com o erro do Exercício 26 do arquivo `03a` (tentar instanciar uma classe abstrata) — são parecidos?

**4. Método `default`** ⭐⭐
Adicione um método `default` a `Pagavel` chamado `pagarComDesconto(double valor, double percentual)`, que calcula o valor com desconto e chama `pagar(...)` internamente. Teste com sua implementação `Boleto`, sem precisar reescrever esse método nela.

**5. Método `static` de interface** ⭐⭐
Adicione um método `static boolean valorValido(double valor)` a `Pagavel`, retornando `valor > 0`. Chame-o diretamente pela interface (`Pagavel.valorValido(50.0)`), sem nenhuma instância.

**6. Interface vs. classe abstrata — decida você** ⭐⭐⭐
Para cada cenário a seguir, decida se você usaria uma interface ou uma classe abstrata, e justifique em uma frase: (a) você precisa compartilhar um atributo com estado entre várias subclasses; (b) classes completamente não relacionadas (`Impressora`, `Pessoa`, `Robo`) precisam, todas, ser capazes de `imprimir()`; (c) você quer garantir que um construtor sempre rode uma validação antes de qualquer subclasse ser criada.

**7. Ambiguidade de `default` (diamond problem)** ⭐⭐⭐
Crie duas interfaces com um método `default` de **mesma assinatura** (ex: `resumo()`). Crie uma classe que implementa as duas ao mesmo tempo, tente compilar, leia o erro, e resolva sobrescrevendo o método explicitamente na classe.

**8. "Programar para abstrações" — sua primeira vez de verdade** ⭐⭐⭐
Recrie o exemplo `UserRepository`/`UserService` da teoria em miniatura: uma interface `Notificador` com `enviar(String mensagem)`, duas implementações concretas (`NotificadorEmail`, `NotificadorSms`), e uma classe `ServicoAlerta` que recebe um `Notificador` no construtor e o usa sem saber qual implementação é. Troque a implementação passada ao `ServicoAlerta` e confirme que o comportamento muda sem alterar `ServicoAlerta`.

**9. Repositório completo por trás de uma interface** ⭐⭐⭐⭐
Implemente o exemplo `UserRepository`/`UserService` da teoria por completo: crie a interface `UserRepository` com `salvar(Usuario usuario)` e `buscarPorId(int id)`; crie uma implementação `UserRepositoryEmMemoria` usando um array (Parte 2) para guardar os usuários; crie `UserService`, recebendo o repositório via construtor (`private final UserRepository repository`) e expondo um método `cadastrar(Usuario usuario)`. Comprove que `UserService` funciona sem nunca mencionar `UserRepositoryEmMemoria` diretamente — só a interface.
> 💡 *Dica:* isso é, lado a lado, o mesmo desenho que você vai ver num projeto Spring Boot real — só que lá é o Spring quem cria e injeta o `UserRepositoryEmMemoria` (ou equivalente) pra você.

---

## 2. Modificadores de acesso

**10. Os 4 níveis, na prática** ⭐⭐
Crie uma classe `Pessoa` com um atributo de cada nível de visibilidade (`private`, *default*, `protected`, `public`). Numa segunda classe, no **mesmo pacote**, tente acessar os 4 e veja quais compilam.

**11. `protected` entre pacotes, com subclasse e sem subclasse** ⭐⭐⭐
Crie 3 classes em 2 pacotes diferentes: uma classe base com um atributo `protected`, no pacote A; uma subclasse dela no pacote B; e uma terceira classe **não relacionada** (não é subclasse), também no pacote B. Comprove que a subclasse acessa o atributo `protected` normalmente, mas a terceira classe não consegue.

**12. *Default* não é `public`** ⭐⭐
Crie uma classe sem nenhum modificador explícito num pacote `com.exemplo.a`, e tente acessá-la de uma classe em `com.exemplo.b`. Confirme, pelo erro de compilação, que *default* (package-private) é mais restrito do que muita gente assume.

**13. Reduzindo a visibilidade de propósito** ⭐⭐⭐
Pegue uma classe já pronta de exercícios anteriores (ex: `Produto`) e reorganize os métodos dela em: métodos que fazem parte da "API pública" da classe (`public`) e métodos auxiliares internos que só a própria classe deveria chamar (`private`). Justifique, num comentário, cada escolha.

**14. Menor privilégio possível** ⭐⭐
Revise uma classe qualquer que você já escreveu em exercícios anteriores e verifique: existe algum atributo `public` que poderia (e deveria) ser `private`? Existe algum método que só é usado internamente pela própria classe e poderia virar `private`? Reescreva a classe aplicando o princípio do menor privilégio.

---

## 3. `static` e `final`

**15. Contador de instâncias** ⭐
Recrie a classe `Contador` da teoria (com `static int totalContadores` e um construtor que incrementa). Crie 4 instâncias e imprima `Contador.totalContadores` e o `idInstancia` de cada uma.

**16. Método utilitário `static`** ⭐
Escreva uma classe `Calculadora` com um método `static int somar(int a, int b)`, e chame-o **sem** instanciar a classe (`Calculadora.somar(2, 3)`).

**17. O erro clássico: instância a partir de `static`** ⭐⭐
Escreva uma classe com um atributo de instância `int valor = 10;` e, dentro do `main` (que é `static`), tente imprimir `valor` diretamente sem instanciar a classe. Leia o erro de compilação, e corrija de duas formas: criando uma instância, ou tornando `valor` também `static` (discuta, num comentário, qual das duas opções faz mais sentido para esse caso).

**18. Bloco estático de inicialização** ⭐⭐
Crie uma classe `Configuracao` com um `Map<String, String>` estático (pode usar `HashMap`, mesmo sem ter visto a fundo ainda), inicializado dentro de um bloco `static { ... }` com pelo menos 3 pares chave-valor.

**19. Constante de verdade: `static final`** ⭐
Declare uma constante `public static final double TAXA_JUROS = 0.02;` numa classe, e use-a em um cálculo simples em outro método/classe, acessando-a como `NomeDaClasse.TAXA_JUROS`.

**20. `final` numa referência não é imutabilidade** ⭐⭐
Declare `final Pessoa p = new Pessoa("Ana");`. Altere o nome dela via `p.setNome("Beatriz")` (isso deve funcionar). Depois, tente `p = new Pessoa("Carla");` (isso **não** deve compilar). Explique num comentário a diferença entre os dois casos.

**21. Método `final` não pode ser sobrescrito** ⭐⭐
Crie uma superclasse com um método `final respirar()`. Numa subclasse, tente sobrescrever esse método com `@Override`. Leia o erro de compilação.

**22. Classe `final` não pode ser estendida** ⭐⭐
Crie uma classe `Configuracao` marcada como `final`. Tente criar `class Configuracao2 extends Configuracao`. Leia o erro.

**23. `static` sem necessidade — identifique o problema** ⭐⭐⭐
Veja esta classe: `public class CalculadoraDeFrete { static double pesoAtual; static double calcularFrete() { ... } }`. Explique, em algumas frases, por que usar `static` aqui (para guardar um estado que deveria pertencer a **um pedido específico**) é um problema, e reescreva a classe sem `static`, como uma classe de instância normal.

---

## 4. Construtores

**24. Construtor padrão vs. parametrizado** ⭐
Crie uma classe `Livro` **sem nenhum construtor escrito**, instancie normalmente. Depois, adicione um construtor com parâmetros (`titulo`, `autor`) e tente instanciar `new Livro()` (sem argumentos) de novo — leia o erro, e explique num comentário o porquê.

**25. Sobrecarga de construtores** ⭐⭐
Escreva uma classe com **3 construtores sobrecarregados** (parâmetros diferentes cada um).

**26. Encadeando com `this(...)`** ⭐⭐
Reescreva o exercício anterior usando `this(...)` para que os construtores mais simples chamem o mais completo, evitando duplicar lógica de inicialização.

**27. `this(...)` fora da primeira linha — o erro** ⭐⭐
Num construtor que usa `this(...)`, tente colocar uma linha de código **antes** da chamada a `this(...)`. Leia o erro de compilação.

**28. Os passos de `new`, na prática** ⭐⭐⭐
Crie uma classe com um construtor que imprime uma mensagem de log logo na primeira linha, e um atributo `numeroDeSequencia` calculado a partir de um contador `static`. Instancie 3 objetos e, observando a ordem das mensagens impressas, confirme os passos descritos na teoria: alocação → valores padrão → execução do construtor → referência devolvida.

**29. Construtor validando o estado inicial** ⭐⭐⭐
Escreva uma classe `Retangulo` cujo construtor lança `IllegalArgumentException` se `largura` ou `altura` forem menores ou iguais a zero — garantindo que **nunca** existe um `Retangulo` num estado inválido, nem por um instante.

**30. Construtor "de cópia"** ⭐⭐⭐⭐
Escreva um construtor adicional que recebe **outro objeto do mesmo tipo** e copia os valores dele (ex: `public Pessoa(Pessoa outra) { this.nome = outra.nome; ... }`). Use-o para criar uma cópia independente de um objeto já existente, e comprove (alterando um atributo da cópia) que o original não é afetado.

---

## 5. `this` e `super` aprofundados

**31. `this.` desambiguando** ⭐
Escreva um construtor cujos parâmetros tenham exatamente o mesmo nome dos atributos (`nome`, `idade`), usando `this.nome = nome;` para diferenciar. Remova o `this.` de propósito e observe o que acontece com o valor do atributo depois de instanciar.

**32. `super.atributo`** ⭐⭐
Crie uma superclasse e uma subclasse que declaram um atributo de **mesmo nome** (situação incomum, mas didática). Na subclasse, use `super.atributo` para acessar explicitamente o da superclasse, e `this.atributo` (ou só `atributo`) para acessar o da própria subclasse.

**33. `super.metodo()` para complementar** ⭐⭐
Sobrescreva um método numa subclasse chamando `super.metodo()` como primeira linha, e adicionando lógica própria depois — sem duplicar o que a superclasse já faz.

**34. Hierarquia salarial completa (`this` + `super` juntos)** ⭐⭐⭐
Recrie a hierarquia `Funcionario`/`Gerente` da teoria, e adicione uma terceira subclasse `Diretor extends Gerente`, com sua própria regra de bônus (por exemplo, um bônus adicional sobre o que `Gerente` já calcula). Use `super(...)` no construtor e `super.calcularSalario()` no cálculo, encadeando os 3 níveis.

---

## Fechando

Isso fecha Programação Orientada a Objetos. Antes de seguir, um teste rápido: você consegue explicar, sem consultar nada, os 4 usos de `this`/`super` (`this.`, `this()`, `super.`, `super()`) de cabeça? Se sim, siga para `04-exercicios-enums-exceptions-collections-generics-autoboxing.md`.
