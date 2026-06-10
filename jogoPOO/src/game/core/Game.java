package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.characters.Ladybug;
import game.characters.CatNoir;
import game.characters.Carapace;
import game.characters.RenaRouge;
import game.characters.Viperion;
import game.characters.Vesperia;
import game.characters.VilaoBoss;
import game.questions.QuestionBank;
import game.utils.InputHandler;

//Classe principal que inicializa as dependências e roda o fluxo global do Show do Conhecimento
public class Game {

    public static void main(String[] args) {
        // 1. Inicializando os sistemas globais
        InputHandler input = new InputHandler();
        ScoreSystem score = new ScoreSystem();
        QuestionBank bancoDePerguntas = new QuestionBank();

        // 2. Tela de Boas-vindas
        input.imprimirLinha();
        System.out.println("Bem-vindo(a) a *nome a ser definido*!");
        input.imprimirLinha();

        String nome = input.lerString("Digite seu nome de jogador:");

        // 3. Escolha de Personagem (Usando Polimorfismo)
        System.out.println("\nEscolha seu participante:");
        System.out.println("1 - Ladybug \nResistência: 1000 | Ataque: 220 | Defesa: 50 \nhabilidade: Miraculous Ladybug (regeneração parcial de vida)\n");
        System.out.println("2 - Cat Noir \nResistência: 900 | Ataque: 300 | Defesa: 40 \nhabilidade: Cataclismo (ataque causa dano dobrado)\n");
        System.out.println("3 - Carapace \nResistência: 1200 | Ataque: 150 | Defesa: 80 \nhabilidade: Proteção (escudo temporário para bloquear ataque)\n");
        System.out.println("4 - Rena Rouge \nResistência: 900 | Ataque: 220 | Defesa: 40 \nhabilidade: Realidade (revelar uma alternativa errada)\n");
        System.out.println("5 - Viperion \nResistência: 1000 | Ataque: 200 | Defesa: 50 \nhabilidade: Segunda chance (segunda tentativa para acertar uma pergunta)\n");
        System.out.println("6 - Vesperia \nResistência: 950 | Ataque: 250 | Defesa: 40 \nhabilidade: Ferroada (ignora tempo limite de perguntas cronometradas)\n");
        int escolha = input.lerInteiro("Sua escolha:", 1, 6);

        game.characters.Character personagemEscolhido; // Declarando pela superclasse
        switch (escolha) {
            case 1:
                personagemEscolhido = new Ladybug();
                break;
            case 2:
                personagemEscolhido = new CatNoir();
                break;
            case 3:
                personagemEscolhido = new Carapace();
                break;
            case 4:
                personagemEscolhido = new RenaRouge();
                break;
            case 5:
                personagemEscolhido = new Viperion();
                break;
            case 6:
                personagemEscolhido = new Vesperia();
                break;
            default:
                personagemEscolhido = new Ladybug();
        }

        // 4. Criação do Jogador e do Inimigo
        Player jogador = new Player(nome, personagemEscolhido);
        
        Enemy inimigo = new Enemy(new VilaoBoss());

        // 5. Instanciando e iniciando a batalha
        BattleManager batalha = new BattleManager(jogador, inimigo, bancoDePerguntas, input, score);
        batalha.iniciarBatalha();

        // 6. Fim de jogo
        System.out.println("\nObrigado por participar! Volte sempre!");
        input.fechar();
    }
}
