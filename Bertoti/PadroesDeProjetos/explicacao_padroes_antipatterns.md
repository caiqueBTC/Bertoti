# Análise dos Padrões de Projeto e Antipatterns Implementados

## 1. Padrão Composite (Estrutural) 🌳

**O que é o Padrão Composite?**
O Padrão Composite é um padrão estrutural que permite compor objetos em estruturas de árvore para representar hierarquias parte-todo. Ele permite que os clientes tratem objetos individuais e composições de objetos de maneira uniforme.

* **Implementação do Padrão**:
    * A interface `ItemDeVenda` estabelece o contrato comum para componentes individuais e agrupamentos (kits), definindo operações como `getNome()` e `getPreco()`.
        ```java
        // Bertoti/PadroesDeProjetos/Composite/Pattern Composite/src/ItemDeVenda.java
        public interface ItemDeVenda {
            String getNome();
            double getPreco();
            void adicionarItem(ItemDeVenda item) throws UnsupportedOperationException;
            void listarItens();
        }
        ```
    * `ComponentePCUnitario` representa um "Leaf" (folha), um item individual. Como tal, operações de adição de subitens (`adicionarItem()`) não são suportadas e lançam exceções.
    * `KitPC` representa o "Composite" (composto). Ele armazena uma coleção de `ItemDeVenda` (que podem ser `ComponentePCUnitario` ou outros `KitPC`), permitindo a criação de estruturas em árvore. O cálculo do preço em `KitPC` agrega os preços dos seus componentes, podendo aplicar lógicas adicionais (como um desconto).
        ```java
        // Bertoti/PadroesDeProjetos/Composite/Pattern Composite/src/KitPC.java
        public class KitPC implements ItemDeVenda {
            private List<ItemDeVenda> componentes = new ArrayList<>();
            // ... (lógica de adicionarItem e getPreco)
        }
        ```
    * `MainDemonstracaoPattern.java` exemplifica o uso, tratando `ComponentePCUnitario` e `KitPC` de forma homogênea para operações como obtenção de preço.

* **Antipattern Explorado**:
    * `PCBasicoMontagemFixa` demonstra a ausência de flexibilidade. Esta classe possui atributos fixos para cada tipo de componente.
        ```java
        // Bertoti/PadroesDeProjetos/Composite/antipatern/src/main/java/com/antipatterncomposite/src/PCBasicoMontagemFixa.java
        public class PCBasicoMontagemFixa {
            private ComponentePCAntiPattern processador;
            private ComponentePCAntiPattern memoriaRAM;
            // ...
        }
        ```
    * **Problema**: A rigidez estrutural impede a fácil adição ou variação de componentes (ex: adicionar uma placa de vídeo ou múltiplos SSDs) sem modificar a classe `PCBasicoMontagemFixa`. A flexibilidade para tratar diversas configurações de kit de forma uniforme é perdida.

