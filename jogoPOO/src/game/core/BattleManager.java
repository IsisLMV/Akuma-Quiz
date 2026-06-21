package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.questions.QuestionBank;
import game.questions.Question;
import game.utils.InputHandler;

//Controla o fluxo do programa, rodando as rodadas de perguntas até que alguém fique coberto de torta (HP chegue a zero)
public class BattleManager {
    private Player jogador;
    private Enemy inimigo;
    private QuestionBank bancoDePerguntas;
    private InputHandler input;
    private ScoreSystem score;
    private Round rodada;

    public BattleManager(Player jogador, Enemy inimigo, QuestionBank banco, InputHandler input, ScoreSystem score) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.bancoDePerguntas = banco;
        this.input = input;
        this.score = score;
        this.rodada = new Round(input);
    }

    public void iniciarBatalha() {
        System.out.println("\nBATALHA EM ANDAMENTO: " + jogador.getNomeUsuario() + " VS " + inimigo.getPersonagem().getNomePersonagem());
        
        // Loop principal da batalha: continua enquanto ambos estiverem vivos (com resistência)
        while (jogador.getPersonagemSelecionado().estaVivo() && inimigo.getPersonagem().estaVivo()) {
            
            // Puxa uma pergunta aleatória do banco de perguntas
            Question perguntaAtual = bancoDePerguntas.getPerguntaAleatoria();
            
            // Salva a resistência (HP) do inimigo antes da rodada para saber se o jogador acertou a pergunta
            int hpInimigoAntes = inimigo.getPersonagem().getHp();
            
            // Roda o turno
            rodada.jogarRodada(jogador, inimigo, perguntaAtual);

            // Se o inimigo tomou dano (HP diminuiu), o jogador ganha pontos
            if (inimigo.getPersonagem().getHp() < hpInimigoAntes) {
                // Multiplica a dificuldade da pergunta por 10 para dar os pontos
                score.adicionarPontos(10 * perguntaAtual.getDificuldade());
            }
        }

        finalizarBatalha();
    }

    private void finalizarBatalha() {
        input.imprimirLinha();
        // Verifica quem sobreviveu para declarar o vencedor
        if (jogador.getPersonagemSelecionado().estaVivo()) {
            System.out.println("VITÓRIA! Você derrotou o vilão akumatizado e salvou a cidade!");
            System.out.println("Pontuação final: " + score.getPontuacaoTotal());
        } else {
            System.out.println("DERROTA... Fim de jogo!");
        }
        input.imprimirLinha();
    }
}
