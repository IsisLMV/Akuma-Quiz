package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.Question;
import game.utils.InputHandler;

// Representa uma rodada única do programa (uma pergunta e a consequente tortada)
public class Round {
    private InputHandler input;

    // Recebe o InputHandler via construtor para reaproveitar o mesmo Scanner do jogo
    public Round(InputHandler input) {
        this.input = input;
    }

    public void jogarRodada(Player jogador, Enemy inimigo, Question pergunta) {
        input.imprimirLinha();
        System.out.println("--- NOVA PERGUNTA ---");
        
        System.out.println("Resistência de " + jogador.getNomeUsuario() + ": " + jogador.getPersonagemSelecionado().getHp() + 
                           " | Resistência do Adversário: " + inimigo.getPersonagem().getHp());
        input.imprimirLinha();

        // Exibe o enunciado e as alternativas
        pergunta.exibirPergunta();
        
        // Lê a resposta do jogador
        String resposta = input.lerString("\nSua resposta:");

        // Lógica do jogo
        if (pergunta.verificarResposta(resposta)) {
            System.out.println("\nResposta Correta!");
            System.out.println("POU! Você jogou uma TORTA NA CARA do adversário!");
            jogador.getPersonagemSelecionado().atacar(inimigo.getPersonagem());
        } else {
            System.out.println("\nResposta Errada! A resposta certa era: " + pergunta.getRespostaCerta());
            System.out.println("SPLASH! O adversário aproveitou que você errou e encheu sua cara de chantilly!");
            inimigo.getPersonagem().atacar(jogador.getPersonagemSelecionado());
        }
        
        // Pausa para o jogador ler o resultado antes de limpar a tela para a próxima pergunta
        input.esperarEnter();
    }
}
