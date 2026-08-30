# Exercícios — Parte 3A: POO — Classes, Encapsulamento, Herança, Polimorfismo e Abstração

> 🧭 Acompanha o arquivo `03a-poo-classes-encapsulamento-heranca-polimorfismo-abstracao.md`. Esta é, segundo o próprio material teórico, a parte mais importante da série — capriche aqui.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Classes e objetos

**1. Sua primeira classe** ⭐
Crie uma classe `Produto` com atributos `nome` e `preco`, e um método `exibirDetalhes()` que imprime os dois. Instancie **dois** produtos diferentes, chame o método nos dois, e confirme que cada objeto mantém seu próprio estado.

**2. Vários objetos, um método só** ⭐
Crie uma classe `Livro` (título, autor, número de páginas) e um método `resumo()`. Instancie 3 livros diferentes, guarde-os num array `Livro[]`, e chame `resumo()` em cada um usando um `for-each`.

**3. Atributo vs. variável local** ⭐⭐
Na classe `Produto` do exercício 1, adicione um método `aplicarDesconto(double percentual)` que declara uma variável local `precoComDesconto` e a imprime. Explique, num comentário, por que essa variável não pode ser acessada de fora do método (releia a Parte 2 se precisar).

**4. Métodos que usam vários atributos** ⭐⭐
Crie uma classe `Retangulo` com `largura` e `altura`, e métodos `calcularArea()` e `calcularPerimetro()`. Instancie um retângulo e imprima os dois cálculos.

**5. Objeto dentro de objeto (composição simples)** ⭐⭐⭐
Crie uma classe `Endereco` (rua, cidade) e uma classe `Pessoa` que **tem um** `Endereco` como atributo (não herda — guarda uma referência). Instancie uma `Pessoa` com seu `Endereco`, e imprima os dados combinados num único método `exibirPessoaCompleta()`.

---

## 2. Encapsulamento

**6. Encapsulando `Produto`** ⭐⭐
Reescreva a classe `Produto` do exercício 1: torne `nome` e `preco` `private`, adicione getters e setters, e valide em `setPreco` que o valor não pode ser negativo (lance `IllegalArgumentException` se for — mesmo sem ter estudado exceptions a fundo ainda, você já viu esse exemplo na teoria).

**7. Setter com múltiplas validações** ⭐⭐
Crie uma classe `ContaBancaria` com `saldo` privado. Escreva um método `depositar(double valor)` que só aceita valores positivos, e um `sacar(double valor)` que só permite o saque se houver saldo suficiente — em ambos os casos, decida (e documente num comentário) o que fazer quando a regra é violada.

**8. Nem tudo precisa de setter** ⭐⭐
Crie uma classe `Pedido` com um atributo `numeroPedido` que é definido **apenas no construtor** (sem setter — uma vez criado, não muda). Adicione um atributo `status`, esse sim com setter. Explique, num comentário, por que faz sentido `numeroPedido` não ter setter.

**9. Comparando com e sem encapsulamento** ⭐⭐⭐
Crie duas versões da mesma classe `Idade`: uma com o atributo `valor` público (sem validação nenhuma) e outra `private` com validação no setter. Tente, nas duas versões, atribuir um valor negativo, e compare o que acontece em cada uma.

**10. Getter que calcula, em vez de apenas devolver** ⭐⭐⭐
Crie uma classe `Pessoa` com `dataNascimento` (pode usar `int idadeEmAnos` por enquanto, se preferir não usar `java.time` já) e um getter `getIdade()` que **calcula** a idade em vez de guardá-la como atributo separado. Explique, num comentário, a vantagem disso (dica: releia o trecho sobre "reduz acoplamento" na teoria).

**11. Mini sistema de estoque com validação de negócio** ⭐⭐⭐⭐
Crie uma classe `ItemEstoque` (nome, quantidade) totalmente encapsulada. O método `retirar(int quantidade)` deve validar que não é possível retirar mais do que existe em estoque, lançando uma exceção nesse caso. O método `adicionar(int quantidade)` deve rejeitar quantidades negativas ou zero.

