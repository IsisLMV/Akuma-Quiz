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
import game.exceptions.PerguntaIndisponivelException;

public class Game {

    public static void main(String[] args) {
        //inicializando os sistemas globais
        InputHandler input = new InputHandler();
        ScoreSystem score = new ScoreSystem();
        GameStats stats = new GameStats();
        QuestionBank bancoDePerguntas = new QuestionBank();

        //tela de boas-vindas e contextualização
        input.imprimirLinha();
        System.out.println("Bem-vindo(a) ao Akuma Quiz!");
        input.imprimirLinha();

        System.out.println("\nHawk Moth percebeu que a maior força dos portadores dos Miraculous não é apenas física, mas também mental.");
        System.out.println("Para derrotá-los de vez, ele elaborou um plano: akumatizar alguns cidadãos de Paris para corromper e congelar o conhecimento científico, histórico e educacional do mundo.");
        System.out.println("Para restaurar a ordem, os heróis precisam provar que suas mentes continuam afiadas e que a sua disposição para aprender constantemente é maior do que qualquer magia sombria.\n");
        input.imprimirLinha();

        System.out.println("\nChegou a sua hora de entrar em ação!\n");
        String nome = input.lerString("Digite seu nome de jogador:");

        //escolha de personagem
        System.out.println("\nEscolha seu herói:");
        System.out.println("1 - Ladybug \nResistência: 1000 | Ataque: 220 | Defesa: 50 \nHabilidade: Miraculous Ladybug (regeneração parcial de vida)\n");
        System.out.println("2 - Cat Noir \nResistência: 900 | Ataque: 280 | Defesa: 40 \nHabilidade: Cataclismo (ataque causa dano dobrado)\n");
        System.out.println("3 - Carapace \nResistência: 1200 | Ataque: 180 | Defesa: 80 \nHabilidade: Proteção (escudo temporário para bloquear ataque)\n");
        System.out.println("4 - Rena Rouge \nResistência: 900 | Ataque: 220 | Defesa: 40 \nHabilidade: Realidade (revelar uma alternativa errada)\n");
        System.out.println("5 - Viperion \nResistência: 1000 | Ataque: 200 | Defesa: 50 \nHabilidade: Segunda chance (segunda tentativa para acertar uma pergunta)\n");
        System.out.println("6 - Vesperia \nResistência: 950 | Ataque: 250 | Defesa: 40 \nHabilidade: Ferroada (ignora tempo limite de perguntas cronometradas)\n");
        int escolha = input.lerInteiro("Sua escolha:", 1, 6);

        Character personagemEscolhido = CharacterFactory.criar(escolha); //declarando na superclasse

        //criação do jogador
        Player jogador = new Player(nome, personagemEscolhido);

        //criação das fases
        Level fase1 = new Level("FASE 1", new Enemy(new VilaoF1()), 1); //fáceis cronometradas
        Level fase2 = new Level("FASE 2", new Enemy(new VilaoF2()), 2); //médias cronometradas
        Level fase3 = new Level("FASE 3", new Enemy(new VilaoF3()), 3); //difíceis cronometradas
        Level faseFinal = new Level("FASE FINAL", new Enemy(new VilaoBoss()), true); //única fase completamente cronometrada

        //carregar perguntas nas fases (todas vêm do mesmo banco, mas as fases recebem perguntas diferentes)
        try {
            carregarPerguntas(fase1, bancoDePerguntas, 8, 8, 4);
            carregarPerguntas(fase2, bancoDePerguntas, 4, 10, 6);
            carregarPerguntas(fase3, bancoDePerguntas, 4, 4, 12);
            carregarPerguntas(faseFinal, bancoDePerguntas, 2, 6, 12);

        } catch (PerguntaIndisponivelException e) {
            input.imprimirLinha();
            System.out.println("Erro ao montar as fases do jogo:");
            System.out.println(e.getMessage());
            System.out.println("Verifique se o banco de perguntas possui questões suficientes.");
            input.imprimirLinha();

            input.fechar();
            return;
        }

        //jogar campanha
        jogarFaseComRetry(jogador, fase1, input, score, stats);
        jogarFaseComRetry(jogador, fase2, input, score, stats);
        jogarFaseComRetry(jogador, fase3, input, score, stats);
        jogarFaseComRetry(jogador, faseFinal, input, score, stats);

        //final (estatísticas finais)
        exibirTelaFinal(jogador, score, stats, input);
        input.fechar();
    }

