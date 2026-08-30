# Exercícios — Parte 7: SOLID e Boas Práticas

> 🧭 Acompanha o arquivo `07-solid-boas-praticas-checklist-projetos-final.md`. Diferente das partes anteriores, aqui você não vai aprender sintaxe nova — o foco é **refatorar** e **identificar problemas** em código que já "funciona", mas está mal desenhado. Esse tipo de exercício é o que mais separa quem só decorou sintaxe de quem entende o motivo por trás dela.
>
> O arquivo teórico já traz, na Seção 6, uma sequência de **10 projetos práticos** (⭐ a ⭐⭐⭐⭐⭐) para consolidar tudo. Este arquivo não repete esses projetos — use-os como o "exame final" depois de terminar os exercícios menores abaixo.
>
> **Legenda de dificuldade:** ⭐ Básico · ⭐⭐ Intermediário · ⭐⭐⭐ Avançado · ⭐⭐⭐⭐ Desafio / Orientado a Back-End

---

## 1. Single Responsibility (S)

**1. Identifique as responsabilidades misturadas** ⭐
Releia a classe `UsuarioService` "RUIM" da teoria (validação + persistência + e-mail, tudo junto). Liste, em texto, quantas responsabilidades diferentes ela tem — e para cada uma, escreva uma frase dizendo por que motivo diferente essa classe poderia precisar mudar no futuro.

**2. Separando responsabilidades, na prática** ⭐⭐
Pegue uma classe sua de exercícios anteriores que faça mais de uma coisa (por exemplo, um método que valida **e** salva **e** imprime um resumo, tudo junto). Separe-a em classes menores, cada uma com uma única responsabilidade, conectadas por composição.

**3. Quantas razões para mudar?** ⭐⭐
Para cada classe a seguir, diga quantas "razões para mudar" diferentes ela parece ter, e por quê: (a) uma classe `RelatorioVendas` que busca dados, calcula totais, formata como texto e envia por e-mail; (b) uma classe `Produto` que só guarda nome, preço e categoria com getters/setters.

**4. Refatore um "God Method"** ⭐⭐⭐
Escreva (ou pegue de um exercício anterior) um único método grande que faz validação, cálculo e formatação de saída tudo misturado. Quebre-o em 3 métodos menores, cada um com uma responsabilidade clara, mantendo o comportamento final idêntico.

---

## 2. Open/Closed (O)

**5. Identifique a violação** ⭐
Releia o método `calcularTaxa(String tipoPagamento, double valor)` "RUIM" da teoria (uma cadeia de `if` por tipo de pagamento). Explique por que adicionar um novo tipo de pagamento **obriga** você a editar esse método já existente e testado.

**6. Refatorando com polimorfismo** ⭐⭐
Reescreva o método do exercício anterior usando uma interface `MetodoPagamento` com `calcularTaxa(double valor)`, e uma classe concreta por tipo de pagamento (releia a Parte 3A/3B se precisar). Adicione um tipo de pagamento **novo** sem tocar em nenhuma classe já existente.

**7. Um `switch` que também viola OCP** ⭐⭐⭐
Escreva um método com um `switch` que calcula um desconto diferente por categoria de cliente (`"BRONZE"`, `"PRATA"`, `"OURO"`). Identifique por que isso tem o mesmo problema do exemplo de pagamento, e refatore da mesma forma (uma interface + uma implementação por categoria).

**8. Extensão real: adicione um caso sem editar nada** ⭐⭐⭐⭐
Pegue a versão já refatorada (interface + implementações) de qualquer um dos exercícios anteriores desta seção, e adicione um caso completamente novo. Confirme, revisando o `diff` do seu código, que nenhuma linha de uma classe já existente precisou ser alterada — só uma classe nova foi criada.

---

## 3. Liskov Substitution (L)

**9. Reproduza o problema clássico** ⭐⭐
Recrie `Retangulo` e `Quadrado extends Retangulo` exatamente como na teoria (onde `setLargura`/`setAltura` do `Quadrado` alteram os dois lados). Escreva um método `testarRetangulo(Retangulo r)` que chama `setLargura(5)`, depois `setAltura(10)`, e espera `getArea() == 50`. Passe um `Quadrado` para esse método e comprove que o resultado real (`100`) quebra a expectativa.

