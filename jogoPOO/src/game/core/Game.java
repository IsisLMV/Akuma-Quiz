package game.core;

import game.characters.Player;
import game.characters.Enemy;
import game.characters.PersonagemBasico;
import game.characters.PersonagemAlternativo;
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
        System.out.println("Bem-vindo ao Show do Conhecimento: Edição Torta na Cara!");
        input.imprimirLinha();

        String nome = input.lerString("Digite seu nome de jogador:");

        // 3. Escolha de Personagem (Usando Polimorfismo)
        System.out.println("\nEscolha seu participante:");
        System.out.println("1 - Participante Padrão (Resistência: 100, Tamanho da Torta: 20, Esquiva: 10)");
        System.out.println("2 - Participante Ágil (Resistência: 80, Tamanho da Torta: 30, Esquiva: 5)");
        int escolha = input.lerInteiro("Sua escolha:", 1, 2);

        game.characters.Character personagemEscolhido; // Declarando pela superclasse
        if (escolha == 1) {
            personagemEscolhido = new PersonagemBasico();
        } else {
            personagemEscolhido = new PersonagemAlternativo();
        }

        // 4. Criação do Jogador e do Inimigo
        Player jogador = new Player(nome, personagemEscolhido);
        
        // Vamos criar um inimigo usando o PersonagemBasico para esta primeira batalha
        Enemy inimigo = new Enemy(new PersonagemBasico());

        // 5. Instanciando e iniciando a batalha
        BattleManager batalha = new BattleManager(jogador, inimigo, bancoDePerguntas, input, score);
        batalha.iniciarBatalha();

        // 6. Fim de jogo
        System.out.println("\nObrigado por participar do Show do Conhecimento! Limpe o chantilly do rosto e volte sempre!");
        input.fechar(); // Lembrar de fechar o Scanner
    }
}
