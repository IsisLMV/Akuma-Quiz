/*Representa uma rodada única do programa (uma pergunta e o consequente ataque)*/
package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.Question;
import game.utils.InputHandler;

/*No console, a cronometragem depende do tempo de digitação do jogador.*/

public class Round {
    //atributo
    private InputHandler input;

    //recebe o InputHandler via construtor para reaproveitar o mesmo Scanner do jogo
    public Round(InputHandler input) {
        this.input = input;
    }

    public void jogarRodada(Player jogador, Enemy inimigo, Question pergunta) {
        input.imprimirLinha();
        System.out.println("--- NOVA PERGUNTA ---");
        
        System.out.println("Resistência de " + jogador.getNomeUsuario() + ": " + jogador.getPersonagemSelecionado().getHp() + " | Resistência do Adversário: " + inimigo.getPersonagem().getHp());
        input.imprimirLinha();

        //exibe o enunciado e as alternativas
        pergunta.exibirPergunta();

        //identificaçao de perguntas com tempo ativado e aviso para os players no terminal
        if (pergunta.possuiTempo()) {
            System.out.println("!! PERGUNTA RELÂMPAGO !!");
            System.out.println("Tempo limite: " + pergunta.getTempoLimite() + " segundos");
        }

        //uso de habilidade
        if (jogador.getPersonagemSelecionado().getHabilidade() != null && jogador.getPersonagemSelecionado().getHabilidade().podeUsar()) {

            System.out.println("\nHabilidade disponível:");
            System.out.println("★ " + jogador.getPersonagemSelecionado().getHabilidade().getNome());

            System.out.println("Deseja usar a habilidade?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int escolha = input.lerInteiro("Escolha: ", 1, 2);

            if (escolha == 1) {
                    jogador.getPersonagemSelecionado().getHabilidade().ativar(jogador, inimigo);
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

        //primeira tentativa
        //lê a resposta do jogador e, se preciso, calcula o tempo
        long tempoInicio = System.currentTimeMillis();
        String resposta = input.lerString("\nSua resposta para questão:");
        //saber se o tempo estourou depende de não estar usando a habilidade da Vesperia
        boolean passouDoTempo = !jogador.getPersonagemSelecionado().isTempoCongelado() && pergunta.tempoEsgotado(tempoInicio);
        boolean acertou = !passouDoTempo && pergunta.verificarResposta(resposta);
        if (passouDoTempo) {
            System.out.println("\nTEMPO ESGOTADO!");
        }

        //habilidade do Viperion
        if (!acertou && jogador.getPersonagemSelecionado().isSegundaChanceAtiva()) {
            System.out.println("\nSEGUNDA CHANCE!");
            System.out.println("Você errou, mas sua habilidade te ajudou a voltar no tempo para antes de você errar!");
            jogador.getPersonagemSelecionado().desativarSegundaChance();
            tempoInicio = System.currentTimeMillis();
            resposta = input.lerString("\nTente novamente:");
            passouDoTempo = !jogador.getPersonagemSelecionado().isTempoCongelado() && pergunta.tempoEsgotado(tempoInicio);
            acertou = !passouDoTempo && pergunta.verificarResposta(resposta);

            if (passouDoTempo) {
                System.out.println("\nTEMPO ESGOTADO!");
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
        
        //pausa para o jogador ler o resultado antes da próxima pergunta
        input.esperarEnter();
    }
}