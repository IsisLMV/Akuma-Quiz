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

        //habilidade da Rena Rouge
        if (jogador.getPersonagemSelecionado().isMiragemAtiva()) {
            String errada = pergunta.obterAlternativaErrada();
            if (errada != null) {
                System.out.println("Uma ilusão revelou uma alternativa errada!");
                System.out.println("A alternativa " + errada + " está errada.");
            } else {
                System.out.println("A habilidade não conseguiu ajudar nesse tipo de pergunta.");
            }
            jogador.getPersonagemSelecionado().desativarMiragem();
        }

        //lê a resposta do jogador e, se preciso, calcula o tempo
        long tempoInicio = System.currentTimeMillis();
        String resposta = input.lerString("\nSua resposta para questão:");
        long tempoFim = System.currentTimeMillis();
        long tempoGasto = (tempoFim - tempoInicio) / 1000;
        boolean acertou = pergunta.verificarResposta(resposta);

        //habilidade do Viperion
        if (!acertou && jogador.getPersonagemSelecionado().isSegundaChanceAtiva()) {
            System.out.println("\n🐍 SEGUNDA CHANCE!");
            System.out.println("Você errou, mas sua habilidade te ajudou a voltar no tempo para antes de você errar!");
            jogador.getPersonagemSelecionado().desativarSegundaChance();
            tempoInicio = System.currentTimeMillis();
            resposta = input.lerString("\nTente novamente:");
            tempoFim = System.currentTimeMillis();
            tempoGasto = (tempoFim - tempoInicio) / 1000;
            acertou = pergunta.verificarResposta(resposta);
        }

        //verificação se a resposta está dentro do tempo e não estava com a habilidade da Vesperia ativa
        if (pergunta instanceof TimedQuestion && !jogador.getPersonagemSelecionado().isTempoCongelado()) {
            TimedQuestion perguntaComTempo = (TimedQuestion) pergunta;
            if (tempoGasto > perguntaComTempo.getTempoLimite()) {
                System.out.println("\nTEMPO ESGOTADO!");
                acertou = false;
            }
        }

        //voltar a ter cronômetro para quem estiver com a Vesperia
        jogador.getPersonagemSelecionado().desativarTempoCongelado();

        //lógica de ataques do jogo
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