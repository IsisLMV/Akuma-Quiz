# Jogo-LPOO-nomeProvisorio-

(README em andamento)

## Estrutura do Projeto

## Justificativas de Design


## UML - Diagrama de classe
Organização visual da arquitetura do nosso projeto:

```mermaid
classDiagram

%% =====================================================
%% PACOTE CHARACTERS - PERSONAGENS
%% =====================================================
namespace characters {
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
}
%% =====================================================
%% PACOTE QUESTIONS - PERGUNTAS
%% =====================================================
namespace questions {
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
}
%% =====================================================
%% PACOTE CORE
%% =====================================================
namespace core {
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
}
%% =====================================================
%% PACOTE UTILS
%% =====================================================
namespace utils {
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
}
%% =====================================================
%% PACOTE ABILITIES
%% =====================================================

namespace abilities {

    class Ability {
        <<future feature>>
    }

}
```
