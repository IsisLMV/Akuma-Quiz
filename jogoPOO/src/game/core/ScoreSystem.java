package game.core;

//Gerencia a pontuação do jogador durante o jogo
public class ScoreSystem {
    private int pontuacaoTotal;

    public ScoreSystem() {
        this.pontuacaoTotal = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontuacaoTotal += pontos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }
}