    private static void jogarFaseComRetry(Player jogador, Level fase, InputHandler input, ScoreSystem score, GameStats stats) {
            input.imprimirLinha();
            System.out.println(fase.getNome());
            System.out.println();
            System.out.println(fase.getContexto());
            System.out.println();
            System.out.println(fase.getFraseMotivacional());
            input.imprimirLinha();
            input.esperarEnter();
        
        boolean venceu = false;
        while (!venceu) {
            stats.registrarTentativa();
            fase.reset();
            jogador.getPersonagemSelecionado().restaurarEstado();
            score.iniciarNovaFase();
            BattleManager batalha = new BattleManager(jogador, fase, input, score, stats);
            ResultadoBatalha resultado = batalha.iniciarBatalha();
            switch (resultado) {
                case VITORIA:
                    venceu = true;
                    stats.registrarFaseConcluida();
                    break;

                case DERROTA_JOGADOR:
                    input.imprimirLinha();
                    System.out.println();
                    System.out.println(fase.getFraseDerrota());
                    System.out.println();
                    input.imprimirLinha();
                    System.out.println("DERROTA... Você ficou sem resistência!");
                    break;

                case DERROTA_LIMITE_PERGUNTAS:
                    input.imprimirLinha();
                    System.out.println();
                    System.out.println(fase.getFraseDerrota());
                    System.out.println();
                    input.imprimirLinha();
                    System.out.println("DERROTA... As perguntas da fase acabaram antes que o vilão fosse derrotado!");
                    break;
            }
            if (!venceu) {
                System.out.println("\nVocê perdeu " + fase.getNome() + ". Tentando novamente...");
                input.imprimirLinha();
            }
        }
        if (venceu){
            input.imprimirLinha();
            System.out.println();
            System.out.println(fase.getFraseVitoria());
            System.out.println();
            input.imprimirLinha();
            System.out.println("\t\t\t\t\t\t\t\t\tVITÓRIA! Você derrotou " + fase.getVilao().getPersonagem().getNomePersonagem() + "!");
            System.out.println("\t\t\t\t\t\t\t\tCheckpoint concluído: " + fase.getNome());
            System.out.println("\t\t\t\t\t\t\t\tPontuação da fase: " + score.getPontuacaoFase());
            System.out.println("\t\t\t\t\t\t\t\tPontuação total: " + score.getPontuacaoTotal());
            input.imprimirLinha();
        }
    }
    private static void carregarPerguntas(Level fase, QuestionBank banco, int faceis, int medias, int dificeis) throws PerguntaIndisponivelException {
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
    private static void exibirTelaFinal(Player jogador, ScoreSystem score, GameStats stats, InputHandler input) {
        input.imprimirLinha();
        System.out.println("\t\t\t\t\t\t\t\t\t======AKUMA QUIZ======");
        System.out.println("\t\t\t\t\t\t\t\t\tZEROU! MISSÃO CONCLUÍDA!");
        input.imprimirLinha();
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\tHerói: " + jogador.getPersonagemSelecionado().getNomePersonagem());
        System.out.println("\t\t\t\t\t\t\t\tJogador(a): " + jogador.getNomeUsuario());
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\tPontuação total: " + score.getPontuacaoTotal());
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\tFases concluídas: " + stats.getFasesConcluidas());
        System.out.println("\t\t\t\t\t\t\t\tVilões derrotados: " + stats.getFasesConcluidas());
        System.out.println("\t\t\t\t\t\t\t\tTentativas totais: " + stats.getTentativas());
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\tPerguntas respondidas: " + stats.getPerguntasRespondidas());
        System.out.println("\t\t\t\t\t\t\t\tAcertos: " + stats.getAcertos());
        System.out.println("\t\t\t\t\t\t\t\tErros: " + stats.getErros());
        System.out.printf("\t\t\t\t\t\t\t\tTaxa de acerto: %.2f%%\n", stats.calcularTaxaAcerto());
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\tParabéns! Você zerou o jogo!");
        input.imprimirLinha();
    }
}