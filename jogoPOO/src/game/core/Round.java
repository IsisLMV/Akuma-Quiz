package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.Question;
import game.utils.InputHandler;

// Representa uma rodada única da batalha (uma pergunta e seu resultado)
public class Round {
    private InputHandler input;

    // Recebe o InputHandler via construtor para reaproveitar o mesmo Scanner do jogo
    public Round(InputHandler input) {
        this.input = input;
    }

    public void jogarRodada(Player jogador, Enemy inimigo, Question pergunta) {
        input.imprimirLinha();
        System.out.println("--- NOVA RODADA ---");
        // Mostra o HP atual dos personagens usando os getters criados
        System.out.println("HP " + jogador.getNomeUsuario() + ": " + jogador.getPersonagemSelecionado().getHp() + 
                           " | HP Inimigo: " + inimigo.getPersonagem().getHp());
        input.imprimirLinha();

        // Exibe o enunciado e as alternativas
        pergunta.exibirPergunta();
        
        // Lê a resposta do jogador
        String resposta = input.lerString("\nSua resposta:");

        // Lógica do jogo
        if (pergunta.verificarResposta(resposta)) {
            System.out.println("\n Resposta Correta!");
            System.out.println("Você atacou o inimigo!");
            jogador.getPersonagemSelecionado().atacar(inimigo.getPersonagem());
        } else {
            System.out.println("\n Resposta Errada! A resposta certa era: " + pergunta.getRespostaCerta());
            System.out.println("O inimigo aproveitou sua falha e atacou você!");
            inimigo.getPersonagem().atacar(jogador.getPersonagemSelecionado());
        }
        
        // Pausa para o jogador ler o resultado antes de limpar a tela para a próxima pergunta
        input.esperarEnter();
    }
}
