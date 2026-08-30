# Exercícios de Java — Índice e Guia de Uso

Esta coleção acompanha, exercício a exercício, os 9 arquivos teóricos da sua série "Java para Back-End" (Partes 1 a 7, com 3 e 5 divididas em A/B). São **348 exercícios**, começando do mais básico possível e indo até cenários "orientados a Back-End" que antecipam o que você vai ver no Spring.

## Como usar

1. **Leia (ou revise) a parte teórica correspondente antes de tentar os exercícios daquele arquivo.** Cada arquivo de exercícios começa apontando para o arquivo teórico que ele acompanha.
2. **Siga a ordem dentro de cada arquivo.** Os exercícios estão agrupados por seção (na mesma ordem do arquivo teórico) e, dentro de cada seção, progridem do mais simples para o mais elaborado.
3. **Tente sem consultar a teoria primeiro.** Errar é esperado e faz parte — o objetivo é você descobrir *onde* estão suas dúvidas reais, exatamente como o próprio material original propõe.
4. **Não pule os exercícios ⭐ (básicos), mesmo que pareçam fáceis demais.** Eles existem para fixar o gesto antes da complexidade aumentar — principalmente nos temas em que você mencionou ainda se perder.
5. **Escreva um pequeno teste manual (ou um `main` com alguns `println`) para cada exercício**, já que você vai treinar a escrever seus próprios testes JUnit por conta própria. Isso também é, por si só, um ótimo exercício de verificação.

## Legenda de dificuldade

Usada de forma consistente em todos os arquivos:

| Símbolo | Significado |
|---|---|
| ⭐ | Básico — fixa um conceito isolado |
| ⭐⭐ | Intermediário — combina 2-3 conceitos |
| ⭐⭐⭐ | Avançado — mais passos, casos de borda, ou vários conceitos da mesma parte |
| ⭐⭐⭐⭐ | Desafio / Orientado a Back-End — cenário mais completo, geralmente antecipando um padrão que reaparece no Spring |

Outros símbolos que aparecem ocasionalmente: 💡 é uma dica ou um complemento; quando um exercício traz uma entrada e saída esperadas, elas aparecem como *Exemplo*.

## Sobre testes unitários

Por pedido seu, **não há exercícios dedicados a escrever testes JUnit** — o arquivo `06` inclusive avisa isso explicitamente na abertura. A ideia é que você escreva seus próprios testes, na mão, para validar as soluções dos outros 348 exercícios — é, na prática, ainda mais prática de testes do que um bloco isolado teria te dado.

## Sobre gabaritos

Este material **não inclui soluções prontas** — de propósito. Isso é o que faz o exercício valer a pena. Se travar em algum, quando quiser volte à conversa e peça: posso dar uma dica, revisar seu código, ou mostrar uma solução comentada de um exercício específico a qualquer momento.

---

## Índice completo

| Arquivo | Tema | Nº de exercícios | Acompanha |
|---|---|---|---|
| `01-exercicios-jvm-jre-jdk-fundamentos.md` | JVM/JRE/JDK, tipos primitivos, primitivo vs. referência, casting, operadores | 41 | `01-jvm-jre-jdk-e-fundamentos.md` |
| `02-exercicios-strings-io-condicionais-loops-arrays-metodos.md` | Strings, Scanner, condicionais, loops, arrays, métodos, pass-by-value | 62 | `02-strings-io-condicionais-loops-arrays-metodos.md` |
| `03a-exercicios-poo-classes-encapsulamento-heranca-polimorfismo-abstracao.md` | Classes, encapsulamento, herança, polimorfismo, abstração | 31 | `03a-poo-classes-encapsulamento-heranca-polimorfismo-abstracao.md` |
| `03b-exercicios-interfaces-modificadores-static-final-construtores-this-super.md` | Interfaces, modificadores de acesso, static/final, construtores, this/super | 34 | `03b-interfaces-modificadores-static-final-construtores-this-super.md` |
| `04-exercicios-enums-exceptions-collections-generics-autoboxing.md` | Enums, Exceptions, Collections, Generics, Autoboxing | 45 | `04-enums-exceptions-collections-generics-autoboxing.md` |
| `05a-exercicios-object-equals-hashcode-comparable-comparator-datas.md` | Object, equals/hashCode, Comparable/Comparator, java.time (+ complemento sobre `TemporalAdjusters`) | 34 | `05a-object-equals-hashcode-comparable-comparator-datas.md` |
| `05b-exercicios-lambda-streams-optional.md` | Lambda, interfaces funcionais, Stream API, Optional | 41 | `05b-lambda-streams-optional.md` |
| `06-exercicios-infraestrutura-e-ferramentas.md` | Pacotes, imutabilidade, memória/GC, concorrência, I/O, Maven, Annotations, Reflection | 29 | `06-infraestrutura-e-ferramentas.md` |
| `07-exercicios-solid-boas-praticas.md` | SOLID, Clean Code, refatoração, "encontre o erro" | 31 | `07-solid-boas-praticas-checklist-projetos-final.md` |
| **Total** | | **348** | |

## Um destaque: `TemporalAdjusters`

Você mencionou ter visto `TemporalAdjuster` em algum exercício e ficado sem saber de onde vinha — pesquisei e confirmei que essa classe **não aparece** no seu material teórico original (`05a`). Por ser uma ferramenta real e útil do `java.time`, adicionei um pequeno complemento com explicação + exemplos + exercícios progressivos sobre ela dentro de `05a-exercicios-...md`, na seção de Datas. Vale a pena ler esse trecho com calma — é exatamente a lacuna que você apontou.

## Ordem sugerida

A mesma ordem da série original — siga a numeração dos arquivos de cima para baixo. Se algum tema específico já estiver bem consolidado para você, não tem problema pular direto para a seção correspondente dentro do arquivo (todos estão organizados por seção, então é fácil ir direto ao ponto).

Depois de terminar tudo, o próprio arquivo `07-solid-boas-praticas-checklist-projetos-final.md` já traz, na Seção 6, uma sequência de **10 projetos práticos crescentes** (de ⭐ a ⭐⭐⭐⭐⭐) — esse é o exame final antes do Spring Boot.

Boa prática! 🚀