* **Para saber mais sobre Composite**:
    * 🎥 **Vídeo Explicativo**: [Padrão de Projeto Composite em Detalhes (Refactoring Guru)](https://www.youtube.com/watch?v=E2cSWd2z6n0)
    * 📄 **Artigo**: [Composite Pattern - Refactoring Guru](https://refactoring.guru/pt/design-patterns/composite)

---

## 2. Padrão Observer (Comportamental) 📡

**O que é o Padrão Observer?**
O Padrão Observer é um padrão comportamental que estabelece uma dependência um-para-muitos entre objetos. Quando o estado de um objeto (o "sujeito") muda, todos os seus dependentes (os "observadores") são notificados e atualizados automaticamente, promovendo baixo acoplamento entre eles.

* **Implementação do Padrão**:
    * As interfaces `ObservadorInteresse` (Observer) e `SujeitoObservado` (Subject) definem os contratos para os participantes. `ObservadorInteresse` especifica o método `atualizar()`, e `SujeitoObservado` especifica métodos para registrar, remover e notificar observadores.
    * `ProdutoLoja` atua como "ConcreteSubject". Mantém uma lista de `ObservadorInteresse` e, ao ter seu estado alterado (ex: `setPreco()`), invoca `notificarObservadores()`, que por sua vez chama `atualizar()` em cada observador registrado.
        ```java
        // Bertoti/PadroesDeProjetos/Observer/Pattern Observer/src/ProdutoLoja.java
        public class ProdutoLoja implements SujeitoObservado {
            private List<ObservadorInteresse> observadores = new ArrayList<>();
            // ...
            public void setPreco(double novoPreco) {
                // ... (lógica de mudança e chamada a notificarObservadores)
                notificarObservadores("PRECO_ALTERADO", novoPreco);
            }
            // ...
        }
        ```
    * `ClienteInteressado` é o "ConcreteObserver". Implementa `ObservadorInteresse`, definindo a ação a ser tomada (ex: exibir uma mensagem) quando o método `atualizar()` é invocado pelo sujeito.
    * `MainDemonstracaoPatternObserver.java` demonstra o mecanismo, com clientes sendo notificados sobre alterações no produto.

* **Antipattern Explorado**:
    * Em `MainDemonstracaoAntiPatternObserver.java`, as classes `ProdutoLojaAcoplado` e `ClienteNotificacaoAcoplado` exibem acoplamento direto.
        ```java
        // Bertoti/PadroesDeProjetos/Observer/Anti-Pattern Observer/src/MainDemonstracaoAntiPatternObserver.java
        class ProdutoLojaAcoplado {
            private ClienteNotificacaoAcoplado clienteEmail; // Acoplamento direto
            // ...
            public void setPreco(double novoPreco) {
                // ...
                if (clienteEmail != null) clienteEmail.notificarAlteracaoPreco(nomeProduto, preco);
            }
        }
        ```
    * **Problema**: O acoplamento forte limita a flexibilidade. `ProdutoLojaAcoplado` está diretamente ligado a `ClienteNotificacaoAcoplado`, dificultando a adição de novos tipos de observadores ou mecanismos de notificação sem modificar extensivamente a classe `ProdutoLojaAcoplado`.

* **Para saber mais sobre Observer**:
    * 🎥 **Vídeo Explicativo**: [Padrão de Projeto Observer (Listeners e Eventos) por Código Fonte TV](https://www.youtube.com/watch?v=j1nS545gYqM)
    * 📄 **Artigo**: [Observer Pattern - Refactoring Guru](https://refactoring.guru/pt/design-patterns/observer)

---

## 3. Padrão Singleton (Criacional) 👤

**O que é o Padrão Singleton?**
O Padrão Singleton é um padrão criacional que garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a essa instância. É útil para gerenciar recursos compartilhados ou configurações globais.

* **Implementação do Padrão**:
    * A classe `ConfiguracoesSistema` implementa o Singleton da seguinte forma:
        1.  Construtor privado: `private ConfiguracoesSistema()`, prevenindo instanciação externa.
        2.  Instância estática privada: `private static ConfiguracoesSistema instancia;`, para armazenar a única instância.
        3.  Método estático público `getInstancia()`: Responsável por controlar o acesso à instância. Cria a instância na primeira chamada (lazy initialization) e retorna a mesma instância nas chamadas subsequentes.
            ```java
            // Bertoti/PadroesDeProjetos/Singleton/Pattern Singleton/src/ConfiguracoesSistema.java
            public static ConfiguracoesSistema getInstancia() {
                if (instancia == null) {
                    instancia = new ConfiguracoesSistema();
                }
                return instancia;
            }
            ```
    * `Main.java` (na pasta do Singleton) demonstra que chamadas repetidas a `ConfiguracoesSistema.getInstancia()` resultam no mesmo objeto.

* **Antipattern Explorado (versão corrigida)**:
    * A classe `ConfiguracoesGlobaisAntiPattern` (sugerida na conversa anterior, não presente nos arquivos originais) possuiria um construtor público.
    * `MainAntiPatternSingleton.java` (sugerido na conversa anterior) demonstraria a criação de múltiplas instâncias distintas de `ConfiguracoesGlobaisAntiPattern`.
    * **Problema**: A ausência de controle sobre a instanciação permite que múltiplas instâncias de um objeto, que deveria ser conceitualmente único (como uma configuração global), coexistam, podendo levar a inconsistências.

* **Para saber mais sobre Singleton**:
    * 🎥 **Vídeo Explicativo**: [Padrão de Projeto Singleton em Detalhes (Refactoring Guru)](https://www.youtube.com/watch?v=6dVjGk3Y_zM)
    * 📄 **Artigo**: [Singleton Pattern - Refactoring Guru](https://refactoring.guru/pt/design-patterns/singleton)

---

## 4. Padrão Strategy (Comportamental) 📜

**O que é o Padrão Strategy?**
O Padrão Strategy é um padrão comportamental que permite definir uma família de algoritmos, encapsular cada um deles em classes separadas e torná-los intercambiáveis. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

* **Implementação do Padrão**:
    * A interface `EstrategiaDeDesconto` (Strategy) define o contrato para todos os algoritmos de desconto, com o método principal `calcularPrecoComDesconto()`.
    * Classes concretas como `DescontoFixo`, `DescontoLeveXPagueY`, `DescontoPercentual` e `SemDesconto` implementam `EstrategiaDeDesconto`, cada uma fornecendo uma lógica específica para o cálculo de desconto.
        ```java
        // Bertoti/PadroesDeProjetos/Strategy/Strategypattern/src/DescontoPercentual.java
        public class DescontoPercentual implements EstrategiaDeDesconto {
            // ...
            @Override
            public double calcularPrecoComDesconto(double precoOriginal, int quantidade) {
                return precoOriginal * (1.0 - percentual);
            }
        }
        ```
    * A classe `ItemParaVenda` (Contexto) mantém uma referência a um objeto `EstrategiaDeDesconto`. Ela pode ter sua estratégia alterada em tempo de execução através de `setEstrategiaDeDesconto()`. O método `calcularPrecoFinal()` em `ItemParaVenda` delega o cálculo para o objeto de estratégia atualmente configurado.
        ```java
        // Bertoti/PadroesDeProjetos/Strategy/Strategypattern/src/ItemParaVenda.java
        public class ItemParaVenda {
            private EstrategiaDeDesconto estrategiaDeDesconto;
            // ...
            public double calcularPrecoFinal() {
                // ...
                return estrategiaDeDesconto.calcularPrecoComDesconto(precoOriginalTotal, quantidade);
            }
        }
        ```
    * `MainDemonstracaoPatternStrategy.java` ilustra a aplicação de diferentes estratégias a um item, resultando em diferentes cálculos de preço final.

* **Antipattern Explorado**:
    * `CalculadoraDeDescontoProdutoLegado` utiliza uma série de estruturas `if-else if` para selecionar a lógica de desconto baseada em um parâmetro `String tipoDesconto`.
        ```java
        // Bertoti/PadroesDeProjetos/Strategy/antipatternStrategy/src/CalculadoraDeDescontoProdutoLegado.java
        public double calcularPrecoComDesconto(String tipoDesconto, double precoOriginal, int quantidade) {
            if ("PERCENTUAL_10".equals(tipoDesconto)) { /*...*/ }
            else if ("FIXO_5_REAIS".equals(tipoDesconto)) { /*...*/ }
            // ...
        }
        ```
    * **Problema**: Esta abordagem leva a uma classe com baixa coesão e alto acoplamento condicional. Adicionar novas estratégias de desconto requer modificar a classe existente, violando o Princípio Aberto/Fechado e aumentando a complexidade e o risco de introduzir erros. O uso de strings para determinar a lógica também é propenso a erros.

* **Para saber mais sobre Strategy**:
    * 🎥 **Vídeo Explicativo**: [Padrão de Projeto Strategy em Detalhes (Refactoring Guru)](https://www.youtube.com/watch?v=8_xyshY4g3c)
    * 📄 **Artigo**: [Strategy Pattern - Refactoring Guru](https://refactoring.guru/pt/design-patterns/strategy)

---