**10. Por que essa herança está errada** ⭐⭐
Explique, em algumas frases, por que `Quadrado extends Retangulo` viola LSP mesmo sendo, geometricamente, verdade que "todo quadrado é um retângulo". (Dica: pense no que o código que **usa** `Retangulo` tem o direito de assumir sobre o comportamento de `setLargura`/`setAltura`.)

**11. Uma correção possível** ⭐⭐⭐
Reescreva `Retangulo` e `Quadrado` **sem** herança entre eles — cada um implementando uma interface comum `Forma` com `calcularArea()`, sem nenhum setter que altere os dois lados de surpresa.

**12. Encontre outra violação de LSP** ⭐⭐⭐⭐
Modele uma hierarquia `ContaBancaria` → `ContaPoupanca` onde `ContaPoupanca` sobrescreve `sacar(double valor)` lançando uma exceção sempre que é chamado antes do dia 5 do mês (uma regra que `ContaBancaria` normal não tem). Explique por que um código que recebe `ContaBancaria` genericamente e chama `sacar(...)` pode quebrar de forma inesperada ao receber uma `ContaPoupanca` — e discuta uma alternativa de design que evite essa surpresa.

---

## 4. Interface Segregation (I)

**13. Identifique a interface "gorda"** ⭐
Releia a interface `Trabalhador` "RUIM" da teoria (`trabalhar()` + `almocar()`, forçando um `Robo` a implementar `almocar()` sem sentido). Liste todo método daquela interface que **não** faz sentido para todo implementador possível.

**14. Segregando na prática** ⭐⭐
Refatore o exemplo anterior em duas interfaces menores (`Trabalhavel`, `Alimentavel`), e crie uma classe `Funcionario` que implementa as duas, e uma `Robo` que implementa só uma.

**15. Uma interface "gorda" sua** ⭐⭐⭐
Escreva uma interface `Repositorio` com métodos demais (ex: `salvar`, `buscarPorId`, `deletar`, `gerarRelatorioPdf`, `enviarEmailDeConfirmacao`) misturando responsabilidades que não deveriam estar juntas. Identifique quais métodos não fazem sentido para uma implementação simples em memória, e quebre a interface em partes menores e coerentes.

**16. Quando uma interface "gorda" não é problema** ⭐⭐⭐
Pense em um caso onde uma interface com vários métodos **faz sentido** ficar junta (ex: `List<T>` do próprio Java, com dezenas de métodos). O que diferencia esse caso do exemplo `Trabalhador`/`Robo`? (Dica: pense em coesão — os métodos de `List` estão todos relacionados ao mesmo conceito central.)

---

## 5. Dependency Inversion (D)

**17. Sem inversão — identifique o acoplamento** ⭐⭐
Escreva uma classe `UserService` que **cria** sua própria instância de uma implementação concreta dentro do construtor (`this.repository = new UserRepositoryMySQL();`), em vez de recebê-la de fora. Explique, em um comentário, por que isso torna `UserService` difícil de testar isoladamente (sem um banco de dados real).

**18. Aplicando DIP** ⭐⭐
Refatore a classe do exercício anterior para depender de uma interface `UserRepository`, recebida via construtor. Crie duas implementações diferentes (`UserRepositoryEmMemoria` e uma segunda, fictícia, `UserRepositoryArquivo`) e troque qual delas é passada ao `UserService`, sem alterar `UserService`.

**19. Princípio vs. mecanismo** ⭐⭐⭐
Em suas próprias palavras, explique a diferença entre *Dependency Inversion* (o princípio) e *Dependency Injection* (o mecanismo) — e onde, no exercício 18, cada um dos dois aparece.

**20. Duas implementações trocáveis, na prática** ⭐⭐⭐⭐
Pegue o exercício 9 da Parte 3B (`UserRepository`/`UserRepositoryEmMemoria`/`UserService`) e crie uma **segunda** implementação da interface (por exemplo, baseada num `HashMap` em vez de um array, ou lendo de um arquivo texto com a API da Parte 6). Troque qual implementação é injetada no `UserService` alterando **uma única linha** (onde o objeto é construído), sem tocar em `UserService` nem na interface.
> 💡 *Dica:* isso é literalmente o Exercício 9 da Seção 6 do arquivo teórico — vale muito revisitá-lo agora com o vocabulário de SOLID já formado.