---

## 3. Herança

**12. Sua primeira subclasse** ⭐
Usando a classe `Animal` da teoria (ou recriando-a), crie uma classe `Gato extends Animal`, sobrescrevendo `emitirSom()` para imprimir `"Miau"`. Instancie e chame o método.

**13. `super(...)` obrigatório** ⭐⭐
Crie uma superclasse `Veiculo` com um construtor que exige uma `String modelo` (sem construtor vazio). Crie uma subclasse `Carro extends Veiculo` e tente compilar **sem** chamar `super(modelo)` no construtor de `Carro` — leia o erro, depois corrija.

**14. `super.metodo()` complementando** ⭐⭐
Na subclasse `Gato` (ou `Cachorro`, se preferir), sobrescreva `emitirSom()` chamando `super.emitirSom()` primeiro, e depois complementando com uma linha extra própria do gato.

**15. Hierarquia de 3 níveis** ⭐⭐⭐
Crie `Funcionario` → `Gerente extends Funcionario` → `Diretor extends Gerente`, cada nível adicionando um atributo novo e usando `super(...)` para inicializar a parte herdada corretamente.

**16. Herança vs. composição — identifique o problema** ⭐⭐⭐
Veja esta relação: `class RelatorioPDF extends ConexaoBanco`. Explique, em algumas frases, por que essa herança está semanticamente errada (não é uma relação "é um"), e reescreva usando composição (uma referência a `ConexaoBanco` dentro de `RelatorioPDF`, em vez de herança).

**17. `protected` entre pacotes** ⭐⭐⭐⭐
Crie uma superclasse com um atributo `protected` num pacote, e uma subclasse **em outro pacote**. Confirme que a subclasse acessa o atributo `protected` normalmente. (Se quiser ir além, veja o Exercício 5 do arquivo `03b`, que aprofunda modificadores de acesso entre pacotes.)

---

## 4. Polimorfismo

**18. O exemplo que você precisa dominar** ⭐
Escreva `Animal animal = new Gato();` seguido de `animal.emitirSom();`. Antes de rodar, escreva num comentário qual som você espera que apareça, e por quê (mesmo a variável sendo do tipo `Animal`).

**19. Array polimórfico** ⭐⭐
Crie um array `Animal[]` misturando pelo menos 2 subtipos diferentes (ex: `Gato`, `Cachorro`). Percorra com um `for-each` chamando `emitirSom()` em cada um, e confirme que cada objeto usa sua própria versão do método.

**20. Overloading — identifique quantas versões existem** ⭐⭐
Escreva uma classe `Calculadora` com pelo menos 3 versões sobrecarregadas de um método `somar` (variando tipo e/ou quantidade de parâmetros). Chame as 3 a partir do `main`.

**21. Overloading vs. Overriding — na prática, lado a lado** ⭐⭐
No mesmo programa: (a) mostre um exemplo de **overloading** (mesmo nome, parâmetros diferentes, mesma classe); (b) mostre um exemplo de **overriding** (mesma assinatura, superclasse/subclasse). Escreva um comentário para cada um dizendo, explicitamente, se a decisão de qual método roda acontece em tempo de compilação ou de execução.

**22. Pegadinha clássica de prova** ⭐⭐⭐
Dada uma superclasse `Animal` com `emitirSom()` e uma subclasse `Cachorro` com um método `emitirSom(String intensidade)` (parâmetro **a mais**), explique por que isso é overloading, não overriding — e o que aconteceria se você esperava uma sobrescrita.

**23. Polimorfismo com Lista (prévia da Parte 4)** ⭐⭐⭐
Crie uma `List<Animal>` (pode usar `ArrayList`, mesmo sem ter estudado a fundo ainda) misturando subtipos, adicione vários, e percorra chamando `emitirSom()` em cada um.

