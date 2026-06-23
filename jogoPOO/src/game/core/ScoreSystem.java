/*Gerencia a pontuação do jogador durante o jogo*/
package game.core;


public class ScoreSystem {
    /*atributos*/
    private int pontuacaoFase;
    private int pontuacaoTotal;


    /*construtor*/
    public ScoreSystem() {
        this.pontuacaoFase = 0;
        this.pontuacaoTotal = 0;
    }


    /*métodos*/
    public void iniciarNovaFase() {
        pontuacaoFase = 0;
    }

    public void adicionarPontosFase(int pontos) {
        pontuacaoFase += pontos;
    }

    public void adicionarPontosTotal() {
        pontuacaoTotal += pontuacaoFase;
    }

    public int getPontuacaoFase() {
        return pontuacaoFase;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }
}