**21. Módulo de alto nível dependendo de detalhe — encontre e corrija** ⭐⭐⭐⭐
Escreva uma classe `RelatorioService` que, hoje, depende diretamente de uma classe concreta `GeradorPdfApache` para gerar relatórios (chamando métodos dela diretamente, sem interface). Refatore para que `RelatorioService` dependa de uma interface `GeradorRelatorio`, e mostre como isso permitiria, no futuro, trocar para um gerador de Excel sem alterar `RelatorioService`.

---

## 6. Boas práticas gerais (Clean Code)

**22. Nomes que se explicam sozinhos** ⭐
Pegue um trecho de código seu (de qualquer exercício anterior) com nomes de variáveis curtos ou pouco claros (`qtd`, `p`, `x`, `lst`), e renomeie tudo para nomes que dispensem comentário explicativo.

**23. DRY — eliminando duplicação** ⭐⭐
Encontre (ou escreva de propósito) duas versões quase idênticas do mesmo cálculo em lugares diferentes do seu código (ex: cálculo de imposto repetido em dois métodos). Extraia a lógica comum para um único método reutilizado pelos dois.

**24. Acoplamento alto vs. baixo, lado a lado** ⭐⭐⭐
Escreva duas versões do mesmo cenário pequeno: uma onde uma classe `Pedido` conhece diretamente os detalhes internos de uma classe `Estoque` (acessando atributos dela quase como se fossem seus); e outra onde `Pedido` só conversa com `Estoque` através de métodos públicos bem definidos. Explique, em comentário, por que a segunda versão é mais fácil de manter.

**25. Composição no lugar de herança** ⭐⭐⭐
Pegue um caso de herança "forçada" (ex: uma classe `RelatorioComEmail extends EnviadorDeEmail`, só para reaproveitar um método de envio). Reescreva usando composição — `RelatorioComEmail` **tem um** `EnviadorDeEmail`, em vez de estender.

**26. Revisão completa de código próprio** ⭐⭐⭐⭐
Escolha o exercício mais complexo que você já resolveu nesta coleção (um dos "Desafio" ⭐⭐⭐⭐ de qualquer arquivo anterior) e revise-o aplicando, um por um: nomes significativos, métodos pequenos, DRY, baixo acoplamento, alta coesão, e ao menos um princípio SOLID que fizer sentido para aquele código. Anote, em comentários, o que mudou e por quê.

---

## 7. Encontre o erro (revisão consolidada)

Cada exercício a seguir descreve um trecho de código com um dos "erros comuns de iniciante" listados na Seção 3 do arquivo teórico. Sem olhar a tabela, identifique o erro, explique por que é um problema, e escreva a versão corrigida.

**27. ⭐⭐** Um método recebe dois `String` como parâmetro e os compara com `==` para decidir se são "o mesmo produto".

**28. ⭐⭐** Uma classe sobrescreve `equals()` comparando todos os campos relevantes, mas não sobrescreve `hashCode()`.

**29. ⭐⭐** Um `for-each` percorre uma `List` e chama `lista.remove(item)` diretamente dentro do loop sempre que uma condição é satisfeita.

**30. ⭐⭐⭐** Uma classe de serviço captura `catch (Exception e) { }` (vazio) ao redor de uma chamada que pode falhar de várias formas diferentes.

**31. ⭐⭐⭐** Uma entidade `Pedido` usa `private Optional<String> observacoes;` como atributo, em vez de um campo comum que pode ser `null`.

---

## Fechando a coleção

Se você chegou até aqui e resolveu uma boa parte dos exercícios das 9 partes, o teste real é o que o próprio material teórico propõe: abra qualquer tutorial ou repositório de Spring Boot e veja se você reconhece — sem susto — classes, interfaces, herança, polimorfismo, generics, collections, exceptions, lambdas, streams, `Optional` e inversão de dependência. Se sim, parta para os **10 projetos práticos** da Seção 6 do arquivo teórico como consolidação final, e depois siga para o Spring Boot com uma base sólida.

Boa sorte no Spring. 🚀
