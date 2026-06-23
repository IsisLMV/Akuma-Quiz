/*Controla o fluxo de batalha de uma fase específica, rodando as rodadas de perguntas até que algum HP chegue a zero*/
package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.Question;
import game.utils.InputHandler;

public class BattleManager {
    private Player jogador;
    private Level fase;
    private Enemy vilao;
    private ScoreSystem score;
    private Round rodada;

    public BattleManager(Player jogador, Level fase, InputHandler input, ScoreSystem score) {
        this.jogador = jogador;
        this.fase = fase;
        this.vilao = fase.getVilao();
        this.score = score;
        this.rodada = new Round(input);
    }

    public ResultadoBatalha iniciarBatalha() {
        System.out.println("\nBATALHA EM ANDAMENTO:\n" + fase.getNome() + ": " + jogador.getNomeUsuario() + " VS " + vilao.getPersonagem().getNomePersonagem());
        
        //loop principal da batalha: continua as rodadas enquanto jogador estiver vivo (com resistência)
        while (jogador.getPersonagemSelecionado().estaVivo() && vilao.getPersonagem().estaVivo()) {
            
            //puxa uma pergunta respeitando a progressão de dificuldade colocada em Level.java
            Question perguntaAtual = fase.getProximaPergunta();
            //caso acabe o limite de questões por fase
            if (perguntaAtual == null) {
                return ResultadoBatalha.DERROTA_LIMITE_PERGUNTAS;
            }
            //salva a resistência (HP) do vilão antes da rodada para saber se o jogador acertou a pergunta
            int hpvilaoAntes = vilao.getPersonagem().getHp();
            
            //roda o turno
            rodada.jogarRodada(jogador, vilao, perguntaAtual);

            //se o vilao tomou dano (HP diminuiu), o jogador ganha pontos
            if (vilao.getPersonagem().getHp() < hpvilaoAntes) {
                //multiplica a dificuldade da pergunta por 10 para dar os pontos
                score.adicionarPontosFase(10 * perguntaAtual.getDificuldade());
            }
        }

        if (!vilao.getPersonagem().estaVivo()) {
            score.adicionarPontosTotal();
            return ResultadoBatalha.VITORIA;
        }
        
        return ResultadoBatalha.DERROTA_JOGADOR;
    }
}