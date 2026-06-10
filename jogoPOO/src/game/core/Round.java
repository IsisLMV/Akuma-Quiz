/*Representa uma rodada única do programa (uma pergunta e o consequente ataque)*/
package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.Question;
import game.utils.InputHandler;
import game.interfaces.TimedQuestion;

/*Para a entrega 2, ainda no console, as perguntas com tempo não estão 100% precisas com a cronometragem*/



public class Round {
    private InputHandler input;

    //Recebe o InputHandler via construtor para reaproveitar o mesmo Scanner do jogo
    public Round(InputHandler input) {
        this.input = input;
    }

    public void jogarRodada(Player jogador, Enemy inimigo, Question pergunta) {
        input.imprimirLinha();
        System.out.println("--- NOVA PERGUNTA ---");
        
        System.out.println("Resistência de " + jogador.getNomeUsuario() + ": " + jogador.getPersonagemSelecionado().getHp() + " | Resistência do Adversário: " + inimigo.getPersonagem().getHp());
        input.imprimirLinha();

        // Exibe o enunciado e as alternativas
        pergunta.exibirPergunta();

        //identificaçao de perguntas com tempo (pergunta pela interface) e aviso para os players no terminal
        if (pergunta instanceof TimedQuestion) {
            TimedQuestion perguntaComTempo = (TimedQuestion) pergunta;
        
            System.out.println("!! PERGUNTA RELÂMPAGO !!");
            System.out.println("Tempo limite: "+ perguntaComTempo.getTempoLimite()+ " segundos");
        }

        if (jogador.getPersonagemSelecionado().getHabilidade() != null) {

            System.out.println("\nHabilidade disponível:");
            System.out.println("★ " + jogador.getPersonagemSelecionado().getHabilidade().getNome());

            System.out.println("Deseja usar a habilidade?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int escolha = input.lerInteiro("Escolha", 1, 2);

            if (escolha == 1) {

                if (jogador.getPersonagemSelecionado().getHabilidade().podeUsar()) {
                    jogador.getPersonagemSelecionado().getHabilidade().ativar(jogador, inimigo);
                } else {
                    System.out.println("Essa habilidade não possui mais usos.");
                }
            }
        }

        //lê a resposta do jogador e, se preciso, calcula o tempo
        long tempoInicio = System.currentTimeMillis();
        String resposta = input.lerString("\nSua resposta para questão:");
        long tempoFim = System.currentTimeMillis();
        long tempoGasto = (tempoFim - tempoInicio) / 1000;
        boolean acertou = pergunta.verificarResposta(resposta);

        //verificação se a resposta está dentro do tempo
        if (pergunta instanceof TimedQuestion) {
        TimedQuestion perguntaComTempo = (TimedQuestion) pergunta;
        if (tempoGasto > perguntaComTempo.getTempoLimite()) {
            System.out.println("\nTEMPO ESGOTADO!");
            acertou = false;
        }
    }
        // Lógica do jogo
        if (acertou) {
            System.out.println("\nResposta Correta!");
            System.out.println("POU! Você atacou o adversário!");
            int dano = jogador.getPersonagemSelecionado().calcularDano(pergunta.getDificuldade());
            inimigo.getPersonagem().receberDano(dano);
        } else {
            System.out.println("\nResposta Errada! A resposta certa era: " + pergunta.getRespostaCerta());
            System.out.println("UI! O adversário aproveitou que você errou e te acertou!");
            inimigo.getPersonagem().atacar(jogador.getPersonagemSelecionado());
        }
        
        // Pausa para o jogador ler o resultado antes de limpar a tela para a próxima pergunta
        input.esperarEnter();
    }
}