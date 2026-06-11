# Jogo-LPOO-nomeProvisorio-

(README em andamento)

*Descrição do jogo será adicionada depois de definirmos o tema e as mecânicas finais*

## Como executar

## Funcionalidades Implementadas
- Sistema de personagens baseado em herança e polimorfismo.
- Seleção de heróis jogáveis.
- Sistema de inimigos.
- Sistema de batalhas por rodadas.
- Sistema de pontuação.
- Banco de perguntas aleatórias.
- Perguntas de múltipla escolha.
- Perguntas de múltiplas respostas.
- Perguntas de verdadeiro ou falso.
- Perguntas com tempo limite.
- Habilidades especiais exclusivas para cada personagem.
- Interface textual via terminal.

## Estrutura do Projeto
O projeto está organizado em pacotes (packages) com responsabilidades bem definidas, buscando facilitar a manutenção e a expansão do sistema.

### **`core`**

Contém as classes responsáveis pelo funcionamento principal do jogo.

- `Game` – ponto de entrada da aplicação (`Main`).
- `BattleManager` – coordena o fluxo das batalhas.
- `Round` – controla a execução de uma rodada.
- `ScoreSystem` – gerencia a pontuação do jogador.

### **`characters`**

Contém as classes relacionadas aos personagens do jogo.

- `Character` – classe abstrata que define atributos e comportamentos comuns.
- `Ladybug` – personagem equilibrada com habilidade de recuperação de vida.
- `CatNoir` – personagem ofensivo com dano dobrado temporário.
- `Carapace` – personagem defensivo com escudo protetor.
- `RenaRouge` – personagem estratégica capaz de revelar uma alternativa incorreta.
- `Viperion` – personagem que permite uma segunda tentativa de resposta.
- `Vesperia` – personagem que ignora o limite de tempo de uma pergunta.
- `Player` – representa o jogador.
- `Enemy` – representa o oponente.

### **`questions`**

Responsável pelo sistema de perguntas e respostas.

- `Question` – classe abstrata base para todas as perguntas.
- `MultipleChoiceQuestion` – perguntas de múltipla escolha.
- `TrueFalseQuestion` – perguntas de verdadeiro ou falso.
- `TimedMultipleChoiceQuestion` – perguntas de múltipla escolha com tempo limite.
- `TimedTrueFalseQuestion` – perguntas de verdadeiro ou falso com tempo limite.
- `MultipleAnswerQuestion` – perguntas com múltiplas respostas corretas.
- `QuestionBank` – armazena e fornece perguntas durante o jogo.

### **`utils`**

Contém classes utilitárias utilizadas por diferentes partes do sistema.

- `InputHandler` – centraliza a leitura de dados fornecidos pelo usuário.

### **`abilities`**

Contém as habilidades especiais dos personagens.

- `Ability` – classe abstrata base para habilidades.
- `HealAbility` – recuperação parcial de vida (Ladybug).
- `DoubleDamageAbility` – próximo ataque causa dano dobrado (Cat Noir).
- `ShieldAbility` – bloqueia um ataque recebido (Carapace).
- `HintAbility` – revela uma alternativa incorreta (Rena Rouge).
- `SecondChanceAbility` – permite responder novamente após um erro (Viperion).
- `TimeFreezeAbility` – ignora o limite de tempo de uma pergunta (Vesperia).

## Justificativas de Design
O projeto foi desenvolvido seguindo os princípios da Programação Orientada a Objetos, buscando modularidade, reutilização de código e facilidade de manutenção.

A classe `BattleManager` atua como controlador principal da aplicação, sendo responsável por coordenar o fluxo da batalha e a interação entre os demais componentes do sistema.

Para representar os personagens do jogo foi utilizada uma hierarquia de herança baseada na classe abstrata `Character`, que concentra atributos e comportamentos comuns. Dessa forma, diferentes tipos de personagens podem ser implementados sem duplicação de código.

Além da hierarquia de personagens, foi criada a hierarquia de habilidades baseada na classe abstrata `Ability`. Cada personagem possui uma habilidade específica implementada em uma subclasse própria, permitindo reutilização de código e aplicação de polimorfismo.