**24. Sistema de formas geométricas polimórfico** ⭐⭐⭐⭐
Crie uma hierarquia `Forma` (pode ser interface ou classe abstrata — você vai decidir isso formalmente daqui a pouco, na Seção 5) com pelo menos 3 formas concretas diferentes, cada uma com seu próprio `calcularArea()`. Crie um array/lista de `Forma` misturado, percorra somando a área total de todas as formas, sem o código de soma "saber" qual forma específica está processando a cada volta.

---

## 5. Abstração

**25. Sua primeira classe abstrata** ⭐
Recrie a classe abstrata `Forma` da teoria (com `calcularArea()` abstrato e `exibirArea()` concreto). Crie uma subclasse `Quadrado` implementando `calcularArea()`, instancie, e chame `exibirArea()`.

**26. Tentando instanciar o que não pode** ⭐
Tente escrever `new Forma()` (a classe abstrata) diretamente. Leia o erro de compilação.

**27. Subclasse incompleta** ⭐⭐
Crie uma subclasse de `Forma` que **não** implementa `calcularArea()`. Leia o erro do compilador, e resolva de duas formas diferentes: implementando o método, ou marcando a própria subclasse como `abstract` também.

**28. Métodos abstratos e concretos misturados** ⭐⭐
Crie uma classe abstrata `Funcionario` com um método abstrato `calcularSalario()` e um método concreto `exibirFuncionario()` que usa o resultado de `calcularSalario()` internamente. Crie duas subclasses (`FuncionarioCLT`, `FuncionarioPJ`) com regras de cálculo diferentes, e chame `exibirFuncionario()` nas duas — confirme que cada uma usa sua própria versão de `calcularSalario()`, mesmo esse método sendo chamado de **dentro** de um método herdado.

**29. Template Method simples** ⭐⭐⭐
Crie uma classe abstrata `RelatorioBase` com um método concreto `gerar()` que chama, em sequência, três métodos abstratos: `cabecalho()`, `corpo()` e `rodape()`. Crie duas subclasses (`RelatorioVendas`, `RelatorioEstoque`) implementando os três métodos de formas diferentes, e chame `gerar()` nas duas.
> 💡 *Dica:* isso é, em miniatura, o padrão de projeto *Template Method* citado na teoria — vale conhecer o nome.

**30. Sistema de pagamento polimórfico (integra tudo)** ⭐⭐⭐⭐
Modele um mini "sistema de pagamento": uma classe abstrata `MetodoPagamento` com um método abstrato `processar(double valor)`, e três subclasses concretas — `CartaoCredito`, `Pix`, `Boleto` — cada uma implementando `processar()` com uma mensagem diferente simulando o processamento. Escreva um método `processarPedido(MetodoPagamento metodo, double valor)` que só chama `metodo.processar(valor)`, e teste passando as três implementações diferentes.
> 💡 *Dica:* isso é, em miniatura, exatamente o tipo de despacho polimórfico que um `PaymentService` real faria em produção.

---

## Desafio integrador da Parte 3A

**31. Sistema de veículos com os 4 pilares juntos** ⭐⭐⭐⭐
Modele uma hierarquia `Veiculo` (classe abstrata, com atributos encapsulados como `placa` e `velocidadeAtual`, e um método abstrato `calcularImposto()`). Crie pelo menos 3 subclasses (`Carro`, `Moto`, `Caminhao`), cada uma com sua própria regra de imposto, e pelo menos um atributo extra específico. Monte uma lista `List<Veiculo>` (ou array) misturando as 3, e escreva um método que recebe essa lista e imprime o imposto total de todos, sem nunca precisar de um `if`/`instanceof` para saber qual subtipo está processando — o polimorfismo deve resolver isso sozinho.

---

## Fechando

Você acabou de praticar os 4 pilares da POO isoladamente e de forma combinada. Antes de seguir, vale a pena revisar mentalmente: você conseguiria explicar, sem olhar a teoria, por que `Animal animal = new Cachorro();` compila e funciona? Se sim, siga para `03b-exercicios-interfaces-modificadores-static-final-construtores-this-super.md`, que fecha POO com interfaces, `static`/`final`, construtores e `this`/`super`.
