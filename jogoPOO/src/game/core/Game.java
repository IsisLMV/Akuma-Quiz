/*Classe principal que inicializa as dependências e roda o fluxo global do jogo*/
package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.characters.Character;
import game.characters.CharacterFactory;
import game.characters.VilaoBoss;
import game.characters.VilaoF1;
import game.characters.VilaoF2;
import game.characters.VilaoF3;
import game.questions.QuestionBank;
import game.utils.InputHandler;

public class Game {

    public static void main(String[] args) {
        //inicializando os sistemas globais
        InputHandler input = new InputHandler();
        ScoreSystem score = new ScoreSystem();
        QuestionBank bancoDePerguntas = new QuestionBank();

        //tela de boas-vindas
        input.imprimirLinha();
        System.out.println("Bem-vindo(a) a *nome a ser definido*!");
        input.imprimirLinha();

        String nome = input.lerString("Digite seu nome de jogador:");

        //escolha de personagem
        System.out.println("\nEscolha seu participante:");
        System.out.println("1 - Ladybug \nResistência: 1000 | Ataque: 220 | Defesa: 50 \nhabilidade: Miraculous Ladybug (regeneração parcial de vida)\n");
        System.out.println("2 - Cat Noir \nResistência: 900 | Ataque: 300 | Defesa: 40 \nhabilidade: Cataclismo (ataque causa dano dobrado)\n");
        System.out.println("3 - Carapace \nResistência: 1200 | Ataque: 150 | Defesa: 80 \nhabilidade: Proteção (escudo temporário para bloquear ataque)\n");
        System.out.println("4 - Rena Rouge \nResistência: 900 | Ataque: 220 | Defesa: 40 \nhabilidade: Realidade (revelar uma alternativa errada)\n");
        System.out.println("5 - Viperion \nResistência: 1000 | Ataque: 200 | Defesa: 50 \nhabilidade: Segunda chance (segunda tentativa para acertar uma pergunta)\n");
        System.out.println("6 - Vesperia \nResistência: 950 | Ataque: 250 | Defesa: 40 \nhabilidade: Ferroada (ignora tempo limite de perguntas cronometradas)\n");
        int escolha = input.lerInteiro("Sua escolha:", 1, 6);

        Character personagemEscolhido = CharacterFactory.criar(escolha); //declarando na superclasse

        //criação do jogador
        Player jogador = new Player(nome, personagemEscolhido);

        //criação das fases
        Level fase1 = new Level("Fase 1", new Enemy(new VilaoF1()));
        Level fase2 = new Level("Fase 2", new Enemy(new VilaoF2()));
        Level fase3 = new Level("Fase 3", new Enemy(new VilaoF3()));
        Level faseFinal = new Level("Fase Final", new Enemy(new VilaoBoss()), true); //única fase que tem perguntas cronometradas

        //carregar perguntas nas fases (todas vêm do mesmo banco, mas as fases recebem perguntas diferentes)
        carregarPerguntas(fase1, bancoDePerguntas, 10, 6, 4);
        carregarPerguntas(fase2, bancoDePerguntas, 6, 10, 4);
        carregarPerguntas(fase3, bancoDePerguntas, 4, 6, 10);
        carregarPerguntas(faseFinal, bancoDePerguntas, 2, 8, 10);

        //jogar campanha
        jogarFaseComRetry(jogador, fase1, input, score);
        jogarFaseComRetry(jogador, fase2, input, score);
        jogarFaseComRetry(jogador, fase3, input, score);
        jogarFaseComRetry(jogador, faseFinal, input, score);

        //final
        System.out.println("\nZEROU! Jogo Finalizado!");
        System.out.println("Pontuação total: " + score.getPontuacaoTotal());

        input.fechar();
    }

    private static void jogarFaseComRetry(Player jogador, Level fase, InputHandler input, ScoreSystem score) {
        boolean venceu = false;
        while (!venceu) {
            fase.reset();
            jogador.getPersonagemSelecionado().restaurarEstado();
            score.iniciarNovaFase();
            BattleManager batalha = new BattleManager(jogador, fase, input, score);
            ResultadoBatalha resultado = batalha.iniciarBatalha();
            switch (resultado) {
                case VITORIA:
                    venceu = true;
                    break;

                case DERROTA_JOGADOR:
                    input.imprimirLinha();
                    System.out.println("DERROTA... Você ficou sem resistência!");
                    input.imprimirLinha();
                    break;

                case DERROTA_LIMITE_PERGUNTAS:
                    input.imprimirLinha();
                    System.out.println("DERROTA... As perguntas da fase acabaram antes que o vilão fosse derrotado!");
                    input.imprimirLinha();
                    break;
            }
            if (!venceu) {
                System.out.println("\nVocê perdeu " + fase.getNome() + ". Tentando novamente...");
            }
        }
        if (venceu){
            input.imprimirLinha();
            System.out.println("VITÓRIA! Você derrotou o vilão akumatizado!\n");
            System.out.println("Checkpoint concluído: " + fase.getNome());
            System.out.println("Pontuação da fase: " + score.getPontuacaoFase());
            System.out.println("Pontuação total: " + score.getPontuacaoTotal());
            input.imprimirLinha();
        }
    }
    private static void carregarPerguntas(Level fase, QuestionBank banco, int faceis, int medias, int dificeis) {
        for (int i = 0; i < faceis; i++) {
            fase.adicionarPergunta(banco.getPerguntaAleatoriaPorDificuldade(1));
        }
        for (int i = 0; i < medias; i++) {
            fase.adicionarPergunta(banco.getPerguntaAleatoriaPorDificuldade(2));
        }
        for (int i = 0; i < dificeis; i++) {
            fase.adicionarPergunta(banco.getPerguntaAleatoriaPorDificuldade(3));
        }
    }
}