O sistema de perguntas foi modelado a partir da classe abstrata `Question` e expandido para suportar diferentes modalidades de pergunta, incluindo perguntas de múltipla escolha (`MultipleChoiceQuestion`), verdadeiro ou falso (`TrueFalseQuestion`), temporizadas (`TimedMultipleChoiceQuestion` e `TimedTrueFalseQuestion`) e questões com múltiplas respostas corretas (`MultipleAnswerQuestion`), mantendo compatibilidade com a estrutura base fornecida. Essa abordagem utiliza polimorfismo e facilita a inclusão de novos tipos de perguntas futuramente.

O gerenciamento das questões é realizado pela classe `QuestionBank`, responsável por armazenar e disponibilizar perguntas durante a execução do jogo.

As classes `Player` e `Enemy` encapsulam as informações dos participantes da batalha, enquanto `ScoreSystem` centraliza o controle da pontuação.

Para evitar repetição de código relacionada à entrada de dados, foi criada a classe utilitária `InputHandler`, responsável pela comunicação entre o sistema e o usuário.

Essa organização favorece a separação de responsabilidades entre as classes, melhora a legibilidade do código e facilita futuras extensões do projeto.

## UML - Diagrama de classe
Organização visual da arquitetura do nosso projeto:

```mermaid
classDiagram

%% =====================================================
%% PACOTE CHARACTERS - PERSONAGENS
%% =====================================================
    class Character {
        <<abstract>>
        # nomePersonagem : String
        # hp : int
        # ataque : int
        # defesa : int
   	+ estaVivo() boolean
	+ receberDano(dano:int) int
	+ atacar(alvo:Character) void
    }

    class PersonagemBasico
    class PersonagemAlternativo

    Character <|-- PersonagemBasico
    Character <|-- PersonagemAlternativo

    class Player {
        - nomeUsuario : String
        - pontuacao : int
	- personagemSelecionado : Character
        + selecionarPersonagem()
        + responderPergunta()
    }

    class Enemy {
    - personagemInimigo : Character
    }

Player --> Character
Enemy --> Character

%% =====================================================
%% PACOTE QUESTIONS - PERGUNTAS
%% =====================================================
    class Question {
        <<abstract>>
        # enunciado : String
        # respostaCorreta : String
        # dificuldade : int
    	+ verificarResposta(respostaJogador:String) boolean
   	+ exibirPergunta() void
    	+ exibirAlternativas() void
    }

    class MultipleChoiceQuestion {
        - alternativas : String[]
    }

    class TrueFalseQuestion

    Question <|-- MultipleChoiceQuestion
    Question <|-- TrueFalseQuestion

    class QuestionBank {
        - perguntas : ArrayList<Question>
	- carregarPergunta() void
        + getPerguntaAleatoria() Question
    }

    QuestionBank "1" o-- "*" Question

%% =====================================================
%% PACOTE CORE
%% =====================================================
    class Game {
	+ main() void
    }
    
    class BattleManager {
    	- jogador : Player
   	- inimigo : Enemy
   	- bancoDePerguntas : QuestionBank
	- input : InputHandler
   	- score : ScoreSystem
   	- rodada : Round
        + iniciarBatalha() void
	- finalizarBatalha() void
    }

    class Round {
	- input : InputHandler
        + jogarRodada() void
    }

    class ScoreSystem {
        - pontuacaoTotal : int
        + adicionarPontos() void
    }

    Game --> BattleManager

    BattleManager --> Player
    BattleManager --> Enemy
    BattleManager --> QuestionBank
    BattleManager --> ScoreSystem
    BattleManager --> Round

    Round "1" --> "1" Question
    Round --> Player
    Round --> Enemy

%% =====================================================
%% PACOTE UTILS
%% =====================================================
    class InputHandler {
	- scanner : Scanner
        + lerString() String
	+ lerInteiro() int
	+ esperarEnter() void
	+ imprimirLinha() void
	+ fechar() void
    }


BattleManager ..> InputHandler
Round ..> InputHandler
Game ..> InputHandler

%% =====================================================
%% PACOTE ABILITIES
%% =====================================================
    class Ability {
        <<future feature>>
    }
```
